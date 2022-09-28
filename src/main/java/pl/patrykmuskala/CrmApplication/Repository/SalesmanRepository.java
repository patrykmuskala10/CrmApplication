package pl.patrykmuskala.CrmApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patrykmuskala.CrmApplication.Model.Salesman;

@Repository
public interface SalesmanRepository extends JpaRepository<Salesman, Integer> {
    Iterable<Salesman> findAllByName(String name);
    Iterable<Salesman> findAllBySurname(String name);
    Iterable<Salesman> findAllByTeam_Name(String name);
}
