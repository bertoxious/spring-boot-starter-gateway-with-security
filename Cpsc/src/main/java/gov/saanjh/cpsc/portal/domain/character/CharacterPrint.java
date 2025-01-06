package gov.saanjh.cpsc.portal.domain.character;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Table(name = "character_print")
@Data
public class CharacterPrint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_print_id")
    private Long characterPrintId;

    @Column(name = "character_uid")
    private Long characterUid;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Lob
    @Column(name = "file_data")
    private byte[] fileData;

    @Column(name = "pscode")
    private String psCode;

    @Column(name = "srvdatetime")
    private ZonedDateTime srvDateTime;

    @Column(name = "appname")
    private String appName;

    @Column(name = "email")
    private String email;

}

