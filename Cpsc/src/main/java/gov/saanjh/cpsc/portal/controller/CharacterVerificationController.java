package gov.saanjh.cpsc.portal.controller;

import gov.saanjh.cpsc.portal.domain.character.CharacterVerification;
import gov.saanjh.cpsc.portal.services.CharacterVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/character-verification")
//@CrossOrigin("*")
public class CharacterVerificationController {

    @Autowired
    CharacterVerificationService characterVerificationService;

    @GetMapping("/all")
    public List<CharacterVerification> getCharacterVerifications(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return characterVerificationService.getCharacterVerificationsWithPagination(page, size);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Optional<CharacterVerification>> getById(@RequestParam Long id) {
        Optional<CharacterVerification> characterVerification = characterVerificationService.getById(id);
        return ResponseEntity.ok(characterVerification);
    }

    @PutMapping("/print-section")
    public ResponseEntity<CharacterVerification> moveToPrintSection(@RequestParam Long id) {
        CharacterVerification characterVerification = characterVerificationService.moveToPrintSection(id);
        return ResponseEntity.ok(characterVerification);
    }

}
