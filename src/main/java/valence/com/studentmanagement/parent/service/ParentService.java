package valence.com.studentmanagement.parent.service;

import java.util.List;

import valence.com.studentmanagement.parent.model.Parent;



public interface ParentService {
    // Define service methods here
    List<Parent> getAllParents();
    Parent getParentById(int id);
    Parent createParent(Parent parent);
    Parent updateParent(int id, Parent parent);
    void deleteParent(int id);

    
    
}
