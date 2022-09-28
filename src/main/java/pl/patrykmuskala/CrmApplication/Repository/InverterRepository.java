package pl.patrykmuskala.CrmApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patrykmuskala.CrmApplication.Model.Inverter;

@Repository

public interface InverterRepository extends JpaRepository<Inverter, Integer> {

    Iterable<Inverter> findAllByManufacturer(String manufacturer);
}
