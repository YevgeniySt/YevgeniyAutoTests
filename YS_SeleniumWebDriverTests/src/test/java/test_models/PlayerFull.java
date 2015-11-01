package test_models;

/**
 * Created by YevgeniyS on 15/10/2015.
 */
public class PlayerFull {

    public String requestSender;
    public String login;
    public String regStatus;
    public String chatEnabled;
    public String isCommunity;
    public String ownerID;
    public String fName;
    public String lName;
    public String city;
    public String country;
    public String address;
    public String birthday;
    public String disableLp;
    public String paymentChatEnabled;
    public String pittBossAlertEnabled;
    public String creditType;
    public String creditAmount;
    public String creditFrequency;
    public String creditNextReset;
    public String creditTemp;
    public String creditExpiration;
    public String creditComment;
    public String stopWeeklyReset;

    public String password;
    public String email;
    public String phone;
    public String gender;
    public boolean payment;
    public String realMoney;
    public String funMoney;
    public String bonusDollars;
    public String loyaltyPoints;



    public PlayerFull(String requestSender, String password, String email, String phone, String gender,
                      boolean payment, String realMoney, String funMoney, String bonusDollars, String loyaltyPoints, String login, String regStatus,
                      String chatEnabled, String isCommunity, String ownerID, String fName, String lName, String city, String country, String address, String birthday,
                      String disableLp, String paymentChatEnabled, String pittBossAlertEnabled, String creditType, String creditAmount, String creditFrequency,
                      String creditNextReset, String creditTemp, String creditExpiration, String creditComment, String stopWeeklyReset) {
        this.requestSender = requestSender;
        this.login = login;
        this.regStatus = regStatus;
        this.chatEnabled = chatEnabled;
        this.isCommunity = isCommunity;
        this.ownerID = ownerID;
        this.fName = fName;
        this.lName = lName;
        this.city = city;
        this.country = country;
        this.address = address;
        this.birthday = birthday;
        this.disableLp = disableLp;
        this.paymentChatEnabled = paymentChatEnabled;
        this.pittBossAlertEnabled = pittBossAlertEnabled;
        this.creditType = creditType;
        this.creditAmount = creditAmount;
        this.creditFrequency = creditFrequency;
        this.creditNextReset = creditNextReset;
        this.creditTemp = creditTemp;
        this.creditExpiration = creditExpiration;
        this.creditComment = creditComment;
        this.stopWeeklyReset = stopWeeklyReset;



        this.password=password;
        this.email=email;
        this.phone=phone;
        this.gender=gender;
        this.payment=payment;
        this.realMoney=realMoney;
        this.funMoney=funMoney;
        this.bonusDollars=bonusDollars;
        this.loyaltyPoints=loyaltyPoints;
    }
}
