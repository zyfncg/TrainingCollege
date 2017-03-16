package security;

import factory.ServiceFactory;
import model.AuthorUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import service.AuthorizeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangYF on 2017/3/15.
 */
public class CustomUserDetailsService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        AuthorizeService authorizeService = ServiceFactory.getAuthorizeService();
        AuthorUser user = authorizeService.getUserByID(userid);
        if(user == null){
            throw new UsernameNotFoundException("not found");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new User(user.getUserid(),user.getPassword(),authorities);
    }
}
