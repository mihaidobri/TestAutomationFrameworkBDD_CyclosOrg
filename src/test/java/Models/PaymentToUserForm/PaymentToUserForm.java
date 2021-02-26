package Models.PaymentToUserForm;

import com.poiji.annotation.ExcelCell;

public class PaymentToUserForm {

    @ExcelCell(0)
    private String username;
    @ExcelCell(1)
    private String ammountInteger;
    @ExcelCell(2)
    private String ammountDecimal;
    @ExcelCell(3)
    private String description;
    @ExcelCell(4)
    private String actualUsername;
    @ExcelCell(5)
    private String fromAccount;
    @ExcelCell(6)
    private String paymentType;
    @ExcelCell(7)
    private String passwordReceivedUser;

    public String getPasswordReceivedUser() {
        return passwordReceivedUser;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getUsername() {
        return username;
    }

    public String getAmmountInteger() {
        return ammountInteger;
    }

    public String getAmmountDecimal() {
        return ammountDecimal;
    }

    public String getDescription() {
        return description;
    }

    public String getActualUsername() {
        return actualUsername;
    }
}
