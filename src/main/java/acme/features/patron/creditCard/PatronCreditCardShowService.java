
package acme.features.patron.creditCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.creditCards.CreditCard;
import acme.entities.roles.Patron;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class PatronCreditCardShowService implements AbstractShowService<Patron, CreditCard> {

	@Autowired
	PatronCreditCardRepository repository;


	@Override
	public boolean authorise(final Request<CreditCard> request) {
		assert request != null;

		boolean res;
		int creditCardId;
		CreditCard creditCard;
		Patron patron;
		Principal principal;

		creditCardId = request.getModel().getInteger("id");
		creditCard = this.repository.findOneById(creditCardId);
		patron = creditCard.getPatron();
		principal = request.getPrincipal();
		res = patron.getUserAccount().getId() == principal.getAccountId();

		return res;
	}

	@Override
	public void unbind(final Request<CreditCard> request, final CreditCard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "holderName", "number", "brand", "expirationDate", "cvv");

	}

	@Override
	public CreditCard findOne(final Request<CreditCard> request) {
		assert request != null;
		CreditCard res;
		int id;
		id = request.getModel().getInteger("id");
		res = this.repository.findOneById(id);
		return res;
	}

}
