
package acme.features.administrator.banner;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Banner;
import acme.entities.creditCards.CreditCard;
import acme.features.administrator.creditCard.AdministratorCreditCardRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorBannerCreateService implements AbstractCreateService<Administrator, Banner> {

	@Autowired
	AdministratorBannerRepository		repository;

	@Autowired
	AdministratorCreditCardRepository	creditCardRepository;


	@Override
	public boolean authorise(final Request<Banner> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Banner> request, final Banner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Banner> request, final Banner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "target");
		model.setAttribute("creditCardId", null);
		model.setAttribute("creditCards", this.creditCardRepository.findMany());

	}

	@Override
	public Banner instantiate(final Request<Banner> request) {
		Banner res;

		res = new Banner();

		return res;
	}

	@Override
	public void validate(final Request<Banner> request, final Banner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (errors.hasErrors()) {
			Set<CreditCard> creditCards = new HashSet<CreditCard>(this.creditCardRepository.findMany());

			if (request.getModel().getAttribute("creditCardId") != "") {

				CreditCard cc = this.creditCardRepository.findOneById(Integer.parseInt((String) request.getModel().getAttribute("creditCardId")));
				int id = cc.getId();
				String number = cc.getNumber();

				request.getModel().setAttribute("creditCardId", id);
				request.getModel().setAttribute("creditCardNumber", number);
				creditCards.remove(cc);
			}
			request.getModel().setAttribute("creditCards", creditCards);
		}
	}

	@Override
	public void create(final Request<Banner> request, final Banner entity) {
		assert request != null;
		assert entity != null;

		String creditCardId = (String) request.getModel().getAttribute("creditCardId");
		if (creditCardId != "") {
			Integer creditId = new Integer(creditCardId);
			entity.setCreditCard(this.creditCardRepository.findOneById(creditId));
		}
		this.repository.save(entity);
	}

}
