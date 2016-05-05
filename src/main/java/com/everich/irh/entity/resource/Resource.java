package com.everich.irh.entity.resource;
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
import com.everich.irh.entity.authority.Authority;
@Entity
@Table(name = "resource", catalog = "irhtest")
public class Resource implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	private String content;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "authority_resource", catalog = "irhtest", joinColumns = {@JoinColumn(name = "resource_id", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "authority_id", nullable = false, updatable = false)})
	private Set<Authority> authorities = new HashSet<Authority>();

	public Resource() {
		super();
	}

	public Resource(Integer id, String content, Set<Authority> authorities) {
		super();
		this.id = id;
		this.content = content;
		this.authorities = authorities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
}
