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
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.node.ObjectNode;

import dlt.dltbackendmaster.serializers.UsTypeSerializer;

/**
 * Us generated by hbm2java
 */
@Entity
@Table(name = "us", catalog = "dreams_db")
@NamedQueries({
    @NamedQuery(name = "Us.findAll", query = "SELECT c FROM Us c"),
    @NamedQuery(name = "Us.findByLocalities", query = "SELECT u FROM Us u where u.localityId in (:localities) and u.status=1"),
    @NamedQuery(name = "Us.findByDateCreated", query = "SELECT c FROM Us c WHERE c.dateCreated = :lastpulledat"),
    @NamedQuery(name = "Us.findByDateUpdated", query = "SELECT c FROM Us c WHERE c.dateUpdated = :lastpulledat")})
public class Us implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
    
    private Integer id;
	private UsType usType;
	private String code;
	private String name;
	private String description;
	private Float latitude;
	private Float longitude;
	private int localityId;
	private int status;
	private int createdBy;
	private Date dateCreated;
	private Integer updatedBy;
	private Date dateUpdated;
	private Set<BeneficiariesInterventions> beneficiariesInterventionses = new HashSet<BeneficiariesInterventions>(0);
	private Set<Beneficiaries> beneficiarieses = new HashSet<Beneficiaries>(0);

	public Us() {
	}

	public Us(UsType usType, String code, String name, int localityId, int status, int createdBy, Date dateCreated) {
		this.usType = usType;
		this.code = code;
		this.name = name;
		this.localityId = localityId;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public Us(UsType usType, String code, String name, String description, Float latitude, Float longitude,
			int localityId, int status, int createdBy, Date dateCreated, Integer updatedBy, Date dateUpdated,
			Set<BeneficiariesInterventions> beneficiariesInterventionses, 
			Set<Beneficiaries> beneficiarieses) {
		this.usType = usType;
		this.code = code;
		this.name = name;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.localityId = localityId;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.updatedBy = updatedBy;
		this.dateUpdated = dateUpdated;
		this.beneficiariesInterventionses = beneficiariesInterventionses;
		this.beneficiarieses = beneficiarieses;
	}
	
	public Us(Integer id) {
		this.id = id;
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
	@JoinColumn(name = "us_type_id", nullable = false)
	@JsonProperty("usType")
	@JsonSerialize(using=UsTypeSerializer.class)
	public UsType getUsType() {
		return this.usType;
	}

	public void setUsType(UsType usType) {
		this.usType = usType;
	}

	@Column(name = "code", nullable = false, length = 150)
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

	@Column(name = "description", length = 250)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "latitude", precision = 12, scale = 0)
	public Float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude", precision = 12, scale = 0)
	public Float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	@Column(name = "locality_id", nullable = false)
	public int getLocalityId() {
		return this.localityId;
	}

	public void setLocalityId(int localityId) {
		this.localityId = localityId;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "created_by", nullable = false)
	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created", nullable = false, length = 19)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Column(name = "updated_by")
	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_updated", length = 19)
	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "us")
	public Set<BeneficiariesInterventions> getBeneficiariesInterventionses() {
		return this.beneficiariesInterventionses;
	}

	public void setBeneficiariesInterventionses(Set<BeneficiariesInterventions> beneficiariesInterventionses) {
		this.beneficiariesInterventionses = beneficiariesInterventionses;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "us")
	public Set<Beneficiaries> getBeneficiarieses() {
		return this.beneficiarieses;
	}

	public void setBeneficiarieses(Set<Beneficiaries> beneficiarieses) {
		this.beneficiarieses = beneficiarieses;
	}
	
	public ObjectNode toObjectNode() {
		ObjectMapper mapper = new ObjectMapper();
		
		ObjectNode profile = mapper.createObjectNode();
		profile.put("id", id);
		profile.put("name", name);
		profile.put("description", description);
		profile.put("status", status);
		profile.put("online_id", id); // flag to control if entity is synchronized with the backend
		return profile;
	} 

}
