package insurance.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import insurance.management.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository< Policy,Long> {

}
