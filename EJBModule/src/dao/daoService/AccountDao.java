package dao.daoService;

import model.Account;

import javax.ejb.Remote;

/**
 * Created by ZhangYF on 2017/2/28.
 */
@Remote
public interface AccountDao {
    public void insert(Account account);
    public void update(Account account);
    public void deposit(String accountid, double money);
    public boolean consume(String accountid, double money);

}
