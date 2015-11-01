package test_models;

/**
 * Created by Евгений on 27.09.2015.
 */
public class PlayerFullBuilder {
    private String requestSender;
    private String password;
    private String email;
    private String phone;
    private String gender;
    private boolean payment;
    private String realMoney;
    private String funMoney;
    private String bonusDollars;
    private String loyaltyPoints;
    private String login;
    private String regStatus;
    private String chatEnabled;
    private String isCommunity;
    private String ownerID;
    private String fName;
    private String lName;
    private String city;
    private String country;
    private String address;
    private String birthday;
    private String disableLp;
    private String paymentChatEnabled;
    private String pittBossAlertEnabled;
    private String creditType;
    private String creditAmount;
    private String creditFrequency;
    private String creditNextReset;
    private String creditTemp;
    private String creditExpiration;
    private String creditComment;
    private String stopWeeklyReset;

    public PlayerFullBuilder withRequestSender(String requestSender) {
        this.requestSender = requestSender;
        return this;
    }

    public PlayerFullBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public PlayerFullBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public PlayerFullBuilder withRegStatus(String regStatus) {
        this.regStatus = regStatus;
        return this;
    }

    public PlayerFullBuilder withChatEnabled(String chatEnabled) {
        this.chatEnabled = chatEnabled;
        return this;
    }

    public PlayerFullBuilder withIsCommunity(String isCommunity) {
        this.isCommunity = isCommunity;
        return this;
    }

    public PlayerFullBuilder withOwnerId(String ownerID) {
        this.ownerID = ownerID;
        return this;
    }

    public PlayerFullBuilder withFName(String fName) {
        this.fName = fName;
        return this;
    }

    public PlayerFullBuilder withLName(String lName) {
        this.lName = lName;
        return this;
    }

    public PlayerFullBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public PlayerFullBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public PlayerFullBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public PlayerFullBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public PlayerFullBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public PlayerFullBuilder withBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public PlayerFullBuilder withDisableLp(String disableLp) {
        this.disableLp = disableLp;
        return this;
    }

    public PlayerFullBuilder withPaymentChatEnabled(String paymentChatEnabled) {
        this.paymentChatEnabled = paymentChatEnabled;
        return this;
    }

    public PlayerFullBuilder withPittBossAlertEnabled(String pittBossAlertEnabled) {
        this.pittBossAlertEnabled = pittBossAlertEnabled;
        return this;
    }

    public PlayerFullBuilder withCreditType(String creditType) {
        this.creditType = creditType;
        return this;
    }

    public PlayerFullBuilder withCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
        return this;
    }

    public PlayerFullBuilder withCreditNextReset(String creditNextReset) {
        this.creditNextReset = creditNextReset;
        return this;
    }

    public PlayerFullBuilder withCreditFrequency(String creditFrequency) {
        this.creditFrequency = creditFrequency;
        return this;
    }

    public PlayerFullBuilder withCreditTemp(String creditTemp) {
        this.creditTemp = creditTemp;
        return this;
    }

    public PlayerFullBuilder withCreditExpiration(String creditExpiration) {
        this.creditExpiration = creditExpiration;
        return this;
    }

    public PlayerFullBuilder withCreditComment(String creditComment) {
        this.creditComment = creditComment;
        return this;
    }

    public PlayerFullBuilder withStopWeeklyReset(String stopWeeklyReset) {
        this.stopWeeklyReset = stopWeeklyReset;
        return this;
    }


    public PlayerFullBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public PlayerFullBuilder withPayment(boolean payment) {
        this.payment = payment;
        return this;
    }

    public PlayerFullBuilder withRealMoney(String realMoney) {
        this.realMoney = realMoney;
        return this;
    }

    public PlayerFullBuilder withFunMoney(String funMoney) {
        this.funMoney = funMoney;
        return this;
    }

    public PlayerFullBuilder withBonusDollars(String bonusDollars) {
        this.bonusDollars = bonusDollars;
        return this;
    }

    public PlayerFullBuilder withLoyaltyPoints(String loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
        return this;
    }



    public PlayerFull build() {
        return new PlayerFull(requestSender, password, email, phone, gender,payment,realMoney,funMoney, bonusDollars, loyaltyPoints, login, regStatus, chatEnabled, isCommunity, ownerID, fName, lName, city, country,  address,birthday, disableLp, paymentChatEnabled, pittBossAlertEnabled, creditType, creditAmount, creditFrequency, creditNextReset, creditTemp, creditExpiration, creditComment, stopWeeklyReset);
    }






}
