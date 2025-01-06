package gov.saanjh.cpsc.portal.domain.tenant;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Table(name = "tenant_entry")
@Data
public class TenantEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenant_id")
    private Long tenantId;

    @Column(name = "t_fname")
    private String tenantFirstName;

    @Column(name = "t_gender")
    private String tenantGender;

    @Column(name = "t_mobile")
    private String tenantMobile;

    @Column(name = "t_email")
    private String tenantEmail;

    @Column(name = "t_name")
    private String tenantName;

    @Column(name = "t_state")
    private String tenantState;

    @Column(name = "t_district")
    private String tenantDistrict;

    @Column(name = "t_policestation")
    private String tenantPoliceStation;

    @Column(name = "l_state")
    private String landlordState;

    @Column(name = "l_district")
    private String landlordDistrict;

    @Column(name = "l_area")
    private String landlordArea;

    @Column(name = "l_policestation")
    private String landlordPoliceStation;

    @Column(name = "t_date")
    private String tenantDate;

    @Column(name = "t_time")
    private String tenantTime;

    @Column(name = "t_tenantname")
    private String tenantFullName;

    @Column(name = "l_name")
    private String landlordName;

    @Column(name = "l_fname")
    private String landlordFirstName;

    @Column(name = "pscode")
    private String policeStationCode;

    @Column(name = "file_data")
    private String fileData;

    @Column(name = "t_uid")
    private String tenantUID;

    @Column(name = "enterdate")
    private ZonedDateTime enterDate;

    @Column(name = "file_photo")
    private String filePhoto;

    @Column(name = "relation")
    private String relation;

    @Column(name = "dob")
    private String dateOfBirth;

    @Column(name = "age")
    private String age;

    @Column(name = "religion")
    private String religion;

    @Column(name = "prenting")
    private String prenting;

    @Column(name = "teantmobile")
    private String tenantMobileAlternative;

    @Column(name = "photoidtype")
    private String photoIdType;

    @Column(name = "photoidno")
    private String photoIdNumber;

    @Column(name = "land_relation")
    private String landRelation;

    @Column(name = "t_address")
    private String tenantAddress;

    @Column(name = "refer_by")
    private String referredBy;

    @Column(name = "l_mobile")
    private String landlordMobile;

    @Column(name = "l_address")
    private String landlordAddress;

    @Column(name = "t_totime")
    private String tenantToTime;

}

