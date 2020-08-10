/*
 * AdministratorUserAccountListService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.challenge;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AdministratorChallengeRepository repository;


	// AbstractCreateService<Administrator, Challenge> interface --------------

	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "rookieGoal", "rookieReward", "averageGoal", "averageReward", "expertGoal", "expertReward");

	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		Challenge result;

		result = new Challenge();

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean validDeadline = true;
		Boolean nullEARewards = false;
		Boolean nullARRewards = false;
		Date now = new Date(System.currentTimeMillis());

		if (errors.hasErrors("expertReward")) {
			nullEARewards = true;
			errors.state(request, false, "expertReward", "administrator.challenge.form.error.null-currency");
		} else {
			errors.state(request, entity.getExpertReward().getCurrency().equals("€"), "expertReward", "administrator.challenge.form.error.null-currency");
		}

		if (errors.hasErrors("averageReward")) {
			nullEARewards = true;
			nullARRewards = true;
			errors.state(request, false, "averageReward", "administrator.challenge.form.error.null-currency");
		} else {
			errors.state(request, entity.getAverageReward().getCurrency().equals("€"), "averageReward", "administrator.challenge.form.error.null-currency");
		}

		if (errors.hasErrors("rookieReward")) {
			nullARRewards = true;
			errors.state(request, false, "rookieReward", "administrator.challenge.form.error.null-currency");
		} else {
			errors.state(request, entity.getRookieReward().getCurrency().equals("€"), "rookieReward", "administrator.challenge.form.error.null-currency");
		}

		if (!nullEARewards) {
			errors.state(request, entity.getExpertReward().getAmount() >= entity.getAverageReward().getAmount(), "expertReward", "administrator.challenge.form.error.expert-reward");
		}
		if (!nullARRewards) {
			errors.state(request, entity.getAverageReward().getAmount() >= entity.getRookieReward().getAmount(), "averageReward", "administrator.challenge.form.error.average-reward");
		}

		if (errors.hasErrors("deadline")) {
			validDeadline = false;
			errors.state(request, false, "deadline", "administrator.challenge.form.error.timestamp");
		}

		if (validDeadline) {
			errors.state(request, entity.getDeadline().after(now), "deadline", "administrator.challenge.form.error.past-deadline");
		}
	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
