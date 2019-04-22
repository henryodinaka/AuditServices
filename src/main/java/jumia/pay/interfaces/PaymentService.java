package jumia.pay.interfaces;

import jumia.pay.dto.PaymentRequest;
import jumia.pay.model.Transaction;


public interface PaymentService {
    Transaction makePayment(PaymentRequest request);
    Transaction reversePayment(PaymentRequest request);
}
