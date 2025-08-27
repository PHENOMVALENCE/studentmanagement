package valence.com.studentmanagement.parent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import valence.com.studentmanagement.parent.model.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {

    

    
}
