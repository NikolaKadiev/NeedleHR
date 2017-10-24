package com.tandoori.needle.service.impl;

import com.tandoori.needle.repository.UserAccountRepository;
import com.tandoori.needle.web.dto.UserDTO;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DefaultUserAccountServiceImplTest {

    @Autowired
    private DefaultUserAccountServiceImpl userAccountService;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @After
    public void cleanUp() {
        userAccountRepository.deleteAll();
    }

    @Test
    public void shouldThrowValidationExceptionWhenEmailIsNotInCorrectFormat() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("John");
        userDTO.setLastName("Doe");
        userDTO.setPassword("pass");
        userDTO.setMatchingPassword("pass");
        userDTO.setEmail("@john.doe.com");

        thrown.expect(ConstraintViolationException.class);
        thrown.expect(hasProperty("constraintViolations", hasSize(1)));

        userAccountService.registerAccount(userDTO);

    }

    @Test
    public void shouldThrowValidationExceptionWhenPasswordAndConfirmationPasswordAreNotEqual() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("John");
        userDTO.setLastName("Doe");
        userDTO.setPassword("pass");
        userDTO.setMatchingPassword("word");
        userDTO.setEmail("jd@bla.com");

        thrown.expect(ConstraintViolationException.class);
        thrown.expect(hasProperty("constraintViolations", hasSize(1)));

        userAccountService.registerAccount(userDTO);
    }

    @Test
    public void shouldThrowValidationExceptionWhenEmailAlreadyExists() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("John");
        userDTO.setLastName("Doe");
        userDTO.setPassword("pass");
        userDTO.setMatchingPassword("pass");
        userDTO.setEmail("jd@bla.com");

        thrown.expect(ConstraintViolationException.class);
        thrown.expect(hasProperty("constraintViolations", hasSize(1)));

        userAccountService.registerAccount(userDTO);
        userAccountService.registerAccount(userDTO);

    }


}