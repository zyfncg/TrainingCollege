package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ZhangYF on 2017/2/18.
 */
@Entity
@Table(name = "bankcard")
public class Bankcard implements Serializable {
    private String bankcardid;
    private double balance;

    @Id
    public String getBankcardid() {
        return bankcardid;
    }

    public void setBankcardid(String bankcardid) {
        this.bankcardid = bankcardid;
    }

    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
