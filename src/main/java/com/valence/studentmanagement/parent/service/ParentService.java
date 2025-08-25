
package com.valence.studentmanagement.parent.service;

import java.util.List;
import java.util.Optional;

import com.valence.studentmanagement.parent.model.Parent;

public interface ParentService {
	List<Parent> list();
	Optional<Parent> select(String email);
	boolean create(Parent entity);
	boolean update(Parent entity);
	boolean delete(String email);
}
