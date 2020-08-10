
package acme.features.administrator.dashboard;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(n) from Notice n")
	Integer numberOfNotices();

	@Query("select count(tr) from TechnologyRecord tr")
	Integer numberOfTechnologyRecords();

	@Query("select count(tr) from ToolRecord tr")
	Integer numberOfToolRecords();

	@Query("select min(ai.minMoney.amount), max(ai.minMoney.amount), avg(ai.minMoney.amount), stddev(ai.minMoney.amount) from Inquiry ai")
	Collection<Object[]> activeInquiriesMinMoneyStats();

	@Query("select min(ai.maxMoney.amount), max(ai.maxMoney.amount), avg(ai.maxMoney.amount), stddev(ai.maxMoney.amount) from Inquiry ai")
	Collection<Object[]> activeInquiriesMaxMoneyStats();

	@Query("select min(ao.minMoney.amount), max(ao.minMoney.amount), avg(ao.minMoney.amount), stddev(ao.minMoney.amount) from Overture ao")
	Collection<Object[]> activeOverturesMinMoneyStats();

	@Query("select min(ao.maxMoney.amount), max(ao.maxMoney.amount), avg(ao.maxMoney.amount), stddev(ao.maxMoney.amount) from Overture ao")
	Collection<Object[]> activeOverturesMaxMoneyStats();

	@Query("select tr.activitySector, count(tr) from TechnologyRecord tr group by tr.activitySector")
	Collection<Object[]> techRecordsBySector();

	@Query("select tr.activitySector, count(tr) from ToolRecord tr group by tr.activitySector")
	Collection<Object[]> toolRecordsBySector();

	@Query("select count(tr) from TechnologyRecord tr group by tr.openSource")
	Collection<Integer> techRecordsLicence();

	@Query("select count(tr) from ToolRecord tr group by tr.openSource")
	Collection<Integer> toolRecordsLicence();
}
