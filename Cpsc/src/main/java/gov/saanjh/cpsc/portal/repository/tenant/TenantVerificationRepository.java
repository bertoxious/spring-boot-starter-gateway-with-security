package gov.saanjh.cpsc.portal.repository.tenant;

import gov.saanjh.cpsc.portal.domain.User;
import gov.saanjh.cpsc.portal.domain.tenant.TenantVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantVerificationRepository extends JpaRepository<TenantVerification, Long> {

    TenantVerification findByTenantVerificationId(Long tenantVerificationId);

    @Query(value = "SELECT * FROM tenantverification ORDER BY tenantVerificationId LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<TenantVerification> findAllWithNativePagination(@Param("limit") int limit, @Param("offset") int offset);
}
