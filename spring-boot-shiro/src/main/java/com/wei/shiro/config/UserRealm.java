package com.wei.shiro.config;

import com.wei.shiro.db.entity.UserEntity;
import com.wei.shiro.db.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //  权限验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("校验身份");
        String userName = (String) principalCollection.getPrimaryPrincipal();
        UserEntity user = userService.findByName(userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles= new HashSet<>();
        String roles1 = user.getRoles();
        if(roles1!=null){
            String[] _roles = roles1.split("\\s");
            for (String role : _roles) {
                roles.add(role);
            }
            simpleAuthorizationInfo.setRoles(roles);
        }
        return simpleAuthorizationInfo;
    }
    //身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("正在登录");
        String username = ((UsernamePasswordToken) authenticationToken).getUsername();
        String password =new String(((UsernamePasswordToken) authenticationToken).getPassword());
        UserEntity user = userService.findByName(username);
        if(user==null){
            throw new UnknownAccountException();
        }else if(!password.equals(user.getPassword())){
            throw  new IncorrectCredentialsException();
        }

        return new SimpleAuthenticationInfo(username,password,"myRealm");
    }
}
