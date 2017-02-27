package dao.daoService;

import javax.ejb.Remote;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Remote
public interface InstitutionDao {

    public boolean checkPassword(String institutionid, String password);
}
