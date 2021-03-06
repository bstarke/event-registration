package net.starkenberg.event.repository;

import net.starkenberg.event.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Brad Starkenberg
 *
 */
@RepositoryRestResource
public interface EventRepository extends JpaRepository<Event, Long> {

	Event findByActive(@Param("active") boolean isActive);
	
	Event findByActiveIsTrue();
	
}
