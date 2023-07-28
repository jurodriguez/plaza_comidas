package com.example.user.services.factory;

import com.example.user.services.domain.model.ERoles;
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

    public static User getEmployeeUser() {
        User user = new User();
        user.setId(2L);
        user.setName("Luisa");
        user.setLastName("gonzalez");
        user.setCellPhone("+57311457891");
        user.setDocumentNumber("654321");
        //user.setBirthDate(LocalDate.of(2005, 07, 18));
        user.setEmail("luisa@gmail.com");
        user.setPassword("password");
        user.setRoleId(ERoles.EMPLOYEE.getId());
        return user;
    }

    public static User getCustomerUser() {
        User user = new User();
        user.setId(3L);
        user.setName("catalina");
        user.setLastName("gonzalez");
        user.setCellPhone("+573179874561");
        user.setDocumentNumber("6214531");
        user.setEmail("luisa@gmail.com");
        user.setPassword("password");
        user.setRoleId(ERoles.CUSTOMER.getId());
        return user;
    }
}
