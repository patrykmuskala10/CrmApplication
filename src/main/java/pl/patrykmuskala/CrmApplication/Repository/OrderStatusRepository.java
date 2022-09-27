package pl.patrykmuskala.CrmApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.patrykmuskala.CrmApplication.Model.OrderStatus;

@Repository

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
}
