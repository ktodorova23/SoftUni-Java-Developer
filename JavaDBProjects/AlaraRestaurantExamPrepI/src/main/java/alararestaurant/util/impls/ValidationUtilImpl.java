package alararestaurant.util.impls;

import alararestaurant.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class ValidationUtilImpl implements ValidationUtil {

    private final Validator validator;

    @Autowired
    public ValidationUtilImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public <E> boolean isValid(E entity) {
        return validator.validate(entity).size() == 0;
    }

    @Override
    public <E> Set<ConstraintViolation<E>> validate(E entity) {
        return validator.validate(entity);
    }
}
