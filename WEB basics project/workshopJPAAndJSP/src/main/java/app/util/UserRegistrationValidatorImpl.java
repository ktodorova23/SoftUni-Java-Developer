package app.util;

import app.domain.entities.User;
import app.domain.models.UserServiceModel;
import app.util.base.UserRegistrationValidator;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationValidatorImpl implements UserRegistrationValidator {

    private final EntityManager entityManager;

    @Inject
    UserRegistrationValidatorImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean validData(UserServiceModel userModel) {
        if (!enteredPasswordsAreMatching(userModel.getPassword(), userModel.getConfirmPassword())) {
            return false;
        }

        if (!emailIsCorrect(userModel.getEmail())) {
            return false;
        }

        if (!usernameIsUnique(userModel.getUsername())) {
            return false;
        }

        return true;
    }

    private boolean usernameIsUnique(String username) {
        if(this.entityManager
                .createQuery("select u from User u where u.username =: username", User.class)
                .setParameter("username", username)
                .getResultList().isEmpty()
                ||
                this.entityManager
                        .createQuery("select u from User u", User.class)
                .getResultList().isEmpty()) {
            return true;
        }

        return false;
    }

    private boolean emailIsCorrect(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    private boolean enteredPasswordsAreMatching(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
}
