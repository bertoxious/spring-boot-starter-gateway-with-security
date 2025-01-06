package gov.saanjh.cpsc.portal.repository.character;

import gov.saanjh.cpsc.portal.domain.character.CharacterPrint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterPrintRepository extends JpaRepository<CharacterPrint, Long> {
}
