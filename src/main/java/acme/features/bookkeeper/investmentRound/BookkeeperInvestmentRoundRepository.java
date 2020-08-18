
package acme.features.bookkeeper.investmentRound;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;

import acme.entities.inquiries.Inquiry;
import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

public interface BookkeeperInvestmentRoundRepository extends AbstractRepository {

	@Query("select distinct ar.investmentRound from AccountingRecord ar where ar.bookkeeper.id=?1")
	Collection<InvestmentRound> findInvolvedInvestmentRound(int id);

	@Query("select distinct ar.investmentRound from AccountingRecord ar where ar.bookkeeper.id<>?1")
	Collection<InvestmentRound> findNotInvolvedInvestmentRound(int id);

	@Query("select a from Inquiry a where a.id = ?1")
	Inquiry findOneById(int id);
}
