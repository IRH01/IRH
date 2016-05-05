package com.everich.irh.entity.role;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.everich.irh.entity.authority.Authority;
import com.everich.irh.entity.user.Users;
@Entity
@Table(name = "role", catalog = "irhtest")
public class Role implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	private String roleName;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", catalog = "irhtest", joinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)})
	private Set<Users> useres = new HashSet<Users>();
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "role_authority", catalog = "irhtest", joinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "authority_id", nullable = false, updatable = false)})
	private Set<Authority> authorities = new HashSet<Authority>();

	public Role() {
		super();
	}
	

	public Role(Integer id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}


	public Role(Integer id, String roleName, Set<Users> useres,
			Set<Authority> authorities) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.useres = useres;
		this.authorities = authorities;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Users> getUseres() {
		return useres;
	}

	public void setUseres(Set<Users> useres) {
		this.useres = useres;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
}