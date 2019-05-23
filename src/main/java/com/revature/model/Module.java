package com.revature.model;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="MODULE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Module {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="moduleId")
	private long moduleId;
	
	@Column(name="modulename")
	private String moduleName;
	
	@Column(name="active")
	private boolean active;
	
	@Column(name="created")
	@CreationTimestamp
	private Date created;
	
	@Column(name="updated")
	@UpdateTimestamp
	private Date updated;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "module_tag_jt", joinColumns = @JoinColumn(name = "moduleId"), inverseJoinColumns = @JoinColumn(name = "tagId"))
	private List<Tag> tags;
	
	public Module() {
		super();
	}

	public Module(long moduleId, String moduleName, boolean active, Date created, Date updated) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.active = active;
		this.created = created;
		this.updated = updated;
	}



	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + (int) (moduleId ^ (moduleId >>> 32));
		result = prime * result + ((moduleName == null) ? 0 : moduleName.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (active != other.active)
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (moduleId != other.moduleId)
			return false;
		if (moduleName == null) {
			if (other.moduleName != null)
				return false;
		} else if (!moduleName.equals(other.moduleName))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", moduleName=" + moduleName + ", active=" + active + ", created="
				+ created + ", updated=" + updated + "]";
	}

}
