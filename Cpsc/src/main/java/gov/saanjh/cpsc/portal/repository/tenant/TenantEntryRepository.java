package gov.saanjh.cpsc.portal.repository.tenant;

import gov.saanjh.cpsc.portal.domain.tenant.TenantEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantEntryRepository extends JpaRepository<TenantEntry, Long> {
}
