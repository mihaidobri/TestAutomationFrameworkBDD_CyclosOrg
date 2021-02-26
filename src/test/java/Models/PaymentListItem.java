package Models;

public class PaymentListItem {

    private String date;
    private String fromTo;
    private String description;
    private String ammount;

    public PaymentListItem(String date, String fromTo, String description, String ammount) {
        this.date = date;
        this.fromTo = fromTo;
        this.description = description;
        this.ammount = ammount;
    }

    public String getDate() {
        return date;
    }

    public String getFromTo() {
        return fromTo;
    }

    public String getDescription() {
        return description;
    }

    public String getAmmount() {
        return ammount;
    }
}

