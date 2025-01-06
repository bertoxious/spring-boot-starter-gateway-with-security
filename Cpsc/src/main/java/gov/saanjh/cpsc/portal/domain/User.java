package gov.saanjh.cpsc.portal.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userserialid")
    private Long userSerialId;

    @Column(name = "userid", nullable = false, length = 15)
    private String userId;

    @Column(name = "status", length = 15)
    private String status;

    @Column(name = "pscode", length = 15)
    private String psCode;

    @Column(name = "role", columnDefinition = "character varying DEFAULT '2'")
    private String role;

    @Column(name = "location")
    private String location;

    @Column(name = "enterdate")
    private LocalDateTime enterDate;

    @Column(name = "macaddress")
    private String macAddress;

    @Column(name = "imei_no")
    private String imeiNo;

    @Column(name = "password_change_date", nullable = false, columnDefinition = "timestamp with time zone DEFAULT current_timestamp")
    private OffsetDateTime passwordChangeDate;
}
