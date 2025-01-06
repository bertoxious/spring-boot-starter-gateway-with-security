package gov.saanjh.citizen.portal.repository;

import gov.saanjh.citizen.portal.domain.OnlinePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OnlinePaymentRepository extends JpaRepository<OnlinePayment, Long> {

    OnlinePayment findByModuleIdAndPsCode(String moduleId, String psCode);

    @Query(value = "SELECT * FROM onlinepayment ORDER BY id LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<OnlinePayment> findAllWithNativePagination(@Param("limit") int limit, @Param("offset") int offset);
}
