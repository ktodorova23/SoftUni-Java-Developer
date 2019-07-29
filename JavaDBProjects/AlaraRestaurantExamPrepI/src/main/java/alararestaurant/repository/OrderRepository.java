package alararestaurant.repository;

import alararestaurant.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findOrderByEmployeeName(String name);

    List<Order> findAllByEmployee_NameOrderByEmployeeAscIdAsc(String name);
}
