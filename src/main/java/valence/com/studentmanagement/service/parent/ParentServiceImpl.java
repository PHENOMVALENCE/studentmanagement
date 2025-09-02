package valence.com.studentmanagement.service.parent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import valence.com.studentmanagement.model.Parent;
import valence.com.studentmanagement.repository.ParentRepository;

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentRepository parentRepository;

    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public Parent getParentById(int id) {
        return parentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteParent(int id) {
        parentRepository.deleteById(id);
    }

    @Override
    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);

    }

    @Override
    public Parent updateParent(int id, Parent parent) {
        if (parentRepository.existsById(id)) {
            parent.setId(id);
            return parentRepository.save(parent);
        }
        return null;
    }

      @Override
    public int countAllParents() {
        return (int) parentRepository.count();
    }

    

}
