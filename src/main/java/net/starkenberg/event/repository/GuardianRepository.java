package net.starkenberg.event.repository;

import net.starkenberg.event.model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author Brad Starkenberg
 *
 */
@RepositoryRestResource()
public interface GuardianRepository extends JpaRepository<Guardian, Long> {

	Guardian findByEmail(@Param("email") String email);

	List<Guardian> findByLastName(@Param("name") String name);

	List<Guardian> findByFirstNameAndLastName(@Param("firstName") String firstName,
			@Param("lastName") String lastName);

}
