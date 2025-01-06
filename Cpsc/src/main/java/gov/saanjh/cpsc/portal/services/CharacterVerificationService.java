package gov.saanjh.cpsc.portal.services;

import gov.saanjh.cpsc.portal.domain.character.CharacterPrint;
import gov.saanjh.cpsc.portal.domain.character.CharacterVerification;
import gov.saanjh.cpsc.portal.repository.character.CharacterPrintRepository;
import gov.saanjh.cpsc.portal.repository.character.CharacterVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterVerificationService {

    @Autowired
    CharacterVerificationRepository characterVerificationRepository;

    @Autowired
    CharacterPrintRepository characterPrintRepository;

    public List<CharacterVerification> getCharacterVerificationsWithPagination(int page, int size) {
        int offset = page * size;
        return characterVerificationRepository.findAllWithNativePagination(size, offset);
    }

    public Optional<CharacterVerification> getById(Long id) {
        return characterVerificationRepository.findById(id);
    }

    public CharacterVerification moveToPrintSection(Long id) {
        Optional<CharacterVerification> characterVerification = characterVerificationRepository.findById(id);
        if (characterVerification.isPresent()) {
            characterVerification.get().setDispatchDate(null);
            characterVerification.get().setDispatchNo(null);

            Optional<CharacterPrint> characterPrint = characterPrintRepository.findById(id);
            if (characterPrint.isPresent()) {
                characterPrintRepository.deleteById(id);
            } else {
                throw new IllegalArgumentException("Character Print not found for character id: " + id);
            }
            return characterVerificationRepository.save(characterVerification.get());
        } else {
            throw new IllegalArgumentException("Character Verification not found for id: " + id);
        }
    }
}
