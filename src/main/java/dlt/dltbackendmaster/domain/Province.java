package dlt.dltbackendmaster.domain;
// Generated Jun 13, 2022, 9:37:47 AM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Province generated by hbm2java
 */
@Entity
@Table(name = "province", catalog = "dreams_db")
@NamedQueries({
    @NamedQuery(name = "Province.findAll", query = "SELECT u FROM Province u"),
    @NamedQuery(name = "Province.findByStatus", query = "SELECT p FROM Province p where p.status = :status"),
    @NamedQuery(name = "Province.findByIds", query = "SELECT c FROM Province c WHERE c.id in (:provinces)")})
public class Province implements java.io.Serializable {

	private Integer id;
	private String code;
	private String name;
	private int status;
	private int createdBy;
	private Date createDate;
	private Integer updatedBy;
	private Date updateDate;
	private Set<District> districts = new HashSet<District>(0);

	public Province() {
	}

	public Province(String code, String name, int status, int createdBy, Date createDate) {
		this.code = code;
		this.name = name;
		this.status = status;
		this.createdBy = createdBy;
		this.createDate = createDate;
	}

	public Province(String code, String name, int status, int createdBy, Date createDate, Integer updatedBy,
			Date updateDate, Set<District> districts) {
		this.code = code;
		this.name = name;
		this.status = status;
		this.createdBy = createdBy;
		this.createDate = createDate;
		this.updatedBy = updatedBy;
		this.updateDate = updateDate;
		this.districts = districts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "code", nullable = false, length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@JsonIgnore
	@Column(name = "created_by", nullable = false)
	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false, length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@JsonIgnore
	@Column(name = "updated_by")
	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 19)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "province")
	public Set<District> getDistricts() {
		return this.districts;
	}

	public void setDistricts(Set<District> districts) {
		this.districts = districts;
	}
	
	public ObjectNode toObjectNode() {
		ObjectMapper mapper = new ObjectMapper();
		
		ObjectNode province = mapper.createObjectNode();
		province.put("id", id);
		province.put("name", name);
		province.put("code", code);
		province.put("status", status);
		province.put("online_id", id); // flag to control if entity is synchronized with the backend
		return province;
	} 

}
