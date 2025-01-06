package gov.saanjh.cpsc.portal.domain.tenant;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tenantverification")
public class TenantVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenantverificationid")
    private Long tenantVerificationId;

    @Column(name = "uid")
    private String uid;

    @Column(name = "idno")
    private String idNo;

    @Column(name = "tenantname")
    private String tenantName;

    @Column(name = "father")
    private String father;

    @Column(name = "pscode")
    private String psCode;

    @Column(name = "pdate")
    private String pDate;

    @Column(name = "premarks")
    private String pRemarks;

    @Column(name = "dispatchno")
    private String dispatchNo;

    @Column(name = "dispatchdate")
    private String dispatchDate;

    @Column(name = "reasonstatus")
    private String reasonStatus;

    @Column(name = "cpscstatus")
    private String cpscStatus;

    @Column(name = "cpscreasonstatus")
    private String cpscReasonStatus;

    @Column(name = "pstation")
    private String pStation;

    @Column(name = "enterdate")
    private LocalDateTime enterDate;

    @Column(name = "markingio")
    private String markingIo;

    @Column(name = "ioduedate")
    private String ioDueDate;
}

