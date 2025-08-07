package spring2;

public class Bank{
    private int bankId;
    private String bankName;

    public Bank(int bankId, String bankName){
        this.bankId =bankId;
        this.bankName= bankName;
    }

    public String getDetails() {
        return "Bank ID: "+ bankId +", Bank Name: "+ bankName;
    }
}
