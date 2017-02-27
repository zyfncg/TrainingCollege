package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ZhangYF on 2017/2/18.
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {
    private String accountid;
    private String bankcardid;
    private double money;

    @Id
    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }

    @Column(name = "bankcardid")
    public String getBankcardid() {
        return bankcardid;
    }

    public void setBankcardid(String bankcardid) {
        this.bankcardid = bankcardid;
    }

    @Column(name = "money")
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
