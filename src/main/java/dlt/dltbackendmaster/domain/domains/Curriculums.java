package domains;
// Generated Jun 13, 2022, 9:28:17 AM by Hibernate Tools 5.4.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Curriculums generated by hbm2java
 */
public class Curriculums implements java.io.Serializable {

	private Integer id;
	private String name;
	private String description;
	private int status;
	private int createdBy;
	private Date dateCreated;
	private Integer updatedBy;
	private Date updateDate;
	private Set curriculumsServiceses = new HashSet(0);

	public Curriculums() {
	}

	public Curriculums(String name, int status, int createdBy, Date dateCreated) {
		this.name = name;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public Curriculums(String name, String description, int status, int createdBy, Date dateCreated, Integer updatedBy,
			Date updateDate, Set curriculumsServiceses) {
		this.name = name;
		this.description = description;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.updatedBy = updatedBy;
		this.updateDate = updateDate;
		this.curriculumsServiceses = curriculumsServiceses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Set getCurriculumsServiceses() {
		return this.curriculumsServiceses;
	}

	public void setCurriculumsServiceses(Set curriculumsServiceses) {
		this.curriculumsServiceses = curriculumsServiceses;
	}

}
