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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * District generated by hbm2java
 */
@Entity
@Table(name = "district", catalog = "dreams_db")
@NamedQueries({
	@NamedQuery(name = "District.findAll", query = "SELECT u FROM District u"),
    @NamedQuery(name = "District.findByProvinces", query = "SELECT c FROM District c WHERE c.province.id in (:provinces) and c.status=1")})
public class District implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Province province;
	private String code;
	private String name;
	private int status;
	private int createdBy;
	private Date dateCreated;
	private Integer updatedBy;
	private Date dateUpdated;
	private Set<Partners> partnerses = new HashSet<Partners>(0);
	private Set<Locality> localities = new HashSet<Locality>(0);

	public District() {
	}

	public District(Province province, String code, String name, int status, int createdBy, Date dateCreated) {
		this.province = province;
		this.code = code;
		this.name = name;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public District(Province province, String code, String name, int status, int createdBy, Date dateCreated,
			Integer updatedBy, Date dateUpdated, Set<Partners> partnerses, Set<Locality> localities) {
		this.province = province;
		this.code = code;
		this.name = name;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.updatedBy = updatedBy;
		this.dateUpdated = dateUpdated;
		this.partnerses = partnerses;
		this.localities = localities;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "province_id", nullable = false)
	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
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
	@Column(name = "date_created", nullable = false, length = 19)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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
	@Column(name = "date_updated", length = 19)
	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "district")
	public Set<Partners> getPartnerses() {
		return this.partnerses;
	}

	public void setPartnerses(Set<Partners> partnerses) {
		this.partnerses = partnerses;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "district")
	public Set<Locality> getLocalities() {
		return this.localities;
	}

	public void setLocalities(Set<Locality> localities) {
		this.localities = localities;
	}

	public ObjectNode toObjectNode() {
		ObjectMapper mapper = new ObjectMapper();
		
		ObjectNode district = mapper.createObjectNode();
		district.put("id", id);
		district.put("name", name);
		district.put("code", code);
		district.put("province_id", province.getId());
		district.put("status", status);
		district.put("online_id", id); // flag to control if entity is synchronized with the backend
		return district;
	} 
}
