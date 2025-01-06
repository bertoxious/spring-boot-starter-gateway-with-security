package gov.saanjh.citizen.portal.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Table(name = "onlinepayment")
@Data
public class OnlinePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String module;
    @Column(name = "pstation")
    private String pStation;
    @Column(name = "merchand_code")
    private String merchandCode;
    private String amount;
    @Column(name = "payment_status")
    private String paymentStatus;
    @Column(name = "pscode")
    private String psCode;
    @Column(name = "enterdate")
    private OffsetDateTime enterDate;
    private String uid;
    @Column(name = "module_id")
    private String moduleId;
    private String district;
    @Column(name = "shopping_cart_details")
    private String shoppingCartDetails;

}
