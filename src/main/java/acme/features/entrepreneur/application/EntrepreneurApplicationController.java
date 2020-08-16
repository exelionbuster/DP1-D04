
package acme.features.entrepreneur.application;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.applications.Application;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/entrepreneur/application")
public class EntrepreneurApplicationController extends AbstractController<Entrepreneur, Application> {

	//	Internal states -------------

	@Autowired
	private EntrepreneurApplicationListByInvestmentRoundService	listByInvestmentRoundService;

	@Autowired
	private EntrepreneurApplicationShowService					showService;


	//	Constructors ------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_BY_INVESTMENT_ROUND, BasicCommand.LIST, this.listByInvestmentRoundService);
	}
}
