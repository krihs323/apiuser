package com.nisum.apiuser.service;

import com.nisum.apiuser.domain.PhoneDTO;
import com.nisum.apiuser.domain.UserDTO;
import com.nisum.apiuser.persistence.model.User;
import com.nisum.apiuser.persistence.repository.IPhone;
import com.nisum.apiuser.persistence.repository.IUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private IUser mockUser;

    @Mock
    private IPhone mockPhone;

    @InjectMocks
    UserService userService;

    private User user;
    private UserDTO userDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        user = new User();
        user.setId(1L);
        user.setName("cristian botina");
        user.setEmail("cristian_botina@hotmail.com");
        user.setPassword("123");

        userDto = new UserDTO();
        userDto.setName("cristian botina");
        userDto.setEmail("cristian_botina@hotmail.com");
        userDto.setPassword("123");

        List<PhoneDTO> phonesDto = new ArrayList<>();
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setNumber(3155828235L);
        phoneDTO.setCityCode(1);
        phoneDTO.setContryCode(57);
        phonesDto.add(phoneDTO);

        userDto.setPhones(phonesDto);

    }

    @Test
    void save() {
        when(mockUser.save(any(User.class))).thenReturn(user);
        assertNotNull(userService.save(userDto));
    }

    @Test
    void findByEmailNotNull() {
        when(mockUser.findByEmail("cristian_botina@hotmail.com")).thenReturn(Arrays.asList(user));
        assertNotNull(userService.findByEmail("cristian_botina@hotmail.com"));
    }
}