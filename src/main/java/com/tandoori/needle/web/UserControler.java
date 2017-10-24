package com.tandoori.needle.web;

import com.tandoori.needle.service.UserAccountService;
import com.tandoori.needle.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/user")
public class UserControler {

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public UserDTO registerUser(@RequestBody UserDTO userDTO){
        userAccountService.registerAccount(userDTO);
        return null;
    }
}
