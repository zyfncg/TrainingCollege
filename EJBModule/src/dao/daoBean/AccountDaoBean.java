package dao.daoBean;

import dao.daoService.AccountDao;
import model.Account;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ZhangYF on 2017/2/28.
 */
@Stateless
public class AccountDaoBean implements AccountDao{
    @PersistenceContext
    protected EntityManager em;
    @Override
    public void insert(Account account) {
        em.persist(account);
    }

    @Override
    public void update(Account account) {
        em.merge(account);
    }

    @Override
    public void deposit(String accountid, double money) {
        Account account = em.find(Account.class, accountid);
        account.setMoney(account.getMoney() + money);
        em.merge(account);
    }

    @Override
    public boolean consume(String accountid, double money) {
        Account account = em.find(Account.class, accountid);
        if(account.getMoney() > money){
            account.setMoney(account.getMoney() - money);
            em.merge(account);
            return true;
        }else{
            return false;
        }

    }
}
