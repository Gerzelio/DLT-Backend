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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

import dlt.dltbackendmaster.domain.watermelondb.UsersSyncModel;
import dlt.dltbackendmaster.serializers.PartnersSerializer;
import dlt.dltbackendmaster.serializers.ProfilesSerializer;
import dlt.dltbackendmaster.serializers.UsSerializer;
import dlt.dltbackendmaster.serializers.UsersSerializer;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "dreams_db")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u where u.username = :username"),
    @NamedQuery(name = "Users.findByResetPasswordToken", query = "SELECT u FROM Users u where u.recoverPasswordToken = :recoverPasswordToken"),
    @NamedQuery(name = "Users.findByDateCreated", query = "select u from Users u where u.dateUpdated is null and u.dateCreated > :lastpulledat"),
	@NamedQuery(name = "Users.findByDateUpdated", query = "select u from Users u where (u.dateUpdated >= :lastpulledat) or (u.dateUpdated >= :lastpulledat and u.dateCreated = u.dateUpdated)")})
public class Users implements java.io.Serializable {

	private Integer id;
	private Partners partners;
	private Profiles profiles;
	private Us us;
	private Users users;
	private String surname;
	private String name;
	private String phoneNumber;
	private String phoneNumber2;
	private String email;
	private String username;
	private String password;
	private String entryPoint;
	private int status;
	private Byte isLocked;
	private Byte isExpired;
	private Byte isCredentialsExpired;
	private Byte isEnabled;
	private int createdBy;
	private Date dateCreated;
	private Integer updatedBy;
	private Date dateUpdated;
	private String offlineId;
	private Integer newPassword;
	private String recoverPassword;
	private String recoverPasswordToken;
	private Set<Locality> localities = new HashSet<Locality>(0);
	private Set<District> districts = new HashSet<District>(0);
	private Set<Province> provinces = new HashSet<Province>(0);
	private Set<References> referenceses = new HashSet<References>(0);

	public Users() {
	}

	public Users(Partners partners, Profiles profiles, String surname, String name, String phoneNumber, String email,
			String username, String password, int status, int createdBy, Date dateCreated) {
		this.partners = partners;
		this.profiles = profiles;
		this.surname = surname;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public Users(Locality locality, Partners partners, Profiles profiles, Us us, String surname, String name,
			String phoneNumber, String email, String username, String password, String entryPoint, int status,
			Byte isLocked, Byte isExpired, Byte isCredentialsExpired, Byte isEnabled, int createdBy, Date dateCreated,
			Integer updatedBy, Date dateUpdated, String offlineId, Integer newPassword, Set<References> referenceses) {
		this.partners = partners;
		this.profiles = profiles;
		this.us = us;
		this.surname = surname;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.entryPoint = entryPoint;
		this.status = status;
		this.isLocked = isLocked;
		this.isExpired = isExpired;
		this.isCredentialsExpired = isCredentialsExpired;
		this.isEnabled = isEnabled;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.updatedBy = updatedBy;
		this.dateUpdated = dateUpdated;
		this.offlineId = offlineId;
		this.referenceses = referenceses;
		this.newPassword = newPassword;
	}
	
	public Users(Integer id, Partners partner, Profiles profiles, Us us, String surname, String name, 
			String phoneNumber, String email, String username, String password,Integer newPassword, String entryPoint, int status,
			Byte isLocked, Byte isExpired, Byte isCredentialsExpired, Byte isEnabled, int createdBy, Date dateCreated,
			Integer updatedBy, Date dateUpdated) {
		super();
		this.id = id;
		this.partners = partner;
		this.profiles = profiles;
		this.us = us;
		this.surname = surname;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.newPassword = newPassword;
		this.entryPoint = entryPoint;
		this.status = status;
		this.isLocked = isLocked;
		this.isExpired = isExpired;
		this.isCredentialsExpired = isCredentialsExpired;
		this.isEnabled = isEnabled;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.updatedBy = updatedBy;
		this.dateUpdated = dateUpdated;
	}
	
	public Users(UsersSyncModel model, String timestamp) {
		Long t = Long.valueOf(timestamp);
		Date regDate = new Date(t);
		
		this.partners = new Partners(model.getPartner_id());
		this.profiles = new Profiles(model.getProfile_id());
		this.us = new Us(model.getUs_id());
		this.surname = model.getSurname();
		this.name = model.getName();
		this.phoneNumber = model.getPhone_number();
		this.email = model.getEmail();
		this.username = model.getUsername();
		this.password = model.getPassword();
		this.entryPoint = model.getEntry_point();
		this.status = 1;
		this.isLocked = 0;
		this.isExpired = 0;
		this.isCredentialsExpired = 0;
		this.isEnabled = 1;
		this.offlineId = model.getId();
		this.dateCreated = regDate;
		this.dateUpdated = regDate;

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
	@JoinColumn(name = "partner_id", nullable = false)
	@JsonProperty("partners")
	@JsonSerialize(using=PartnersSerializer.class)
	public Partners getPartners() {
		return this.partners;
	}

	public void setPartners(Partners partners) {
		this.partners = partners;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id", nullable = false)
	@JsonProperty("profiles")
	@JsonSerialize(using=ProfilesSerializer.class)
	public Profiles getProfiles() {
		return this.profiles;
	}

	public void setProfiles(Profiles profiles) {
		this.profiles = profiles;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "us_id")
	@JsonProperty("us")
	@JsonSerialize(using=UsSerializer.class)
	public Us getUs() {
		return this.us;
	}

	public void setUs(Us us) {
		this.us = us;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "supervisor_id")
	@JsonProperty("supersivor")
	@JsonSerialize(using=UsersSerializer.class)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "surname", nullable = false, length = 50)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone_number", nullable = false, length = 50)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name = "phone_number2", length = 45)
	public String getPhoneNumber2() {
		return this.phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	@Column(name = "email", nullable = true, length = 150)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "username", nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 150)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "entry_point", length = 50)
	public String getEntryPoint() {
		return this.entryPoint;
	}

	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "is_locked")
	public Byte getIsLocked() {
		return this.isLocked;
	}

	public void setIsLocked(Byte isLocked) {
		this.isLocked = isLocked;
	}

	@Column(name = "is_expired")
	public Byte getIsExpired() {
		return this.isExpired;
	}

	public void setIsExpired(Byte isExpired) {
		this.isExpired = isExpired;
	}

	@Column(name = "is_credentials_expired")
	public Byte getIsCredentialsExpired() {
		return this.isCredentialsExpired;
	}

	public void setIsCredentialsExpired(Byte isCredentialsExpired) {
		this.isCredentialsExpired = isCredentialsExpired;
	}

	@Column(name = "is_enabled")
	public Byte getIsEnabled() {
		return this.isEnabled;
	}

	public void setIsEnabled(Byte isEnabled) {
		this.isEnabled = isEnabled;
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
	
	@Column(name = "new_password")
	public Integer getNewPassword() {
		return this.newPassword;
	}

	public void setNewPassword(Integer newPassword) {
		this.newPassword = newPassword;
	}

	@Column(name = "recover_password", length = 150)
	public String getRecoverPassword() {
		return this.recoverPassword;
	}

	public void setRecoverPassword(String recoverPassword) {
		this.recoverPassword = recoverPassword;
	}
	
	@Column(name = "recover_password_token", length = 45)
	public String getRecoverPasswordToken() {
        return recoverPasswordToken;
    }

    public void setRecoverPasswordToken(String recoverPasswordToken) {
        this.recoverPasswordToken = recoverPasswordToken;
    }

    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_localities", catalog = "dreams_db", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "locality_id", nullable = false, updatable = false) })
	public Set<Locality> getLocalities() {
		return this.localities;
	}

	public void setLocalities(Set<Locality> localities) {
		this.localities = localities;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_districts", catalog = "dreams_db", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "district_id", nullable = false, updatable = false) })
	public Set<District> getDistricts() {
		return this.districts;
	}

	public void setDistricts(Set<District> districts) {
		this.districts = districts;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_provinces", catalog = "dreams_db", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "province_id", nullable = false, updatable = false) })
	public Set<Province> getProvinces() {
		return this.provinces;
	}

	public void setProvinces(Set<Province> provinces) {
		this.provinces = provinces;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
	public Set<References> getReferenceses() {
		return this.referenceses;
	}

	public void setReferenceses(Set<References> referenceses) {
		this.referenceses = referenceses;
	}

	public ObjectNode toObjectNode(String lastPulledAt) {
		ObjectMapper mapper = new ObjectMapper();
		
		ObjectNode user = mapper.createObjectNode();

		if(offlineId != null) {
			user.put("id", offlineId);
		}else {
			user.put("id", id);
		}
		
		if(dateUpdated == null || dateUpdated.after(dateCreated) || lastPulledAt == null || lastPulledAt.equals("null")) { 

			user.put("name", name);
		    user.put("surname", surname);
		    user.put("phone_number", phoneNumber);
		    user.put("email", email);
		    user.put("username", username);
		    user.put("password", password);
		    user.put("entry_point", entryPoint);
		    user.put("status", status);
		    //user.put("locality_id", locality.getId());
		    user.put("partner_id", partners.getId());
		    user.put("profile_id", profiles.getId());
		    user.put("us_id", us.getId());
		    user.put("online_id", id); // flag to control if entity is synchronized with the backend
			
		}else { // ensure online_id is updated first
			user.put("online_id", id);
		}
		return user;
	}
	
	public void update(UsersSyncModel model, String timestamp) {
		Long t = Long.valueOf(timestamp);
		
		this.offlineId = model.getId();
		this.dateUpdated = new Date(t);
		this.name = model.getName();
		this.surname = model.getSurname();
		this.phoneNumber = model.getPhone_number();
		this.username = model.getUsername();
		this.password = model.getPassword();
		this.entryPoint = model.getEntry_point();
		//this.locality.setId(model.getLocality_id());
		this.partners.setId(model.getPartner_id());
		this.profiles.setId(model.getProfile_id());
		this.us.setId(model.getUs_id());
	}
}
