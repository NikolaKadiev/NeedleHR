package com.tandoori.needle.service.impl;

import com.tandoori.needle.repository.UserAccountRepository;
import com.tandoori.needle.service.DomainService;
import com.tandoori.needle.service.UserAccountService;
import com.tandoori.needle.service.mapper.UserAccountMapper;
import com.tandoori.needle.service.model.UserAccount;
import com.tandoori.needle.web.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

@DomainService
public class DefaultUserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccount registerAccount(UserDTO userDTO) {
        return userAccountRepository.save(UserAccountMapper.instance.fromUserDTO(userDTO));
    }
}
