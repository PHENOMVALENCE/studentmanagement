/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2025
 *  Created on Aug 11, 2025
 */

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
