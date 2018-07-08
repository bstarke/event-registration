package net.starkenberg.event.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Brad Starkenberg
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Event implements Serializable{
	
	private static final long serialVersionUID = -4214356824391413153L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true, nullable=false)
	private LocalDate eventDate;
	private boolean active;
	private boolean registrationOpen;
	@CreatedDate
	private LocalDateTime createDate;
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

	/**
	 * @return the eventDate
	 */
	public LocalDate getEventDate() {
		return eventDate;
	}
	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	/**
	 * @return the registrationOpen
	 */
	public boolean isRegistrationOpen() {
		return registrationOpen;
	}
	/**
	 * @param registrationOpen the registrationOpen to set
	 */
	public void setRegistrationOpen(boolean registrationOpen) {
		this.registrationOpen = registrationOpen;
	}

	/**
	 * @return days until the event
	 */
	public int getDaysToEvent() {
		return LocalDate.now().until(eventDate).getDays();
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
