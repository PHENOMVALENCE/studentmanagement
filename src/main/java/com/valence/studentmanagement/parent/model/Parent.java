package com.valence.studentmanagement.parent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Parent {
	@Id
	private long id;
	private String name;
	private String email;
}
