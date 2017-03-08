package dao.daoBean;

import dao.daoService.BankcardDao;
import model.Bankcard;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ZhangYF on 2017/2/28.
 */
@Stateless
public class BankcardDaoBean implements BankcardDao{
    @PersistenceContext
    protected EntityManager em;

    @Override
    public boolean isExist(String bankcardid) {
        if(bankcardid == null){
            return false;
        }
        Bankcard bankcard = em.find(Bankcard.class, bankcardid);
        if(bankcard != null){
            return true;
        }
        return false;
    }

    @Override
    public Bankcard find(String bankcardid) {
        Bankcard bankcard = em.find(Bankcard.class, bankcardid);
        return bankcard;
    }

    @Override
    public void update(Bankcard bankcard) {
        em.merge(bankcard);
    }

    @Override
    public boolean withdraw(String bankcardid, double money) {
        Bankcard bankcard = em.find(Bankcard.class, bankcardid);
        if(bankcard.getBalance() > money){
            bankcard.setBalance(bankcard.getBalance() - money);
            em.merge(bankcard);
            return true;
        }else {
            return false;
        }
    }
}
