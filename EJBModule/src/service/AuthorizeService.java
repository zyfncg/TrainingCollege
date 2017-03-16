package service;

import model.AuthorUser;

import javax.ejb.Remote;

/**
 * Created by ZhangYF on 2017/3/15.
 */
@Remote
public interface AuthorizeService {
    public AuthorUser getUserByID(String userid);
}
