package dao.daoService;

import model.Institution;

import javax.ejb.Remote;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Remote
public interface InstitutionDao {

    public boolean checkPassword(String institutionid, String password);

    public void insert(Institution institution);

    public Institution find(String institutionid);

    public void update(Institution institution);
}
