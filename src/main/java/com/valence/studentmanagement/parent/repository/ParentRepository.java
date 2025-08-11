/*
 *  Author            : Salum Sinare
 *  Author id         : A243345
 *  Author email      : salum.sinare@stanbic.co.tz
 *  Organization      : Stanbic Bank Tanzania LTD
 *  Organization Unit : Software Engineering
 *  Copyright (C) 2025
 *  Created on Aug 11, 2025
 */

package com.valence.studentmanagement.parent.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valence.studentmanagement.parent.model.Parent;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
	Optional<Parent> findByEmail(String email);

	void deleteByEmail(String email);

}
