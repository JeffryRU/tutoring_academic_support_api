package controller.online_payment_module;

import domain.online_payment_module.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService; // Asume que tienes un servicio de transacciones

    @PostMapping("/create")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        return ResponseEntity.ok(createdTransaction);
    }

    @GetMapping("/details/{paymentId}")
    public ResponseEntity<List<Transaction>> getTransactionsByPaymentId(@PathVariable Long paymentId) {
        List<Transaction> transactions = transactionService.getTransactionsByPaymentId(paymentId);
        return ResponseEntity.ok(transactions);
    }
}
