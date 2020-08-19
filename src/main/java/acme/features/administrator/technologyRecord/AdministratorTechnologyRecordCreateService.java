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

package acme.features.administrator.technologyRecord;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.technologyRecords.TechnologyRecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorTechnologyRecordCreateService implements AbstractCreateService<Administrator, TechnologyRecord> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AdministratorTechnologyRecordRepository repository;


	// AbstractListService<Authenticated, TechnologyRecord> interface --------------

	@Override
	public boolean authorise(final Request<TechnologyRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<TechnologyRecord> request, final TechnologyRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<TechnologyRecord> request, final TechnologyRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Set<String> sectors = new HashSet<String>(Arrays.asList(this.repository.findActivitySectors().split(";")));
		sectors = sectors.stream().map(String::trim).collect(Collectors.toSet());

		model.setAttribute("sectors", sectors);

		request.unbind(entity, model, "title", "activitySector", "inventor", "description", "webSite", "email", "openSource", "stars");

	}

	@Override
	public TechnologyRecord instantiate(final Request<TechnologyRecord> request) {
		assert request != null;

		TechnologyRecord result;

		result = new TechnologyRecord();

		return result;
	}

	@Override
	public void validate(final Request<TechnologyRecord> request, final TechnologyRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Set<String> sectors = new HashSet<String>(Arrays.asList(this.repository.findActivitySectors().split(";")));
		sectors = sectors.stream().map(String::trim).collect(Collectors.toSet());
		if (entity.getActivitySector() != null) {
			sectors.remove(entity.getActivitySector());
		}

		request.getModel().setAttribute("sectors", sectors);
	}

	@Override
	public void create(final Request<TechnologyRecord> request, final TechnologyRecord entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}
}
