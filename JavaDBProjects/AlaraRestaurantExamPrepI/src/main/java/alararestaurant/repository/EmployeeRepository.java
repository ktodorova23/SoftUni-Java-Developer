package alararestaurant.repository;

import alararestaurant.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findEmployeeByName(String name);

//    @Query("select e from Employee e join e.position as p where p.name = :name")
    List<Employee> findAllByPositionName(String name);
}
