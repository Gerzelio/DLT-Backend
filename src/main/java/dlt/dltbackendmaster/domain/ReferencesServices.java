package dlt.dltbackendmaster.domain;
// Generated Jun 13, 2022, 4:04:49 PM by Hibernate Tools 5.2.12.Final

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dlt.dltbackendmaster.domain.watermelondb.ReferenceServicesSyncModel;
import dlt.dltbackendmaster.serializers.ServiceSerializer;

/**
 * ReferencesServices generated by hbm2java
 */
@Entity
@Table(name = "references_services", catalog = "dreams_db")
@NamedNativeQueries({
		@NamedNativeQuery(name = "ReferencesServices.removeByReferenceId", query = "DELETE FROM references_services WHERE reference_id = :referenceId") })
@NamedQueries({ @NamedQuery(name = "ReferencesServices.findAll", query = "SELECT b FROM ReferencesServices b"),
		@NamedQuery(name = "ReferencesServices.findByReferenceAndService", query = "SELECT b FROM ReferencesServices b where b.references.id = :reference_id and b.services.id = :service_id"),
		@NamedQuery(name = "ReferencesServices.findByDateCreated", query = "select b from ReferencesServices b where b.dateUpdated is null and b.dateCreated > :lastpulledat"),
		@NamedQuery(name = "ReferencesServices.findByDateUpdated", query = "select b from ReferencesServices b where (b.dateUpdated >= :lastpulledat) or (b.dateUpdated >= :lastpulledat and b.dateCreated = b.dateUpdated)") })
public class ReferencesServices implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private ReferencesServicesId id;
	private References references;
	private Services services;
	private String description;
	private int status;
	private int createdBy;
	private Date dateCreated;
	private Integer updatedBy;
	private Date dateUpdated;
	private String offlineId;

	public ReferencesServices() {
	}

	public ReferencesServices(ReferencesServicesId id, References references, Services services, int status,
			int createdBy, Date dateCreated) {
		this.id = id;
		this.references = references;
		this.services = services;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public ReferencesServices(ReferencesServicesId id, References references, Services services, String description,
			int status, int createdBy, Date dateCreated, Integer updatedBy, Date dateUpdated) {
		this.id = id;
		this.references = references;
		this.services = services;
		this.description = description;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.updatedBy = updatedBy;
		this.dateUpdated = dateUpdated;
	}
	
	public ReferencesServices(ReferenceServicesSyncModel model, String timestamp) throws ParseException {
		Long t = Long.valueOf(timestamp);
        Date regDate = new Date(t);
        this.references = new References();
        this.references.setId(Integer.valueOf(model.getReference_id()));
        this.services = new Services();
        this.services.setId(model.getService_id()); 
        this.description = model.getDescription();
        this.status = model.getStatus();
        this.offlineId = model.getId();
        this.dateCreated = regDate;
        this.dateUpdated = regDate;
		this.id = new ReferencesServicesId();
		this.id.setReferenceId(Integer.valueOf(model.getReference_id()));
		this.id.setServiceId(model.getService_id());
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "referenceId", column = @Column(name = "reference_id", nullable = false)),
			@AttributeOverride(name = "serviceId", column = @Column(name = "service_id", nullable = false)) })
	public ReferencesServicesId getId() {
		return this.id;
	}

	public void setId(ReferencesServicesId id) {
		this.id = id;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reference_id", nullable = false, insertable = false, updatable = false)
	public References getReferences() {
		return this.references;
	}

	public void setReferences(References references) {
		this.references = references;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "service_id", nullable = false, insertable = false, updatable = false)
	@JsonProperty("services")
	@JsonSerialize(using = ServiceSerializer.class)
	public Services getServices() {
		return this.services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	@Column(name = "description", length = 250)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Column(name = "offline_id", length = 45)
	public String getOfflineId() {
		return this.offlineId;
	}

	public void setOfflineId(String offlineId) {
		this.offlineId = offlineId;
	}

	public ObjectNode toObjectNode(String lastPulledAt) {
		ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		ObjectNode referenceService = mapper.createObjectNode();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		if (offlineId != null) {
			referenceService.put("id", offlineId);
		} else {
			referenceService.put("id", id.toString());
		}

		if (dateUpdated == null || dateUpdated.after(dateCreated) || lastPulledAt == null
				|| lastPulledAt.equals("null")) {
			referenceService.put("reference_id", String.valueOf(id.getReferenceId()));
			referenceService.put("service_id", id.getServiceId());
			referenceService.put("description", description);
			referenceService.put("status", status);
			referenceService.put("date_created", dateFormat.format(dateCreated));
			referenceService.put("online_id", id.toString()); // flag to control if entity is synchronized with
																// the backend
		} else { // ensure online_id is updated first
			referenceService.put("reference_id", String.valueOf(id.getReferenceId()));
			referenceService.put("online_id", id.toString());
		}
		return referenceService;
	}

	public void update(ReferenceServicesSyncModel model, String timestamp) throws ParseException {
		Long t = Long.valueOf(timestamp);

		this.offlineId = model.getId();
		this.dateUpdated = new Date(t);
		this.references.setId(Integer.valueOf(model.getReference_id()));
		this.services.setId(model.getService_id());
		this.description = model.getDescription();
		this.status = model.getStatus();
	}
}
