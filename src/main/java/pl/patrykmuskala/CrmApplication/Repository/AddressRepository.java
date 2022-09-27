package pl.patrykmuskala.CrmApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patrykmuskala.CrmApplication.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
