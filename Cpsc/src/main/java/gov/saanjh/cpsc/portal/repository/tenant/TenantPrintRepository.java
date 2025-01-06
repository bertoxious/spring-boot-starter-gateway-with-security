package gov.saanjh.cpsc.portal.repository.tenant;

import gov.saanjh.cpsc.portal.domain.tenant.TenantPrint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantPrintRepository extends JpaRepository<TenantPrint, Long> {

    TenantPrint findByTenantUid(Long tenantUid);
}
