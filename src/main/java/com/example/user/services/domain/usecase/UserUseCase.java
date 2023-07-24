package com.example.user.services.domain.usecase;

import com.example.user.services.domain.api.IUserServicePort;
import com.example.user.services.domain.model.ERoles;
import com.example.user.services.domain.model.User;
import com.example.user.services.domain.spi.passwordencoder.IUserPasswordEncoderPort;
import com.example.user.services.domain.spi.persistence.IUserPersistencePort;
import com.example.user.services.domain.util.UtilDateTime;
import com.example.user.services.domain.util.UtilNumbers;
import com.example.user.services.infrastructure.exception.UserIsNotLegalAgeException;
import com.example.user.services.infrastructure.exception.UserNumberDocumentIncorrectException;

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

    @Override
    public User getUserById(Long id) {
        return userPersistencePort.getUserById(id);
    }

}
