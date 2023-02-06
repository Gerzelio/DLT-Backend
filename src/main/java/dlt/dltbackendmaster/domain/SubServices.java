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

import dlt.dltbackendmaster.serializers.ServiceSerializer;

/**
 * SubServices generated by hbm2java
 */
@Entity
@Table(name = "sub_services", catalog = "dreams_db")
@NamedQueries({ 
	@NamedQuery(name = "SubService.findAll", 
				query = "SELECT ss FROM SubServices ss WHERE ss.status=1"),
    @NamedQuery(name = "SubService.findByDateCreated",
                query = "SELECT ss FROM SubServices ss WHERE ss.dateCreated = :lastpulledat AND ss.status=1"),
    @NamedQuery(name = "SubService.findByDateUpdated",
                query = "SELECT ss FROM SubServices ss WHERE ss.dateUpdated = :lastpulledat AND ss.status=1"),
    @NamedQuery(name = "SubService.findByService",
                query = "SELECT ss FROM SubServices ss WHERE ss.services.id = :serviceId AND ss.status=1") })
public class SubServices implements java.io.Serializable {

	private static final long serialVersionUID = -2806766479892025596L;
	private Integer id;
	private Services services;
	private String name;
	private String remarks;
	private Integer hidden;
	private Integer mandatory;
	private int status;
	private Integer sortOrder;
	private int createdBy;
	private Date dateCreated;
	private Integer updatedBy;
	private Date dateUpdated;
	private Set<BeneficiariesInterventions> beneficiariesInterventionses = new HashSet<BeneficiariesInterventions>(0);

	public SubServices() {
	}

	public SubServices(Services services, String name, int status, int createdBy, Date dateCreated) {
		this.services = services;
		this.name = name;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public SubServices(Services services, String name, String remarks, Integer hidden, Integer mandatory, int status,
			Integer sortOrder, int createdBy, Date dateCreated, Integer updatedBy, Date dateUpdated,
			Set<BeneficiariesInterventions> beneficiariesInterventionses) {
		this.services = services;
		this.name = name;
		this.remarks = remarks;
		this.hidden = hidden;
		this.mandatory = mandatory;
		this.status = status;
		this.sortOrder = sortOrder;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.updatedBy = updatedBy;
		this.dateUpdated = dateUpdated;
		this.beneficiariesInterventionses = beneficiariesInterventionses;
	}
	
	public SubServices(Integer id) {
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
	@JoinColumn(name = "service_id", nullable = false)
	@JsonProperty("service")
    @JsonSerialize(using = ServiceSerializer.class)
	public Services getServices() {
		return this.services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "remarks", length = 250)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "hidden")
	public Integer getHidden() {
		return this.hidden;
	}

	public void setHidden(Integer hidden) {
		this.hidden = hidden;
	}

	@Column(name = "mandatory")
	public Integer getMandatory() {
		return this.mandatory;
	}

	public void setMandatory(Integer mandatory) {
		this.mandatory = mandatory;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "sort_order")
	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subServices")
	public Set<BeneficiariesInterventions> getBeneficiariesInterventionses() {
		return this.beneficiariesInterventionses;
	}

	public void setBeneficiariesInterventionses(Set<BeneficiariesInterventions> beneficiariesInterventionses) {
		this.beneficiariesInterventionses = beneficiariesInterventionses;
	}

	public ObjectNode toObjectNode() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode subService = mapper.createObjectNode();
        subService.put("id", id);
        subService.put("name", name);
        subService.put("service_id", services.getId());
        subService.put("is_mandatory", mandatory);
        subService.put("is_hidden", hidden);
        subService.put("remarks", remarks);
        subService.put("sort_order", sortOrder);
        subService.put("status", status);
        subService.put("online_id", id); // flag to control if entity is synchronized with the backend
        return subService;
    }
}
