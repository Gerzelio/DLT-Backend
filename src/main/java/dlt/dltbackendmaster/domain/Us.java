package dlt.dltbackendmaster.domain;
// Generated Jun 13, 2022, 9:37:47 AM by Hibernate Tools 5.2.12.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.node.ObjectNode;

import dlt.dltbackendmaster.serializers.LocalitySerializer;
import dlt.dltbackendmaster.serializers.UsTypeSerializer;

/**
 * Us generated by hbm2java
 */
@Entity
@Table(name = "us", catalog = "dreams_db")
@NamedQueries({
    @NamedQuery(name = "Us.findBySyncLocalities", query = "SELECT u FROM  Us u  "
            									+ "left join fetch u.locality l "
            									+ "where l.id in (:localities)"),
	@NamedQuery(name = "Us.findByDistricts", query = "SELECT u FROM  Us u "
            									+ "left join fetch u.locality l "
            									+ "where l.district.id in (:districts)"),
	@NamedQuery(name = "Us.findByProvinces", query = "SELECT u FROM  Us u  "
            									+ "left join fetch u.locality l "
            									+ "where l.district.province.id in (:provinces)"),

    @NamedQuery(name = "Us.findAll", query = "SELECT c FROM Us c"),
    @NamedQuery(name = "Us.findByLocalities", query = "SELECT u FROM Us u where u.locality.id in (:localities) and u.status=1"),
    @NamedQuery(name = "Us.findByType", query = "SELECT u FROM Us u where u.usType.entryPoint = :ustype and u.locality.id = :locality"),
    @NamedQuery(name = "Us.findByDateCreated", query = "SELECT c FROM Us c WHERE c.dateCreated = :lastpulledat"),
    @NamedQuery(name = "Us.findByDateUpdated", query = "SELECT c FROM Us c WHERE c.dateUpdated = :lastpulledat"),

    @NamedQuery(name = "Us.findByEntryPoint", query = "SELECT u FROM Us u where u.usType.entryPoint = :entryPoint"),
    @NamedQuery(name = "Us.findByEPLocalities", query = "SELECT u FROM Us u where u.usType.entryPoint = :entryPoint and u.locality.id in (:localities)"),
	@NamedQuery(name = "Us.findByEPDistrict", query = "SELECT u FROM Us u where u.usType.entryPoint = :entryPoint and u.locality.district.id in (:distrits)"),
	@NamedQuery(name = "Us.findByEPProvince", query = "SELECT u FROM Us u where u.usType.entryPoint = :entryPoint and u.locality.district.province.id in (:provinces)")

})
public class Us implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
    
    private Integer id;
	private UsType usType;
	private String code;
	private String name;
	private String description;
	private Float latitude;
	private Float longitude;
	private Locality locality;
	private int status;
	private int createdBy;
	private Date dateCreated;
	private Integer updatedBy;
	private Date dateUpdated;
	private Set<BeneficiariesInterventions> beneficiariesInterventionses = new HashSet<BeneficiariesInterventions>(0);
	private Set<Beneficiaries> beneficiarieses = new HashSet<Beneficiaries>(0);

	public Us() {
	}

	public Us(UsType usType, String code, String name, Locality locality, int status, int createdBy, Date dateCreated) {
		this.usType = usType;
		this.code = code;
		this.name = name;
		this.locality = locality;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public Us(UsType usType, String code, String name, String description, Float latitude, Float longitude,
			Locality locality, int status, int createdBy, Date dateCreated, Integer updatedBy, Date dateUpdated,
			Set<BeneficiariesInterventions> beneficiariesInterventionses, 
			Set<Beneficiaries> beneficiarieses) {
		this.usType = usType;
		this.code = code;
		this.name = name;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.locality = locality;
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

	@ManyToOne(fetch = FetchType.LAZY)
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

	@Column(name = "name", nullable = false, length = 150, unique = true)
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locality_id", nullable = false)
	@JsonSerialize(using=LocalitySerializer.class)
	public Locality getLocality() {
		return this.locality;
	}

	public void setLocality(Locality locality) {
		this.locality = locality;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "us")
	public Set<BeneficiariesInterventions> getBeneficiariesInterventionses() {
		return this.beneficiariesInterventionses;
	}

	public void setBeneficiariesInterventionses(Set<BeneficiariesInterventions> beneficiariesInterventionses) {
		this.beneficiariesInterventionses = beneficiariesInterventionses;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "us")
	public Set<Beneficiaries> getBeneficiarieses() {
		return this.beneficiarieses;
	}

	public void setBeneficiarieses(Set<Beneficiaries> beneficiarieses) {
		this.beneficiarieses = beneficiarieses;
	}
	
	public ObjectNode toObjectNode() {
		ObjectMapper mapper = new ObjectMapper();
		
		ObjectNode us = mapper.createObjectNode();
		us.put("id", id);
		us.put("name", name);
		us.put("description", description);
		us.put("status", String.valueOf(status));
		us.put("locality_id", locality == null? null : locality.getId());
		us.put("entry_point", Integer.valueOf(usType.getEntryPoint()));
		us.put("online_id", id); // flag to control if entity is synchronized with the backend
		return us;
	} 

}
