package pl.patrykmuskala.CrmApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patrykmuskala.CrmApplication.Model.Panel;


@Repository

public interface PanelRepository extends JpaRepository<Panel, Integer> {

    Iterable<Panel> findAllByManufacturer(String manufacturer);
}
