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
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Services generated by hbm2java
 */
@Entity
@Table(name = "services", catalog = "dreams_db")
@NamedQueries({ @NamedQuery(name = "Service.findAll", query = "SELECT c FROM Services c"),
    @NamedQuery(name = "Service.findByDateCreated",
                query = "SELECT c FROM Services c WHERE c.dateCreated = :lastpulledat"),
    @NamedQuery(name = "Service.findByDateUpdated",
                query = "SELECT c FROM Services c WHERE c.dateUpdated = :lastpulledat"),
    @NamedQuery(name = "Service.findByServiceType",
                query = "SELECT c FROM Services c WHERE c.serviceType = :serviceType") })
public class Services implements java.io.Serializable {

	private Integer id;
	private String name;
	private String description;
	private Integer coreService;
	private Integer hidden;
	private String serviceType;
	private String ageBands;
	private Integer status;
	private int createdBy;
	private Date dateCreated;
	private Integer updatedBy;
	private Date dateUpdated;
	private Set<ReferencesServices> referencesServiceses = new HashSet<ReferencesServices>(0);
	private Set<SubServices> subServiceses = new HashSet<SubServices>(0);
	private Set<CurriculumsServices> curriculumsServiceses = new HashSet<CurriculumsServices>(0);

	public Services() {
	}

	public Services(String name, String serviceType, int createdBy, Date dateCreated) {
		this.name = name;
		this.serviceType = serviceType;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public Services(String name, String description, Integer coreService, Integer hidden, String serviceType,
			String ageBands, Integer status, int createdBy, Date dateCreated, Integer updatedBy, Date dateUpdated,
			Set<ReferencesServices> referencesServiceses, Set<SubServices> subServiceses,
			Set<CurriculumsServices> curriculumsServiceses) {
		this.name = name;
		this.description = description;
		this.coreService = coreService;
		this.hidden = hidden;
		this.serviceType = serviceType;
		this.ageBands = ageBands;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.updatedBy = updatedBy;
		this.dateUpdated = dateUpdated;
		this.referencesServiceses = referencesServiceses;
		this.subServiceses = subServiceses;
		this.curriculumsServiceses = curriculumsServiceses;
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

	@Column(name = "core_service")
	public Integer getCoreService() {
		return this.coreService;
	}

	public void setCoreService(Integer coreService) {
		this.coreService = coreService;
	}

	@Column(name = "hidden")
	public Integer getHidden() {
		return this.hidden;
	}

	public void setHidden(Integer hidden) {
		this.hidden = hidden;
	}

	@Column(name = "service_type", nullable = false, length = 50)
	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Column(name = "age_bands", length = 254)
	public String getAgeBands() {
		return this.ageBands;
	}

	public void setAgeBands(String ageBands) {
		this.ageBands = ageBands;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "services")
	public Set<ReferencesServices> getReferencesServiceses() {
		return this.referencesServiceses;
	}

	public void setReferencesServiceses(Set<ReferencesServices> referencesServiceses) {
		this.referencesServiceses = referencesServiceses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "services")
	public Set<SubServices> getSubServiceses() {
		return this.subServiceses;
	}

	public void setSubServiceses(Set<SubServices> subServiceses) {
		this.subServiceses = subServiceses;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "services")
	public Set<CurriculumsServices> getCurriculumsServiceses() {
		return this.curriculumsServiceses;
	}

	public void setCurriculumsServiceses(Set<CurriculumsServices> curriculumsServiceses) {
		this.curriculumsServiceses = curriculumsServiceses;
	}
	
	public ObjectNode toObjectNode() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode service = mapper.createObjectNode();
        service.put("id", id);
        service.put("service_type", serviceType);
        service.put("name", name);
        service.put("description", description);
        service.put("is_core_service", coreService);
        service.put("is_hidden", hidden);
        service.put("age_bands", ageBands);
        service.put("status", status);
        service.put("online_id", id); // flag to control if entity is synchronized with the backend
        return service;
    }

}
