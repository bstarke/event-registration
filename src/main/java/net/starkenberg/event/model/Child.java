package net.starkenberg.event.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Child implements Serializable{

	private static final long serialVersionUID = -4214356824391413153L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Guardian guardian;
	@NotNull
	private String name;
	@NotNull
	private LocalDate birthDate;
	private Boolean specialNeeds = false;
	@CreatedDate
	private LocalDateTime createDate;
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		if(name != null && !name.isEmpty()) {
			this.name = StringUtils.trimWhitespace(name).toLowerCase();
		} else {
			this.name = name;
		}
	}

	/**
	 * @return the guardian
	 */
	public Guardian getGuardian() {
		return guardian;
	}

	/**
	 * @param guardian
	 *            the guardian to set
	 */
	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}

	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the specialNeeds
	 */
	public Boolean getSpecialNeeds() {
		return specialNeeds;
	}

	/**
	 * @param specialNeeds
	 *            the specialNeeds to set
	 */
	public void setSpecialNeeds(Boolean specialNeeds) {
		this.specialNeeds = specialNeeds;
	}
	
	public Integer getAge() {
		LocalDate today = LocalDate.now();
		return ((int) ChronoUnit.YEARS.between(birthDate, today));
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
