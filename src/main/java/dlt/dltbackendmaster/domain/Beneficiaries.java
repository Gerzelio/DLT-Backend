package dlt.dltbackendmaster.domain;
// Generated Jun 13, 2022, 9:37:47 AM by Hibernate Tools 5.2.12.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dlt.dltbackendmaster.domain.watermelondb.BeneficiarySyncModel;
import dlt.dltbackendmaster.serializers.NeighborhoodSerializer;
import dlt.dltbackendmaster.serializers.PartnersSerializer;
import dlt.dltbackendmaster.serializers.UsSerializer;

/**
 * Beneficiaries generated by hbm2java
 */
@Entity
@Table(name = "beneficiaries", catalog = "dreams_db", uniqueConstraints = @UniqueConstraint(columnNames = "nui"))
@NamedQueries({ @NamedQuery(name = "Beneficiary.findAll", query = "SELECT b FROM Beneficiaries b"),
                @NamedQuery(name = "Beneficiary.findByNui", query = "SELECT b FROM Beneficiaries b where nui = :nui"),
                @NamedQuery(name = "Beneficiary.findByDateCreated",
                            query = "select b from Beneficiaries b where b.dateUpdated is null and b.dateCreated > :lastpulledat"),
                @NamedQuery(name = "Beneficiary.findByDateUpdated",
                            query = "select b from Beneficiaries b where (b.dateUpdated >= :lastpulledat) or (b.dateUpdated >= :lastpulledat and b.dateCreated = b.dateUpdated)") })
public class Beneficiaries implements java.io.Serializable
{
    private static final long serialVersionUID = -8649443166960196872L;
    
    private Integer id;
    private Neighborhood neighborhood;
    private Partners partners;
    private Us us;
    private String nui;
    private String surname;
    private String name;
    private String nickName;
    private Integer organizationId;
    private Date dateOfBirth;
    private char gender;
    private String address;
    private String phoneNumber;
    private String EMail;
    private Date enrollmentDate;
    private Integer via;
    private Integer nationality;
    private Integer partnerId;
    private String partnerNUI;
    private String entryPoint;
    private String vbltLivesWith;
    private Byte vbltIsOrphan;
    private Byte vbltIsStudent;
    private Integer vbltSchoolGrade;
    private String vbltSchoolName;
    private Byte vbltIsDeficient;
    private String vbltDeficiencyType;
    private Byte vbltMarriedBefore;
    private Byte vbltPregnantBefore;
    private Byte vbltChildren;
    private Byte vbltPregnantOrBreastfeeding;
    private String vbltIsEmployed;
    private String vbltTestedHiv;
    private Byte vbltSexuallyActive;
    private Byte vbltMultiplePartners;
    private Byte vbltIsMigrant;
    private Byte vbltTraffickingVictim;
    private Byte vbltSexualExploitation;
    private String vbltSexploitationTime;
    private Byte vbltVbgVictim;
    private String vbltVbgType;
    private String vbltVbgTime;
    private Byte vbltAlcoholDrugsUse;
    private Byte vbltStiHistory;
    private Byte vbltSexWorker;
    private Byte vbltHouseSustainer;
    private int status;
    private int createdBy;
    private Date dateCreated;
    private Integer updatedBy;
    private Date dateUpdated;
    private String offlineId;
    private Set<VulnerabilityHistory> vulnerabilityHistories = new HashSet<VulnerabilityHistory>(0);
    private Set<BeneficiariesInterventions> beneficiariesInterventionses = new HashSet<BeneficiariesInterventions>(0);
    private Set<References> referenceses = new HashSet<References>(0);

    public Beneficiaries() {}

    public Beneficiaries(Neighborhood neighborhood, Us us, String nui, String surname, String name, String nickName,
                         Date dateOfBirth, char gender, Date enrollmentDate, Integer nationality, String entryPoint,
                         int status, int createdBy, Date dateCreated) {
        this.neighborhood = neighborhood;
        this.us = us;
        this.nui = nui;
        this.surname = surname;
        this.name = name;
        this.nickName = nickName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.enrollmentDate = enrollmentDate;
        this.nationality = nationality;
        this.entryPoint = entryPoint;
        this.status = status;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }

    public Beneficiaries(Neighborhood neighborhood, Partners partners, Us us, String nui, String surname, String name,
                         String nickName, Integer organizationId, Date dateOfBirth, char gender, String address,
                         String phoneNumber, String EMail, Date enrollmentDate, Integer via, Integer nationality,
                         Integer partnerId, String entryPoint, String vbltLivesWith, Byte vbltIsOrphan,
                         Byte vbltIsStudent, Integer vbltSchoolGrade, String vbltSchoolName, Byte vbltIsDeficient,
                         String vbltDeficiencyType, Byte vbltMarriedBefore, Byte vbltPregnantBefore, Byte vbltChildren,
                         Byte vbltPregnantOrBreastfeeding, String vbltIsEmployed, String vbltTestedHiv,
                         Byte vbltSexuallyActive, Byte vbltMultiplePartners, Byte vbltIsMigrant,
                         Byte vbltTraffickingVictim, Byte vbltSexualExploitation, String vbltSexploitationTime,
                         Byte vbltVbgVictim, String vbltVbgType, String vbltVbgTime, Byte vbltAlcoholDrugsUse,
                         Byte vbltStiHistory, Byte vbltSexWorker, Byte vbltHouseSustainer, int status, int createdBy,
                         Date dateCreated, Integer updatedBy, Date dateUpdated, String offlineId,
                         Set<VulnerabilityHistory> vulnerabilityHistories,
                         Set<BeneficiariesInterventions> beneficiariesInterventionses, Set<References> referenceses) {
        this.neighborhood = neighborhood;
        this.partners = partners;
        this.us = us;
        this.nui = nui;
        this.surname = surname;
        this.name = name;
        this.nickName = nickName;
        this.organizationId = organizationId;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.EMail = EMail;
        this.enrollmentDate = enrollmentDate;
        this.via = via;
        this.nationality = nationality;
        this.partnerId = partnerId;
        this.entryPoint = entryPoint;
        this.vbltLivesWith = vbltLivesWith;
        this.vbltIsOrphan = vbltIsOrphan;
        this.vbltIsStudent = vbltIsStudent;
        this.vbltSchoolGrade = vbltSchoolGrade;
        this.vbltSchoolName = vbltSchoolName;
        this.vbltIsDeficient = vbltIsDeficient;
        this.vbltDeficiencyType = vbltDeficiencyType;
        this.vbltMarriedBefore = vbltMarriedBefore;
        this.vbltPregnantBefore = vbltPregnantBefore;
        this.vbltChildren = vbltChildren;
        this.vbltPregnantOrBreastfeeding = vbltPregnantOrBreastfeeding;
        this.vbltIsEmployed = vbltIsEmployed;
        this.vbltTestedHiv = vbltTestedHiv;
        this.vbltSexuallyActive = vbltSexuallyActive;
        this.vbltMultiplePartners = vbltMultiplePartners;
        this.vbltIsMigrant = vbltIsMigrant;
        this.vbltTraffickingVictim = vbltTraffickingVictim;
        this.vbltSexualExploitation = vbltSexualExploitation;
        this.vbltSexploitationTime = vbltSexploitationTime;
        this.vbltVbgVictim = vbltVbgVictim;
        this.vbltVbgType = vbltVbgType;
        this.vbltVbgTime = vbltVbgTime;
        this.vbltAlcoholDrugsUse = vbltAlcoholDrugsUse;
        this.vbltStiHistory = vbltStiHistory;
        this.vbltSexWorker = vbltSexWorker;
        this.vbltHouseSustainer = vbltHouseSustainer;
        this.status = status;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.updatedBy = updatedBy;
        this.dateUpdated = dateUpdated;
        this.offlineId = offlineId;
        this.vulnerabilityHistories = vulnerabilityHistories;
        this.beneficiariesInterventionses = beneficiariesInterventionses;
        this.referenceses = referenceses;
    }

    public Beneficiaries(BeneficiarySyncModel model, String timestamp) {
        Long t = Long.valueOf(timestamp);
        Date regDate = new Date(t);
        this.nui = model.getNui();
        this.surname = model.getSurname();
        this.nickName = model.getNick_name();
        this.name = model.getName();
        this.partners = new Partners(model.getOrganization_id());
        this.dateOfBirth = model.getDate_of_birth();
        this.gender = model.getGender();
        this.address = model.getAddress();
        this.phoneNumber = model.getPhone_number();
        this.EMail = model.getE_mail();
        this.via = model.getVia();
        this.partnerId = model.getPartner_id();
        this.entryPoint = model.getEntry_point();
        this.neighborhood = new Neighborhood(model.getNeighbourhood_id());
        this.us = new Us(model.getUs_id());
        this.offlineId = model.getId();
        this.dateCreated = regDate;
        this.dateUpdated = regDate;
        this.vbltLivesWith = model.getVblt_lives_with();
        this.vbltIsOrphan = (byte) model.getVblt_is_orphan();
        this.vbltIsStudent = (byte) model.getVblt_is_student();
        this.vbltSchoolGrade = model.getVblt_school_grade();
        this.vbltSchoolName = model.getVblt_school_name();
        this.vbltIsDeficient = (byte) model.getVblt_is_deficient();
        this.vbltDeficiencyType = model.getVblt_deficiency_type();
        this.vbltMarriedBefore = (byte) model.getVblt_married_before();
        this.vbltPregnantBefore = (byte) model.getVblt_pregnant_before();
        this.vbltChildren = (byte) model.getVblt_children();
        this.vbltPregnantOrBreastfeeding = (byte) model.getVblt_pregnant_or_breastfeeding();
        this.vbltIsEmployed = model.getVblt_is_employed();
        this.vbltTestedHiv = model.getVblt_tested_hiv();
        this.vbltSexuallyActive = (byte) model.getVblt_sexually_active();
        this.vbltMultiplePartners = (byte) model.getVblt_multiple_partners();
        this.vbltIsMigrant = (byte) model.getVblt_is_migrant();
        this.vbltTraffickingVictim = (byte) model.getVblt_trafficking_victim();
        this.vbltSexualExploitation = (byte) model.getVblt_sexual_exploitation();
        this.vbltSexploitationTime = model.getVblt_sexploitation_time();
        this.vbltVbgVictim = (byte) model.getVblt_vbg_victim();
        this.vbltVbgType = model.getVblt_vbg_type();
        this.vbltVbgTime = model.getVblt_vbg_time();
        this.vbltAlcoholDrugsUse = (byte) model.getVblt_alcohol_drugs_use();
        this.vbltStiHistory = (byte) model.getVblt_sti_history();
        this.vbltSexWorker = (byte) model.getVblt_sex_worker();
        this.vbltHouseSustainer = (byte) model.getVblt_house_sustainer();
    }

    public Beneficiaries(BeneficiarySyncModel model) {
        this.nui = model.getNui();
        this.surname = model.getSurname();
        this.nickName = model.getNick_name();
        this.partners = new Partners(model.getOrganization_id());
        this.dateOfBirth = model.getDate_of_birth();
        this.gender = model.getGender();
        this.address = model.getAddress();
        this.phoneNumber = model.getPhone_number();
        this.EMail = model.getE_mail();
        this.via = model.getVia();
        this.partnerId = model.getPartner_id();
        this.entryPoint = model.getEntry_point();
        this.neighborhood = new Neighborhood(model.getNeighbourhood_id());
        this.us = new Us(model.getUs_id());
        this.offlineId = model.getId();
        this.vbltLivesWith = model.getVblt_lives_with();
        this.vbltIsOrphan = (byte) model.getVblt_is_orphan();
        this.vbltIsStudent = (byte) model.getVblt_is_student();
        this.vbltSchoolGrade = model.getVblt_school_grade();
        this.vbltSchoolName = model.getVblt_school_name();
        this.vbltIsDeficient = (byte) model.getVblt_is_deficient();
        this.vbltDeficiencyType = model.getVblt_deficiency_type();
        this.vbltMarriedBefore = (byte) model.getVblt_married_before();
        this.vbltPregnantBefore = (byte) model.getVblt_pregnant_before();
        this.vbltChildren = (byte) model.getVblt_children();
        this.vbltPregnantOrBreastfeeding = (byte) model.getVblt_pregnant_or_breastfeeding();
        this.vbltIsEmployed = model.getVblt_is_employed();
        this.vbltTestedHiv = model.getVblt_tested_hiv();
        this.vbltSexuallyActive = (byte) model.getVblt_sexually_active();
        this.vbltMultiplePartners = (byte) model.getVblt_multiple_partners();
        this.vbltIsMigrant = (byte) model.getVblt_is_migrant();
        this.vbltTraffickingVictim = (byte) model.getVblt_trafficking_victim();
        this.vbltSexualExploitation = (byte) model.getVblt_sexual_exploitation();
        this.vbltSexploitationTime = model.getVblt_sexploitation_time();
        this.vbltVbgVictim = (byte) model.getVblt_vbg_victim();
        this.vbltVbgType = model.getVblt_vbg_type();
        this.vbltVbgTime = model.getVblt_vbg_time();
        this.vbltAlcoholDrugsUse = (byte) model.getVblt_alcohol_drugs_use();
        this.vbltStiHistory = (byte) model.getVblt_sti_history();
        this.vbltSexWorker = (byte) model.getVblt_sex_worker();
        this.vbltHouseSustainer = (byte) model.getVblt_house_sustainer();
    }

    public Beneficiaries(Integer id) {
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
    @JoinColumn(name = "neighbourhood_id", nullable = false)
    @JsonProperty("neighborhood")
    @JsonSerialize(using = NeighborhoodSerializer.class)
    public Neighborhood getNeighborhood() {
        return this.neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partner")
    @JsonProperty("partner")
    @JsonSerialize(using = PartnersSerializer.class)
    public Partners getPartners() {
        return this.partners;
    }

    public void setPartners(Partners partners) {
        this.partners = partners;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "us_id", nullable = false)
    @JsonProperty("us")
    @JsonSerialize(using = UsSerializer.class)
    public Us getUs() {
        return this.us;
    }

    public void setUs(Us us) {
        this.us = us;
    }

    @Column(name = "nui", unique = true, nullable = false, length = 50)
    public String getNui() {
        return this.nui;
    }

    public void setNui(String nui) {
        this.nui = nui;
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

    @Column(name = "nick_name", length = 50)
    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Column(name = "organization_id")
    public Integer getOrganizationId() {
        return this.organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false, length = 10)
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "gender", nullable = false, length = 1)
    public char getGender() {
        return this.gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Column(name = "address", length = 250)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "phone_number", length = 50)
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "e_mail", length = 150)
    public String getEMail() {
        return this.EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "enrollment_date", length = 10)
    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Column(name = "via")
    public Integer getVia() {
        return this.via;
    }

    public void setVia(Integer via) {
        this.via = via;
    }

    @Column(name = "partner_id")
    public Integer getPartnerId() {
        return this.partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    @Transient
    public String getPartnerNUI() {
        return partnerNUI;
    }

    public void setPartnerNUI(String partnerNUI) {
        this.partnerNUI = partnerNUI;
    }

    @Column(name = "nationality")
    public Integer getNationality() {
        return nationality;
    }

    public void setNationality(Integer nationality) {
        this.nationality = nationality;
    }

    @Column(name = "entry_point", nullable = false, length = 50)
    public String getEntryPoint() {
        return this.entryPoint;
    }

    public void setEntryPoint(String entryPoint) {
        this.entryPoint = entryPoint;
    }

    @Column(name = "vblt_lives_with", length = 254)
    public String getVbltLivesWith() {
        return this.vbltLivesWith;
    }

    public void setVbltLivesWith(String vbltLivesWith) {
        this.vbltLivesWith = vbltLivesWith;
    }

    @Column(name = "vblt_is_orphan")
    public Byte getVbltIsOrphan() {
        return this.vbltIsOrphan;
    }

    public void setVbltIsOrphan(Byte vbltIsOrphan) {
        this.vbltIsOrphan = vbltIsOrphan;
    }

    @Column(name = "vblt_is_student")
    public Byte getVbltIsStudent() {
        return this.vbltIsStudent;
    }

    public void setVbltIsStudent(Byte vbltIsStudent) {
        this.vbltIsStudent = vbltIsStudent;
    }

    @Column(name = "vblt_school_grade")
    public Integer getVbltSchoolGrade() {
        return this.vbltSchoolGrade;
    }

    public void setVbltSchoolGrade(Integer vbltSchoolGrade) {
        this.vbltSchoolGrade = vbltSchoolGrade;
    }

    @Column(name = "vblt_school_name", length = 45)
    public String getVbltSchoolName() {
        return this.vbltSchoolName;
    }

    public void setVbltSchoolName(String vbltSchoolName) {
        this.vbltSchoolName = vbltSchoolName;
    }

    @Column(name = "vblt_is_deficient")
    public Byte getVbltIsDeficient() {
        return this.vbltIsDeficient;
    }

    public void setVbltIsDeficient(Byte vbltIsDeficient) {
        this.vbltIsDeficient = vbltIsDeficient;
    }

    @Column(name = "vblt_deficiency_type", length = 45)
    public String getVbltDeficiencyType() {
        return this.vbltDeficiencyType;
    }

    public void setVbltDeficiencyType(String vbltDeficiencyType) {
        this.vbltDeficiencyType = vbltDeficiencyType;
    }

    @Column(name = "vblt_married_before")
    public Byte getVbltMarriedBefore() {
        return this.vbltMarriedBefore;
    }

    public void setVbltMarriedBefore(Byte vbltMarriedBefore) {
        this.vbltMarriedBefore = vbltMarriedBefore;
    }

    @Column(name = "vblt_pregnant_before")
    public Byte getVbltPregnantBefore() {
        return this.vbltPregnantBefore;
    }

    public void setVbltPregnantBefore(Byte vbltPregnantBefore) {
        this.vbltPregnantBefore = vbltPregnantBefore;
    }

    @Column(name = "vblt_children")
    public Byte getVbltChildren() {
        return this.vbltChildren;
    }

    public void setVbltChildren(Byte vbltChildren) {
        this.vbltChildren = vbltChildren;
    }

    @Column(name = "vblt_pregnant_or_breastfeeding")
    public Byte getVbltPregnantOrBreastfeeding() {
        return this.vbltPregnantOrBreastfeeding;
    }

    public void setVbltPregnantOrBreastfeeding(Byte vbltPregnantOrBreastfeeding) {
        this.vbltPregnantOrBreastfeeding = vbltPregnantOrBreastfeeding;
    }

    @Column(name = "vblt_is_employed", length = 254)
    public String getVbltIsEmployed() {
        return this.vbltIsEmployed;
    }

    public void setVbltIsEmployed(String vbltIsEmployed) {
        this.vbltIsEmployed = vbltIsEmployed;
    }

    @Column(name = "vblt_tested_hiv", length = 254)
    public String getVbltTestedHiv() {
        return this.vbltTestedHiv;
    }

    public void setVbltTestedHiv(String vbltTestedHiv) {
        this.vbltTestedHiv = vbltTestedHiv;
    }

    @Column(name = "vblt_sexually_active")
    public Byte getVbltSexuallyActive() {
        return this.vbltSexuallyActive;
    }

    public void setVbltSexuallyActive(Byte vbltSexuallyActive) {
        this.vbltSexuallyActive = vbltSexuallyActive;
    }

    @Column(name = "vblt_multiple_partners")
    public Byte getVbltMultiplePartners() {
        return this.vbltMultiplePartners;
    }

    public void setVbltMultiplePartners(Byte vbltMultiplePartners) {
        this.vbltMultiplePartners = vbltMultiplePartners;
    }

    @Column(name = "vblt_is_migrant")
    public Byte getVbltIsMigrant() {
        return this.vbltIsMigrant;
    }

    public void setVbltIsMigrant(Byte vbltIsMigrant) {
        this.vbltIsMigrant = vbltIsMigrant;
    }

    @Column(name = "vblt_trafficking_victim")
    public Byte getVbltTraffickingVictim() {
        return this.vbltTraffickingVictim;
    }

    public void setVbltTraffickingVictim(Byte vbltTraffickingVictim) {
        this.vbltTraffickingVictim = vbltTraffickingVictim;
    }

    @Column(name = "vblt_sexual_exploitation")
    public Byte getVbltSexualExploitation() {
        return this.vbltSexualExploitation;
    }

    public void setVbltSexualExploitation(Byte vbltSexualExploitation) {
        this.vbltSexualExploitation = vbltSexualExploitation;
    }

    @Column(name = "vblt_sexploitation_time", length = 45)
    public String getVbltSexploitationTime() {
        return this.vbltSexploitationTime;
    }

    public void setVbltSexploitationTime(String vbltSexploitationTime) {
        this.vbltSexploitationTime = vbltSexploitationTime;
    }

    @Column(name = "vblt_vbg_victim")
    public Byte getVbltVbgVictim() {
        return this.vbltVbgVictim;
    }

    public void setVbltVbgVictim(Byte vbltVbgVictim) {
        this.vbltVbgVictim = vbltVbgVictim;
    }

    @Column(name = "vblt_vbg_type", length = 45)
    public String getVbltVbgType() {
        return this.vbltVbgType;
    }

    public void setVbltVbgType(String vbltVbgType) {
        this.vbltVbgType = vbltVbgType;
    }

    @Column(name = "vblt_vbg_time", length = 45)
    public String getVbltVbgTime() {
        return this.vbltVbgTime;
    }

    public void setVbltVbgTime(String vbltVbgTime) {
        this.vbltVbgTime = vbltVbgTime;
    }

    @Column(name = "vblt_alcohol_drugs_use")
    public Byte getVbltAlcoholDrugsUse() {
        return this.vbltAlcoholDrugsUse;
    }

    public void setVbltAlcoholDrugsUse(Byte vbltAlcoholDrugsUse) {
        this.vbltAlcoholDrugsUse = vbltAlcoholDrugsUse;
    }

    @Column(name = "vblt_sti_history")
    public Byte getVbltStiHistory() {
        return this.vbltStiHistory;
    }

    public void setVbltStiHistory(Byte vbltStiHistory) {
        this.vbltStiHistory = vbltStiHistory;
    }

    @Column(name = "vblt_sex_worker")
    public Byte getVbltSexWorker() {
        return this.vbltSexWorker;
    }

    public void setVbltSexWorker(Byte vbltSexWorker) {
        this.vbltSexWorker = vbltSexWorker;
    }

    @Column(name = "vblt_house_sustainer")
    public Byte getVbltHouseSustainer() {
        return this.vbltHouseSustainer;
    }

    public void setVbltHouseSustainer(Byte vbltHouseSustainer) {
        this.vbltHouseSustainer = vbltHouseSustainer;
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

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "beneficiaries")
    public Set<VulnerabilityHistory> getVulnerabilityHistories() {
        return this.vulnerabilityHistories;
    }

    public void setVulnerabilityHistories(Set<VulnerabilityHistory> vulnerabilityHistories) {
        this.vulnerabilityHistories = vulnerabilityHistories;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "beneficiaries")
    public Set<BeneficiariesInterventions> getBeneficiariesInterventionses() {
        return this.beneficiariesInterventionses;
    }

    public void setBeneficiariesInterventionses(Set<BeneficiariesInterventions> beneficiariesInterventionses) {
        this.beneficiariesInterventionses = beneficiariesInterventionses;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "beneficiaries")
    public Set<References> getReferenceses() {
        return this.referenceses;
    }

    public void setReferenceses(Set<References> referenceses) {
        this.referenceses = referenceses;
    }

    public ObjectNode toObjectNode() {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
                                                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.setSerializationInclusion(Include.NON_NULL);
        //mapper.configOverride(Map.class).setInclude(Value.construct(JsonInclude.Include.NON_NULL, JsonInclude.Include.NON_NULL));  
        
        ObjectNode beneficiary = mapper.createObjectNode();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //String nullValue = null;

        if (offlineId != null) {
            beneficiary.put("id", offlineId);
        } else {
            beneficiary.put("id", id);
        }
        
        if (dateUpdated == null || dateUpdated.after(dateCreated)) {
            beneficiary.put("id", id);
            beneficiary.put("nui", nui);
            beneficiary.put("name", name);
            beneficiary.put("surname", surname);
            beneficiary.put("nickname", nickName);
            beneficiary.put("organization_id", partners.getId());
            beneficiary.put("date_of_birth", dateFormat.format(dateOfBirth));
            beneficiary.put("gender", String.valueOf(gender));
            beneficiary.put("adress", address);
            beneficiary.put("phone_number", phoneNumber);
            beneficiary.put("email", EMail);
            beneficiary.put("enrollment_date", enrollmentDate != null ? dateFormat.format(enrollmentDate): null);
            beneficiary.put("via", via);
            beneficiary.put("partner_id", partnerId == null ? null : 1); // TODO
            beneficiary.put("nationality", nationality);
            beneficiary.put("entry_point", entryPoint);
            beneficiary.put("neighborhood_id", neighborhood.getId());
            beneficiary.put("locality_name", neighborhood.getLocality().getName());
            beneficiary.put("us_id", us.getId());
            if(vbltLivesWith != null) beneficiary.put("vblt_lives_with", vbltLivesWith);
            if(vbltIsOrphan != null) beneficiary.put("vblt_is_orphan", vbltIsOrphan);
            if(vbltIsStudent != null) beneficiary.put("vblt_is_student", vbltIsStudent);
            if(vbltSchoolGrade != null) beneficiary.put("vblt_school_grade", vbltSchoolGrade);
            if(vbltSchoolName != null) beneficiary.put("vblt_school_name", vbltSchoolName);
            if(vbltIsDeficient != null) beneficiary.put("vblt_is_deficient", vbltIsDeficient);
            if(vbltDeficiencyType != null) beneficiary.put("vblt_deficiency_type", vbltDeficiencyType);
            if(vbltMarriedBefore != null) beneficiary.put("vblt_married_before", vbltMarriedBefore);
            if(vbltPregnantBefore != null) beneficiary.put("vblt_pregnant_before", vbltPregnantBefore);
            if(vbltChildren != null) beneficiary.put("vblt_children", vbltChildren);
            if(vbltPregnantOrBreastfeeding != null) beneficiary.put("vblt_pregnant_or_breastfeeding", vbltPregnantOrBreastfeeding);
            if(vbltIsEmployed != null) beneficiary.put("vblt_is_employed", vbltIsEmployed);
            if(vbltTestedHiv != null) beneficiary.put("vblt_tested_hiv", vbltTestedHiv);
            if(vbltSexuallyActive != null) beneficiary.put("vblt_sexually_active", vbltSexuallyActive);
            if(vbltMultiplePartners != null) beneficiary.put("vblt_multiple_partners", vbltMultiplePartners);
            if(vbltIsMigrant != null) beneficiary.put("vblt_is_migrant", vbltIsMigrant);
            if(vbltTraffickingVictim != null) beneficiary.put("vblt_trafficking_victim", vbltTraffickingVictim);
            if(vbltSexualExploitation != null) beneficiary.put("vblt_sexual_exploitation", vbltSexualExploitation);
            if(vbltSexploitationTime != null) beneficiary.put("vblt_sexploitation_time", vbltSexploitationTime);
            if(vbltVbgVictim != null) beneficiary.put("vblt_vbg_victim", vbltVbgVictim);
            if(vbltVbgType != null) beneficiary.put("vblt_vbg_type", vbltVbgType);
            if(vbltVbgTime != null) beneficiary.put("vblt_vbg_time", vbltVbgTime);
            if(vbltAlcoholDrugsUse != null) beneficiary.put("vblt_alcohol_drugs_use", vbltAlcoholDrugsUse);
            if(vbltStiHistory != null) beneficiary.put("vblt_sti_history", vbltStiHistory);
            if(vbltSexWorker != null) beneficiary.put("vblt_sex_worker", vbltSexWorker);
            if(vbltHouseSustainer != null) beneficiary.put("vblt_house_sustainer", vbltHouseSustainer);
            
            int[] ids = referenceses.stream()
                    .mapToInt(References::getId)
                    .toArray();
       
            beneficiary.put("references", Arrays.toString(ids));
            beneficiary.put("online_id", id); // flag to control if entity is synchronized with the backend
        } else { // ensure online_id is updated first
            beneficiary.put("online_id", id);
        }
        return beneficiary;
    }

    public void update(BeneficiarySyncModel model, String timestamp) {
        Long t = Long.valueOf(timestamp);
        this.offlineId = model.getId();
        this.dateUpdated = new Date(t);
        this.nui = model.getNui();
        this.name = model.getName();
        this.surname = model.getSurname();
        this.nickName = model.getNick_name();
        this.partners.setId(model.getOrganization_id());
        this.dateOfBirth = model.getDate_of_birth();
        this.gender = model.getGender();
        this.address = model.getAddress();
        this.phoneNumber = model.getPhone_number();
        this.EMail = model.getE_mail();
        this.enrollmentDate = model.getEnrollment_date();
        this.via = model.getVia();
        this.partnerId = model.getPartner_id();
        this.nationality = model.getNationality();
        this.entryPoint = model.getEntry_point();
        this.neighborhood.setId(model.getNeighbourhood_id());
        this.us = new Us(model.getUs_id());
        this.status = Integer.valueOf(model.getStatus());
        this.vbltLivesWith = model.getVblt_lives_with();
        this.vbltIsOrphan = (byte) model.getVblt_is_orphan();
        this.vbltIsStudent = (byte) model.getVblt_is_student();
        this.vbltSchoolGrade = model.getVblt_school_grade();
        this.vbltSchoolName = model.getVblt_school_name();
        this.vbltIsDeficient = (byte) model.getVblt_is_deficient();
        this.vbltDeficiencyType = model.getVblt_deficiency_type();
        this.vbltMarriedBefore = (byte) model.getVblt_married_before();
        this.vbltPregnantBefore = (byte) model.getVblt_pregnant_before();
        this.vbltChildren = (byte) model.getVblt_children();
        this.vbltPregnantOrBreastfeeding = (byte) model.getVblt_pregnant_or_breastfeeding();
        this.vbltIsEmployed = model.getVblt_is_employed();
        this.vbltTestedHiv = model.getVblt_tested_hiv();
        this.vbltSexuallyActive = (byte) model.getVblt_sexually_active();
        this.vbltMultiplePartners = (byte) model.getVblt_multiple_partners();
        this.vbltIsMigrant = (byte) model.getVblt_is_migrant();
        this.vbltTraffickingVictim = (byte) model.getVblt_trafficking_victim();
        this.vbltSexualExploitation = (byte) model.getVblt_sexual_exploitation();
        this.vbltSexploitationTime = model.getVblt_sexploitation_time();
        this.vbltVbgVictim = (byte) model.getVblt_vbg_victim();
        this.vbltVbgType = model.getVblt_vbg_type();
        this.vbltVbgTime = model.getVblt_vbg_time();
        this.vbltAlcoholDrugsUse = (byte) model.getVblt_alcohol_drugs_use();
        this.vbltStiHistory = (byte) model.getVblt_sti_history();
        this.vbltSexWorker = (byte) model.getVblt_sex_worker();
        this.vbltHouseSustainer = (byte) model.getVblt_house_sustainer();
    }
    
    public void fill(ObjectNode obj, String field, Object value) {
    	if(value == null) {
    		return;
    	}
    	
    	if(value instanceof String) {
    		obj.put(field, (String)value);
    	}
    	if(value instanceof Byte) {
    		obj.put(field, (Byte)value);
    	}
    	if(value instanceof Double) {
    		obj.put(field, (Double)value);
    	}
    	if(value instanceof Integer) {
    		obj.put(field, (Integer)value);
    	}
    	if(value instanceof Float) {
    		obj.put(field, (Float)value);
    	}
    }

}
