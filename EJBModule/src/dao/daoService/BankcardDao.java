package dao.daoService;

import model.Bankcard;

import javax.ejb.Remote;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Remote
public interface BankcardDao {

    public boolean isExist(String bankcardid);
    public Bankcard find(String bankcardid);
    public void update(Bankcard bankcard);
    public boolean withdraw(String bankcardid, double money);

}
