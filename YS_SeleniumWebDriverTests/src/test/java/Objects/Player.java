package Objects;

/**
 * Created by Евгений on 27.09.2015.
 */
public class Player {
    public String userName;
    public String password;
    public String email;
    public String phone;
    public String gender;
    public boolean payment;
    public String realMoney;
    public String funMoney;
    public String bonusDollars;
    public String loyaltyPoints;

    public Player(String userName, String password, String email, String phone, String gender,
                  boolean payment,String realMoney,String funMoney,String bonusDollars,String loyaltyPoints ) {

        this.userName=userName;
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
