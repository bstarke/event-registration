package net.starkenberg.event.repository;

import net.starkenberg.event.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Brad Starkenberg
 *
 */
@RepositoryRestResource(collectionResourceRel = "children", path = "children")
public interface ChildRepository extends JpaRepository<Child, Long> {

}
