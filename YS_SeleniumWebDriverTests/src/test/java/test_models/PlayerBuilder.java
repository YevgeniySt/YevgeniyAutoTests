package test_models;

/**
 * Created by Евгений on 27.09.2015.
 */
public class PlayerBuilder {
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String gender;
    private boolean payment;
    private String realMoney;
    private String funMoney;
    private String bonusDollars;
    private String loyaltyPoints;

    public PlayerBuilder withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public PlayerBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public PlayerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public PlayerBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public PlayerBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public PlayerBuilder withPayment(boolean payment) {
        this.payment = payment;
        return this;
    }

    public PlayerBuilder withRealMoney(String realMoney) {
        this.realMoney = realMoney;
        return this;
    }

    public PlayerBuilder withFunMoney(String funMoney) {
        this.funMoney = funMoney;
        return this;
    }

    public PlayerBuilder withBonusDollars(String bonusDollars) {
        this.bonusDollars = bonusDollars;
        return this;
    }

    public PlayerBuilder withLoyaltyPoints(String loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
        return this;
    }



    public Player build() {
        return new Player(userName, password, email, phone, gender,payment,realMoney,funMoney, bonusDollars, loyaltyPoints);
    }






}
