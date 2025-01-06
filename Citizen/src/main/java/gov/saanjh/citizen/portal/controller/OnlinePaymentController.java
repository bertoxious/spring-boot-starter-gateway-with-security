package gov.saanjh.citizen.portal.controller;

import gov.saanjh.citizen.portal.domain.OnlinePayment;
import gov.saanjh.citizen.portal.services.OnlinePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/online-payment")
@CrossOrigin("*")
public class OnlinePaymentController {

    @Autowired
    OnlinePaymentService onlinePaymentService;

    @GetMapping("/all")
    public ResponseEntity<List<OnlinePayment>> getAllPayments() {
        List<OnlinePayment> payments = onlinePaymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> getByModuleIdAndPsCode(@RequestParam String moduleId,
                                                    @RequestParam String psCode) {
        OnlinePayment payment = onlinePaymentService.getByModuleIdAndPsCode(moduleId, psCode);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Module ID or PS Code is not present");
    }

    @PutMapping("/update-status")
    public ResponseEntity<?> updatePaymentStatus(@RequestParam String moduleId,
                                                 @RequestParam String psCode) {
        try {
            OnlinePayment updatedPayment = onlinePaymentService.updateStatusOfPayment(moduleId, psCode);
            return ResponseEntity.ok(updatedPayment);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/payments")
    public List<OnlinePayment> getOnlinePaymentsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return onlinePaymentService.getOnlinePaymentsWithPagination(page, size);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCountOfOnlinePayments(){
        Long count = onlinePaymentService.getCountOfOnlinePayments();
        return ResponseEntity.ok(count);
    }

}
