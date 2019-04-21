package jumia.pay.service;

import jumia.pay.dto.PaymentRequest;
import jumia.pay.enums.Actions;
import jumia.pay.interfaces.Auditable;
import jumia.pay.interfaces.PaymentService;
import jumia.pay.model.Transaction;

public class PaymentServiceImpl implements PaymentService {

    @Auditable(actionType = Actions.MAKE_PAYMENT)
    public Transaction makePayment(PaymentRequest request,String auditorEmail) {
        return null;
    }

    @Auditable(actionType = Actions.REVERSE_PAYMENT)
    public Transaction reversePayment(PaymentRequest request,String auditorEmail) {
        return null;
    }
}
