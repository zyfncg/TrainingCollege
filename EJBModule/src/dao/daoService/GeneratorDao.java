package dao.daoService;

import model.GeneratorBean;

import javax.ejb.Remote;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Remote
public interface GeneratorDao {

    public GeneratorBean getGenerator();

    public void save(GeneratorBean generatorBean);
}
