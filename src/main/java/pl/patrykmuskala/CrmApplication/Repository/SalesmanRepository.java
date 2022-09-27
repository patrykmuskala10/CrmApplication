package pl.patrykmuskala.CrmApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patrykmuskala.CrmApplication.Model.Salesman;

@Repository
public interface SalesmanRepository extends JpaRepository<Salesman, Integer> {
}
