package gov.saanjh.citizen.portal.services;

import gov.saanjh.citizen.portal.domain.OnlinePayment;
import gov.saanjh.citizen.portal.repository.OnlinePaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OnlinePaymentService {

    @Autowired
    OnlinePaymentRepository onlinePaymentRepository;

    public List<OnlinePayment> getAllPayments() {
        return onlinePaymentRepository.findAll();
    }

    public OnlinePayment getByModuleIdAndPsCode(String moduleId, String psCode) {
        return onlinePaymentRepository.findByModuleIdAndPsCode(moduleId, psCode);
    }

    public OnlinePayment updateStatusOfPayment(String moduleId, String psCode) {
        OnlinePayment payment = onlinePaymentRepository.findByModuleIdAndPsCode(moduleId, psCode);
        if (payment != null) {
            if ("false".equalsIgnoreCase(payment.getPaymentStatus())) {
                payment.setPaymentStatus("true");
                return onlinePaymentRepository.save(payment);
            } else {
                throw new IllegalArgumentException("Cannot update because payment status is already true");
            }
        } else {
            throw new IllegalArgumentException("Module ID or PS Code is not present");
        }
    }

    public List<OnlinePayment> getOnlinePaymentsWithPagination(int page, int size) {
        int limit = size;
        int offset = (page - 1) * size;
        log.info("Limit: {}, Offset: {}", limit, offset);
        return onlinePaymentRepository.findAllWithNativePagination(limit, offset);
    }

    public Long getCountOfOnlinePayments(){
        return onlinePaymentRepository.findAll().stream().count();
    }

}
