

package com.valence.studentmanagement.parent.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valence.studentmanagement.parent.model.Parent;
import com.valence.studentmanagement.parent.repository.ParentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {
 private final ParentRepository repo;
	@Override
	public List<Parent> list() {
		try {
			return repo.findAll();
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return new ArrayList<>();
		}
	}

	@Override
	public Optional<Parent> select(String email) {
		try {
			return repo.findByEmail(email);
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return Optional.empty();
		}
	}

	@Override
	public boolean create(Parent entity) {
		try {
			repo.save(entity);
			return true;
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return false;
		}
	}

	@Override
	public boolean update(Parent entity) {
		try {
			repo.save(entity);
			return true;
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean delete(String email) {
		try {
			repo.deleteByEmail(email);
			return true;
		}catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			return false;
		}
	}

}
