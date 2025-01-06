package gov.saanjh.cpsc.portal.repository;

import gov.saanjh.cpsc.portal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);

    @Query(value = "SELECT * FROM users ORDER BY userId LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<User> findAllWithNativePagination(@Param("limit") int limit, @Param("offset") int offset);
}
