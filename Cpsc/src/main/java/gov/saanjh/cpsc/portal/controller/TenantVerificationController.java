package gov.saanjh.cpsc.portal.controller;

import gov.saanjh.cpsc.portal.domain.User;
import gov.saanjh.cpsc.portal.domain.tenant.TenantVerification;
import gov.saanjh.cpsc.portal.services.TenantVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant-verification")
//@CrossOrigin("*")
public class TenantVerificationController {

    @Autowired
    TenantVerificationService tenantVerificationService;

    @GetMapping("/all")
    public ResponseEntity<List<TenantVerification>> getAllTenantVerifications() {
        List<TenantVerification> tenantVerification = tenantVerificationService.getAllTenantVerifications();
        return ResponseEntity.ok(tenantVerification);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<TenantVerification> getById(@RequestParam Long tenantVerificationId) {
        TenantVerification tenantVerification = tenantVerificationService.getById(tenantVerificationId);
        return ResponseEntity.ok(tenantVerification);
    }

    @PutMapping("/ps-level")
    public ResponseEntity<TenantVerification> moveToPsLevel(@RequestParam Long tenantVerificationId) {
        TenantVerification tenantVerification = tenantVerificationService.moveToPsLevel(tenantVerificationId);
        return ResponseEntity.ok(tenantVerification);
    }

    @PutMapping("/print-section")
    public ResponseEntity<TenantVerification> moveToPrintSection(@RequestParam Long tenantVerificationId) {
        TenantVerification tenantVerification = tenantVerificationService.moveToPrintSection(tenantVerificationId);
        return ResponseEntity.ok(tenantVerification);
    }

    @PutMapping("/marked-ps")
    public ResponseEntity<TenantVerification> markedPs(@RequestParam Long tenantVerificationId) {
        TenantVerification tenantVerification = tenantVerificationService.markedPs(tenantVerificationId);
        return ResponseEntity.ok(tenantVerification);
    }

    @GetMapping("/verifications")
    public List<TenantVerification> getTenantVerificationsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return tenantVerificationService.getTenantVerificationsWithPagination(page, size);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCountOfTenantVerifications(){
        return ResponseEntity.status(HttpStatus.OK).body(tenantVerificationService.getCountOfTenantVerifications());
    }

}
