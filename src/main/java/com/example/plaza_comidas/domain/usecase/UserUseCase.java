package com.example.plaza_comidas.domain.usecase;

import com.example.plaza_comidas.domain.api.IUserServicePort;
import com.example.plaza_comidas.domain.model.ERoles;
import com.example.plaza_comidas.domain.model.User;
import com.example.plaza_comidas.domain.spi.passwordencoder.IUserPasswordEncoderPort;
import com.example.plaza_comidas.domain.spi.persistence.IUserPersistencePort;
import com.example.plaza_comidas.domain.util.UtilDateTime;
import com.example.plaza_comidas.domain.util.UtilNumbers;
import com.example.plaza_comidas.infrastructure.exception.UserIsNotLegalAgeException;
import com.example.plaza_comidas.infrastructure.exception.UserNumberDocumentIncorrectException;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    private final IUserPasswordEncoderPort userPasswordEncoderPort;

    public UserUseCase(IUserPersistencePort userPersistencePort, IUserPasswordEncoderPort userPasswordEncoderPort) {
        this.userPersistencePort = userPersistencePort;
        this.userPasswordEncoderPort = userPasswordEncoderPort;
    }

    @Override
    public void saveUser(User user) {
        //Encrypt the key
        user.setPassword(userPasswordEncoderPort.encode(user.getPassword()));

        //A role is assigned by default if you don't have a role assigned
        if (user.getRoleId() == null) {
            user.setRoleId(ERoles.OWNER.getId());
        }

        saveValidations(user);

        userPersistencePort.saveUser(user);
    }

    private void saveValidations(User user) {
        //Validate that the document number only contains numbers
        if (!UtilNumbers.onlyNumbers(user.getDocumentNumber())) {
            throw new UserNumberDocumentIncorrectException();
        }

        //Validate that the user is of legal age
        int adult = 18;
        if (user.getBirthDate() == null || UtilDateTime.calculateAge(user.getBirthDate()) < adult) {
            throw new UserIsNotLegalAgeException();
        }
    }

}
