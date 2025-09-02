package valence.com.studentmanagement.service.parent;

import java.util.List;

import valence.com.studentmanagement.model.Parent;



public interface ParentService {
    // Define service methods here
    List<Parent> getAllParents();
    Parent getParentById(int id);
    Parent createParent(Parent parent);
    Parent updateParent(int id, Parent parent);
    void deleteParent(int id);
    int countAllParents();

    

    
    
}
