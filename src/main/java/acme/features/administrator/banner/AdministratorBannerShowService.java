
package acme.features.administrator.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Banner;
import acme.features.administrator.creditCard.AdministratorCreditCardRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorBannerShowService implements AbstractShowService<Administrator, Banner> {

	@Autowired
	AdministratorBannerRepository		respository;

	@Autowired
	AdministratorCreditCardRepository	creditCardRepository;


	@Override
	public boolean authorise(final Request<Banner> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Banner> request, final Banner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "target");

		if (entity.getCreditCard() != null) {

			int id = entity.getCreditCard().getId();
			String number = entity.getCreditCard().getNumber();

			model.setAttribute("creditCardId", id);
			model.setAttribute("creditCardNumber", number);
			model.setAttribute("creditCards", this.creditCardRepository.findManyButOne(id));

		} else {

			model.setAttribute("creditCards", this.creditCardRepository.findMany());

		}
	}

	@Override
	public Banner findOne(final Request<Banner> request) {
		assert request != null;

		Banner res;
		int id;
		id = request.getModel().getInteger("id");

		res = this.respository.findOneById(id);
		return res;
	}

}
