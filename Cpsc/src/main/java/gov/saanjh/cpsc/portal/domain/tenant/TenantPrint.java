package gov.saanjh.cpsc.portal.domain.tenant;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "tenant_print")
public class TenantPrint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenant_print_id")
    private Long tenantPrintId;
    @Column(name = "tenant_uid")
    private Long tenantUid;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "pscode")
    private String psCode;
    @Column(name = "srvdatetime")
    private OffsetDateTime srvDateTime;
    @Column(name = "appname")
    private String appName;

}
