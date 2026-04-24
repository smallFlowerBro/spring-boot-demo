/**
 * 海到尽头天作岸 山登绝顶我为峰
 *
 * @Author Administrator
 * @CreateTime 2026-03-20 11:01
 * @Description
 **/
package com.wei.demo.service;

import com.wei.demo.entity.UserEntity;
import com.wei.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("xxxxxxxxxxxxxxx");
        UserEntity user = userRepository.findByUsername(username);
        if(user==null){
            throw  new UsernameNotFoundException("User not fund:"+username);
        }
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getRole());

        Collection<? extends GrantedAuthority> authorityList = Collections.singletonList(simpleGrantedAuthority);

        return new User(user.getUsername(),user.getPassword(),authorityList);

    }
}
