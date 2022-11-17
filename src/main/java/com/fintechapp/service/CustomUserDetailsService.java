package com.fintechapp.service;


import com.fintechapp.model.entity.SignUpDetailsEntity;
import com.fintechapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        return  new User("hello","hello",new ArrayList<>());


        SignUpDetailsEntity userDetails = userRepository.findByUserName(username);

         if(userDetails != null){

            return  new User(userDetails.getUserName(),userDetails.getUserPassword(),new ArrayList<>());
        }
        else {
            throw  new UsernameNotFoundException("User Not Exists with the name"+username);
        }


    }
}
