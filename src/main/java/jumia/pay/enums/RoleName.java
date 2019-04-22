package jumia.pay.enums;

public enum RoleName {
    CUSTOMER("Customer"),
    OPERATION("Operation"),
    CUSTOMERSERVICE("Customer Service");

    String name;

    RoleName(String name) {
        this.name = name;
    }
}
