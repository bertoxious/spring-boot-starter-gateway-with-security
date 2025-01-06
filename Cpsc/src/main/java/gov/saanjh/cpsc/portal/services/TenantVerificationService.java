package gov.saanjh.cpsc.portal.services;

import gov.saanjh.cpsc.portal.domain.tenant.TenantEntry;
import gov.saanjh.cpsc.portal.domain.tenant.TenantPrint;
import gov.saanjh.cpsc.portal.domain.tenant.TenantVerification;
import gov.saanjh.cpsc.portal.repository.tenant.TenantEntryRepository;
import gov.saanjh.cpsc.portal.repository.tenant.TenantPrintRepository;
import gov.saanjh.cpsc.portal.repository.tenant.TenantVerificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TenantVerificationService {

    @Autowired
    TenantVerificationRepository tenantVerificationRepository;

    @Autowired
    TenantPrintRepository tenantPrintRepository;

    @Autowired
    TenantEntryRepository tenantEntryRepository;

    public List<TenantVerification> getAllTenantVerifications() {
        return tenantVerificationRepository.findAll();
    }

    public TenantVerification getById(Long tenantVerificationId) {
        return tenantVerificationRepository.findByTenantVerificationId(tenantVerificationId);
    }

    public TenantVerification moveToPsLevel(Long tenantVerificationId) {
        TenantVerification tenantVerifications = tenantVerificationRepository.findByTenantVerificationId(tenantVerificationId);
        if (tenantVerifications != null) {
            tenantVerifications.setPRemarks(null);
            tenantVerifications.setPDate(null);
            tenantVerifications.setReasonStatus(null);
            return tenantVerificationRepository.save(tenantVerifications);
        } else {
            throw new IllegalArgumentException("Tenant Verification not found for ID: " + tenantVerificationId);
        }
    }

    public TenantVerification moveToPrintSection(Long tenantVerificationId) {
        TenantVerification tenantVerification = tenantVerificationRepository.findByTenantVerificationId(tenantVerificationId);

        if (tenantVerification != null) {
            tenantVerification.setDispatchDate(null);
            tenantVerification.setDispatchNo(null);
            TenantPrint tenantPrint = tenantPrintRepository.findByTenantUid(tenantVerificationId);
            if (tenantPrint != null) {
                log.info("Tenant Print data: {}", tenantPrint);
                Long tenantPrintId = tenantPrint.getTenantPrintId();
                tenantPrintRepository.deleteById(tenantPrintId);
            } else {
                log.info("Tenant Print not found for tenant UID: " + tenantVerificationId);
            }
            return tenantVerificationRepository.save(tenantVerification);
        } else {
            throw new IllegalArgumentException("Tenant Verification not found for ID: " + tenantVerificationId);
        }
    }

    public TenantVerification markedPs(Long tenantVerificationId) {
        TenantVerification tenantVerification = tenantVerificationRepository.findByTenantVerificationId(tenantVerificationId);
        if (tenantVerification != null) {
            tenantVerification.setMarkingIo(null);
            tenantVerification.setIoDueDate(null);
            Optional<TenantEntry> tenantEntry = tenantEntryRepository.findById(tenantVerificationId);
            if (tenantEntry.isPresent()) {
                tenantEntryRepository.deleteById(tenantVerificationId);
            } else {
                log.info("Tenant Entry not found for tenant id: " + tenantVerificationId);
            }
        } else {
            throw new IllegalArgumentException("Tenant Verification not found for ID: " + tenantVerificationId);
        }
        return tenantVerificationRepository.save(tenantVerification);
    }

    public List<TenantVerification> getTenantVerificationsWithPagination(int page, int size) {
        int offset = page * size;
        return tenantVerificationRepository.findAllWithNativePagination(size, offset);
    }

    public Long getCountOfTenantVerifications(){
        return tenantVerificationRepository.findAll().stream().count();
    }
}
