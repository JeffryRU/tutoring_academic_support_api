package controller.online_payment_module;

import domain.online_payment_module.Payment;
import domain.online_payment_module.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService; // Asume que tienes un servicio de pagos

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return ResponseEntity.ok(createdPayment);
    }

    @GetMapping("/history/{studentId}")
    public ResponseEntity<List<Payment>> getPaymentHistory(@PathVariable Long studentId) {
        List<Payment> payments = paymentService.getPaymentHistory(studentId);
        return ResponseEntity.ok(payments);
    }
}
