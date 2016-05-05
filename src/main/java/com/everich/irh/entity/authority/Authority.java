package com.everich.irh.entity.authority;
import static javax.persistence.GenerationType.IDENTITY;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.everich.irh.entity.resource.Resource;
import com.everich.irh.entity.role.Role;
@Entity
@Table(name = "authority", catalog = "irhtest")
public class Authority implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	private String authorityname;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "role_authority", catalog = "irhtest", joinColumns = {@JoinColumn(name = "authority_id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)})
	private Set<Role> roles = new HashSet<Role>();
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "authority_resource", catalog = "irhtest", joinColumns = {@JoinColumn(name = "authority_id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "resource_id", nullable = false, updatable = false)})
	private Set<Resource> resources = new HashSet<Resource>();

	public Authority() {
		super();
	}

	public Authority(Integer id, String authorityname, Set<Role> roles, Set<Resource> resources) {
		super();
		this.id = id;
		this.authorityname = authorityname;
		this.roles = roles;
		this.resources = resources;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorityname() {
		return authorityname;
	}

	public void setAuthorityname(String authorityname) {
		this.authorityname = authorityname;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
}
