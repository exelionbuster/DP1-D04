
package acme.features.administrator.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	private AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Integer numberOfNotices = this.repository.numberOfNotices();
		Integer numberOfTechnologyRecords = this.repository.numberOfTechnologyRecords();
		Integer numberOfToolRecords = this.repository.numberOfToolRecords();

		List<Object[]> activeInquiriesMinMoneyStats = new ArrayList<Object[]>(this.repository.activeInquiriesMinMoneyStats());
		Double minimumMinMoneyActiveInquiries = (Double) activeInquiriesMinMoneyStats.get(0)[0];
		Double maximumMinMoneyActiveInquiries = (Double) activeInquiriesMinMoneyStats.get(0)[1];
		Double avgMinMoneyActiveInquiries = (Double) activeInquiriesMinMoneyStats.get(0)[2];
		Double stddevMinMoneyActiveInquiries = (Double) activeInquiriesMinMoneyStats.get(0)[3];

		List<Object[]> activeInquiriesMaxMoneyStats = new ArrayList<Object[]>(this.repository.activeInquiriesMaxMoneyStats());
		Double minimumMaxMoneyActiveInquiries = (Double) activeInquiriesMaxMoneyStats.get(0)[0];
		Double maximumMaxMoneyActiveInquiries = (Double) activeInquiriesMaxMoneyStats.get(0)[1];
		Double avgMaxMoneyActiveInquiries = (Double) activeInquiriesMaxMoneyStats.get(0)[2];
		Double stddevMaxMoneyActiveInquiries = (Double) activeInquiriesMaxMoneyStats.get(0)[3];

		List<Object[]> activeOverturesMinMoneyStats = new ArrayList<Object[]>(this.repository.activeOverturesMinMoneyStats());
		Double minimumMinMoneyActiveOvertures = (Double) activeOverturesMinMoneyStats.get(0)[0];
		Double maximumMinMoneyActiveOvertures = (Double) activeOverturesMinMoneyStats.get(0)[1];
		Double avgMinMoneyActiveOvertures = (Double) activeOverturesMinMoneyStats.get(0)[2];
		Double stddevMinMoneyActiveOvertures = (Double) activeOverturesMinMoneyStats.get(0)[3];

		List<Object[]> activeOverturesMaxMoneyStats = new ArrayList<Object[]>(this.repository.activeOverturesMaxMoneyStats());
		Double minimumMaxMoneyActiveOvertures = (Double) activeOverturesMaxMoneyStats.get(0)[0];
		Double maximumMaxMoneyActiveOvertures = (Double) activeOverturesMaxMoneyStats.get(0)[1];
		Double avgMaxMoneyActiveOvertures = (Double) activeOverturesMaxMoneyStats.get(0)[2];
		Double stddevMaxMoneyActiveOvertures = (Double) activeOverturesMaxMoneyStats.get(0)[3];

		List<Object[]> techRecordsSectorAndNumber = new ArrayList<>(this.repository.techRecordsBySector());
		List<String> techRecordsSectors = new ArrayList<>();
		List<Long> techRecordsBySector = new ArrayList<>();
		for (Object[] trsector : techRecordsSectorAndNumber) {
			techRecordsSectors.add((String) trsector[0]);
			techRecordsBySector.add((Long) trsector[1]);
		}

		List<Object[]> toolRecordsSectorAndNumber = new ArrayList<>(this.repository.toolRecordsBySector());
		List<String> toolRecordsSectors = new ArrayList<>();
		List<Long> toolRecordsBySector = new ArrayList<>();
		for (Object[] trsector : toolRecordsSectorAndNumber) {
			toolRecordsSectors.add((String) trsector[0]);
			toolRecordsBySector.add((Long) trsector[1]);
		}

		List<Integer> techRecordsLicence = new ArrayList<>(this.repository.techRecordsLicence());

		List<Integer> toolRecordsLicence = new ArrayList<>(this.repository.toolRecordsLicence());

		entity.setNumberOfNotices(numberOfNotices);
		entity.setNumberOfTechnologyRecords(numberOfTechnologyRecords);
		entity.setNumberOfToolRecords(numberOfToolRecords);

		entity.setMinimumMinMoneyActiveInquiries(minimumMinMoneyActiveInquiries);
		entity.setMaximumMinMoneyActiveInquiries(maximumMinMoneyActiveInquiries);
		entity.setAvgMinMoneyActiveInquiries(avgMinMoneyActiveInquiries);
		entity.setStddevMinMoneyActiveInquiries(stddevMinMoneyActiveInquiries);

		entity.setMinimumMaxMoneyActiveInquiries(minimumMaxMoneyActiveInquiries);
		entity.setMaximumMaxMoneyActiveInquiries(maximumMaxMoneyActiveInquiries);
		entity.setAvgMaxMoneyActiveInquiries(avgMaxMoneyActiveInquiries);
		entity.setStddevMaxMoneyActiveInquiries(stddevMaxMoneyActiveInquiries);

		entity.setMinimumMinMoneyActiveOvertures(minimumMinMoneyActiveOvertures);
		entity.setMaximumMinMoneyActiveOvertures(maximumMinMoneyActiveOvertures);
		entity.setAvgMinMoneyActiveOvertures(avgMinMoneyActiveOvertures);
		entity.setStddevMinMoneyActiveOvertures(stddevMinMoneyActiveOvertures);

		entity.setMinimumMaxMoneyActiveOvertures(minimumMaxMoneyActiveOvertures);
		entity.setMaximumMaxMoneyActiveOvertures(maximumMaxMoneyActiveOvertures);
		entity.setAvgMaxMoneyActiveOvertures(avgMaxMoneyActiveOvertures);
		entity.setStddevMaxMoneyActiveOvertures(stddevMaxMoneyActiveOvertures);

		entity.setTechRecordsSectors(techRecordsSectors);
		entity.setTechRecordsBySector(techRecordsBySector);

		entity.setTechRecordsLicence(techRecordsLicence);

		entity.setToolRecordsSectors(toolRecordsSectors);
		entity.setToolRecordsBySector(toolRecordsBySector);

		entity.setToolRecordsLicence(toolRecordsLicence);

		request.unbind(entity, model, "numberOfNotices", "numberOfTechnologyRecords", "numberOfToolRecords", 
			"minimumMinMoneyActiveInquiries", "maximumMinMoneyActiveInquiries", "avgMinMoneyActiveInquiries", "stddevMinMoneyActiveInquiries", 
			"minimumMaxMoneyActiveInquiries", "maximumMaxMoneyActiveInquiries", "avgMaxMoneyActiveInquiries", "stddevMaxMoneyActiveInquiries", 
			"minimumMinMoneyActiveOvertures", "maximumMinMoneyActiveOvertures", "avgMinMoneyActiveOvertures", "stddevMinMoneyActiveOvertures",
			"minimumMaxMoneyActiveOvertures", "maximumMaxMoneyActiveOvertures", "avgMaxMoneyActiveOvertures", "stddevMaxMoneyActiveOvertures", 
			"techRecordsSectors", "techRecordsBySector", "techRecordsLicence", "toolRecordsSectors", "toolRecordsBySector", "toolRecordsLicence");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		Dashboard d = new Dashboard();
		return d;
	}

}
