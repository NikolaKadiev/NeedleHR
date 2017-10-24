package com.tandoori.needle.service;

import com.tandoori.needle.service.model.UserAccount;
import com.tandoori.needle.web.dto.UserDTO;

import javax.validation.Valid;

public interface UserAccountService {
    UserAccount registerAccount(@Valid UserDTO userDTO);
}
