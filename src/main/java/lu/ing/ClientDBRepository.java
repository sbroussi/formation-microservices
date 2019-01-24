package lu.ing;

import lu.ing.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data scan and detects JpaRepository.
 */
public interface ClientDBRepository extends JpaRepository<Client, Long> {

}
