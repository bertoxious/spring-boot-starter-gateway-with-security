package gov.saanjh.cpsc.portal.repository.character;

import gov.saanjh.cpsc.portal.domain.character.CharacterVerification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterVerificationRepository extends JpaRepository<CharacterVerification, Long> {

    @Query(value = "SELECT * FROM characterverification ORDER BY characterverificationid LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<CharacterVerification> findAllWithNativePagination(@Param("limit") int limit, @Param("offset") int offset);

}
