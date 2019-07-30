package com.softuni.demo.utils;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidatorUtil {
    <E> boolean isValid (E entity);

    <E> Set<ConstraintViolation<E>> validate (E entity);
}
