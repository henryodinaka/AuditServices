package jumia.pay.enums;

public enum Actions {

    LOGIN,

    //Customer actions

    VIEW_PRODUCT,
    ADD_PRODUCT_TO_CART,
    REMOVE_PRODUCT_FROM_CART,
    CHECK_OUT,
    ORDER,
    MAKE_PAYMENT,
    CANCEL_ORDER,

    //Operations
    ADD_PRODUCT_TO_STORE,
    REMOVE_PRODUCT_FROM_STORE,
    UPDATE_PRODUCT,
    UNBLOCK_USER,
    BLOCK_USER,

    //Customer service

    SEARCH_TRACKING_NO,
    CANCEL_CUSTOMER_ORDER,
    REVERSE_PAYMENT;

}
