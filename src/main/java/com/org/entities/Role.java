package com.org.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(name = "name")
	private Roles roleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Roles getRoleName() {
		return roleName;
	}

	public void setRoleName(Roles roleName) {
		this.roleName = roleName;
	}
}
