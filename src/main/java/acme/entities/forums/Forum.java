
package acme.entities.forums;

import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.entities.Authenticated;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Forum extends DomainEntity {

	private static final long			serialVersionUID	= 1L;

	@NotBlank
	private String						title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date						creationDate;

	@NotEmpty
	@ElementCollection(targetClass = Authenticated.class, fetch = FetchType.EAGER)
	private Collection<Authenticated>	involvedUsers;

	// Relationships

	@Valid
	@ManyToOne(optional = false)
	private Authenticated				owner;

	@Valid
	@OneToOne(optional = true)
	private InvestmentRound				investmentRound;

}
