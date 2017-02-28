package dao.daoBean;

import dao.daoService.BankcardDao;
import model.Bankcard;

import javax.ejb.Stateless;

/**
 * Created by ZhangYF on 2017/2/28.
 */
@Stateless
public class BankcardDaoBean implements BankcardDao{
    @Override
    public boolean isExist(String bankcardid) {
        return false;
    }

    @Override
    public Bankcard find(String bankcardid) {
        return null;
    }

    @Override
    public void update(Bankcard bankcard) {

    }

    @Override
    public boolean withdraw(String bankcardid, double money) {
        return false;
    }
}
