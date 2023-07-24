package com.example.user.services.factory;

import com.example.user.services.domain.model.User;

import java.time.LocalDate;

public class FactoryUsersDataTest {

    public static User getUser() {
        User user = new User();
        user.setId(1L);
        user.setName("David");
        user.setLastName("Ballesteros");
        user.setCellPhone("+573238123367");
        user.setDocumentNumber("1006287478");
        user.setBirthDate(LocalDate.of(2005, 07, 18));
        user.setEmail("david@pragma.com");
        user.setPassword("password");
        //user.setRoleId(2L);
        return user;
    }
}
