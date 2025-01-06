package gov.saanjh.cpsc.portal.domain.character;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "characterverification")
public class CharacterVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characterverificationid")
    private Long characterVerificationId;

    @Column(name = "idno")
    private String idNo;

    @Column(name = "vdate")
    private String vDate;

    @Column(name = "refno")
    private String refNo;

    @Column(name = "refdate")
    private String refDate;

    @Column(name = "reffrom")
    private String refFrom;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "dob")
    private String dob;

    @Column(name = "relation")
    private String relation;

    @Column(name = "rfirstname")
    private String rFirstName;

    @Column(name = "rmiddlename")
    private String rMiddleName;

    @Column(name = "rlastname")
    private String rLastName;

    @Column(name = "village")
    private String village;

    @Column(name = "street")
    private String street;

    @Column(name = "phoneno")
    private String phoneNo;

    @Column(name = "mobileno")
    private String mobileNo;

    @Column(name = "village1")
    private String village1;

    @Column(name = "street1")
    private String street1;

    @Column(name = "city1")
    private String city1;

    @Column(name = "phoneno1")
    private String phoneNo1;

    @Column(name = "mobileno1")
    private String mobileNo1;

    @Column(name = "pstation")
    private String pStation;

    @Column(name = "duedate")
    private String dueDate;

    @Column(name = "premarks")
    private String preMarks;

    @Column(name = "ciddate")
    private String cidDate;

    @Column(name = "cidremarks")
    private String cidRemarks;

    @Column(name = "dispatchno")
    private String dispatchNo;

    @Column(name = "dispatchdate")
    private String dispatchDate;

    @Column(name = "pscode")
    private String psCode;

    @Column(name = "pdate")
    private String pDate;

    @Column(name = "city")
    private String city;

    @Column(name = "rowid")
    private String rowId;

    @Column(name = "enterdate")
    private Timestamp enterDate;

    @Lob
    @Column(name = "file_data")
    private byte[] fileData;

    @Column(name = "uid")
    private String uid;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "district")
    private String district;

    @Column(name = "country1")
    private String country1;

    @Column(name = "state1")
    private String state1;

    @Column(name = "district1")
    private String district1;

    @Column(name = "markingio")
    private String markingIo;

    @Column(name = "ioduedate")
    private String ioDueDate;

    @Column(name = "cpscstatus")
    private String cpscStatus;

    @Lob
    @Column(name = "cam_photo")
    private byte[] camPhoto;

    @Column(name = "reasonstatus")
    private String reasonStatus;

    @Column(name = "cpscreasonstatus")
    private String cpscReasonStatus;

    @Column(name = "psocrecdate")
    private String psocRecDate;

    @Column(name = "psocverdate")
    private String psocVerDate;

    @Column(name = "cpscverdate")
    private String cpscVerDate;

    @Column(name = "cprcrecdate")
    private String cprcRecDate;

    @Column(name = "reference1")
    private String reference1;

    @Column(name = "reference2")
    private String reference2;

    @Column(name = "placebirth")
    private String placeOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "modby")
    private String modifiedBy;

    @Column(name = "moddate")
    private String modDate;

    @Column(name = "lastmoddate")
    private String lastModDate;

    @Column(name = "description")
    private String description;

    @Column(name = "citizen_id")
    private String citizenId;

    @Column(name = "mhc_status")
    private String mhcStatus;

    @Column(name = "sho_status")
    private String shoStatus;

    @Column(name = "mhc_datetime")
    private ZonedDateTime mhcDatetime;

    @Column(name = "mhc_status_reason")
    private String mhcStatusReason;

    @Column(name = "sho_datetime")
    private ZonedDateTime shoDatetime;

    @Column(name = "sho_status_reason")
    private String shoStatusReason;

    @Column(name = "road_challan_status")
    private String roadChallanStatus;

    @Column(name = "cprc_receive")
    private String cprcReceive;

    @Column(name = "road_challan_uniqueno")
    private String roadChallanUniqueNo;

    @Column(name = "road_challan_datetime")
    private ZonedDateTime roadChallanDatetime;

    @Column(name = "cprc_designated_officer_status")
    private String cprcDesignatedOfficerStatus;

    @Column(name = "srno")
    private Long srNo;

    @Column(name = "cprc_receive_datetime")
    private ZonedDateTime cprcReceiveDatetime;

    @Column(name = "cprc_designated_datetime")
    private ZonedDateTime cprcDesignatedDatetime;

    @Column(name = "cprc_designated_officer_status_reason")
    private String cprcDesignatedOfficerStatusReason;

    @Column(name = "dueto")
    private String dueTo;

    @Column(name = "denied")
    private String denied;

    @Column(name = "discrition_file4")
    private String discritionFile4;

    @Column(name = "discrition_file3")
    private String discritionFile3;

    @Column(name = "discrition_file2")
    private String discritionFile2;

    @Column(name = "discrition_file1")
    private String discritionFile1;

    @Column(name = "file_sub_type4")
    private String fileSubType4;

    @Column(name = "file_sub_type3")
    private String fileSubType3;

    @Column(name = "file_sub_type2")
    private String fileSubType2;

    @Column(name = "file_sub_type1")
    private String fileSubType1;

    @Column(name = "file_type2")
    private String fileType2;

    @Column(name = "file_type1")
    private String fileType1;

    @Column(name = "file_type3")
    private String fileType3;

    @Column(name = "file_type4")
    private String fileType4;

    @Lob
    @Column(name = "photo_data_1")
    private byte[] photoData1;

    @Lob
    @Column(name = "photo_data_2")
    private byte[] photoData2;

    @Lob
    @Column(name = "photo_data_3")
    private byte[] photoData3;

    @Lob
    @Column(name = "photo_data_4")
    private byte[] photoData4;

    @Column(name = "recorddetail")
    private String recordDetail;

    @Column(name = "crecord")
    private String cRecord;

    @Column(name = "durationmonth1")
    private String durationMonth1;

    @Column(name = "durationyear1")
    private String durationYear1;

    @Column(name = "pincode1")
    private String pinCode1;

    @Column(name = "tehsil1")
    private String tehsil1;

    @Column(name = "colony1")
    private String colony1;

    @Column(name = "streetname1")
    private String streetName1;

    @Column(name = "durationmonth")
    private String durationMonth;

    @Column(name = "durationyear")
    private String durationYear;

    @Column(name = "pincode")
    private String pinCode;

    @Column(name = "tehsil")
    private String tehsil;

    @Column(name = "colony")
    private String colony;

    @Column(name = "streetname")
    private String streetName;

    @Column(name = "birthyear")
    private String birthYear;

    @Column(name = "agemonth")
    private String ageMonth;

    @Column(name = "ageyear")
    private String ageYear;

    @Column(name = "landlineno")
    private String landlineNo;

    @Column(name = "applyperpose")
    private String applyPurpose;

    @Column(name = "idtype")
    private String idType;

    @Column(name = "mode_receiving")
    private String modeReceiving;

    @Column(name = "l_stdcode")
    private String lStdCode;

    @Column(name = "same_as_present")
    private String sameAsPresent;

    @Column(name = "discrition_file5")
    private String discritionFile5;

    @Column(name = "discrition_file6")
    private String discritionFile6;

    @Column(name = "file_sub_type5")
    private String fileSubType5;

    @Column(name = "file_sub_type6")
    private String fileSubType6;

    @Column(name = "file_type5")
    private String fileType5;

    @Column(name = "file_type6")
    private String fileType6;

    @Lob
    @Column(name = "photo_data_5")
    private byte[] photoData5;

    @Lob
    @Column(name = "photo_data_6")
    private byte[] photoData6;

    @Column(name = "modeofreccode")
    private String modeOfRecCode;

    @Column(name = "imagefilecode")
    private String imageFileCode;

    @Column(name = "imagesubfilecode")
    private String imageSubFileCode;

    @Column(name = "imagefilecode1")
    private String imageFileCode1;

    @Column(name = "idcode")
    private String idCode;

    @Column(name = "imagefilecode2")
    private String imageFileCode2;

    @Column(name = "imagefilecode3")
    private String imageFileCode3;

    @Column(name = "imagesubfilecode3")
    private String imageSubFileCode3;

    @Column(name = "imagesubfilecode1")
    private String imageSubFileCode1;

    @Column(name = "imagesubfilecode2")
    private String imageSubFileCode2;

    @Column(name = "imagesubfilecode4")
    private String imageSubFileCode4;

    @Column(name = "imagefilecode4")
    private String imageFileCode4;

    @Column(name = "imagefilecode5")
    private String imageFileCode5;

    @Column(name = "imagesubfilecode5")
    private String imageSubFileCode5;

    @Column(name = "cctns_id")
    private String cctnsId;

    @Column(name = "aadhar_no")
    private String aadharNo;

    @Column(name = "ref_name1")
    private String refName1;

    @Column(name = "ref_address1")
    private String refAddress1;

    @Column(name = "ref_mobile1")
    private String refMobile1;

    @Column(name = "ref_name2")
    private String refName2;

    @Column(name = "ref_address2")
    private String refAddress2;

    @Column(name = "ref_mobile2")
    private String refMobile2;

    @Column(name = "national_portal")
    private String nationalPortal;

    @Column(name = "mobile_number_ps")
    private String mobileNumberPs;

    @Column(name = "oldpstation")
    private String oldPStation;

    @Column(name = "oldpsocrecdate")
    private String oldPsocRecDate;

    @Column(name = "refdist")
    private String refDist;

    @Column(name = "camphoto_name")
    private String camPhotoName;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "qualification")
    private String qualification;

}

