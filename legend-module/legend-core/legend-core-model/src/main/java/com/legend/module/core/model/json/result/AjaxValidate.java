package com.legend.module.core.model.json.result;


import com.legend.module.core.model.contant.message.exception.validate.ValidateExceptionMessage;
import lombok.Data;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/2/12
 */
@Data
public class AjaxValidate {

    private String field;

    private String defaultMessage;

    public static List<AjaxError> validate(Object object) {
        if (object == null) {
            throw new ValidationException(ValidateExceptionMessage.OBJECT_IS_NULL);
        }
        Set<ConstraintViolation<Object>> violationSet = (Set<ConstraintViolation<Object>>) object;
        List<AjaxError> ajaxErrors = new ArrayList<>();
        if (violationSet.isEmpty()) {
            return ajaxErrors;
        }
        violationSet.forEach(aViolationSet -> {
            ConstraintViolation constraintViolation = (ConstraintViolation) aViolationSet;
            ajaxErrors.add(new AjaxError(String.valueOf(constraintViolation.getPropertyPath()), constraintViolation.getMessage
                    (), null));
        });
        return ajaxErrors;
    }

    public static List<AjaxError> parseFieldError(List<FieldError> fieldErrors) {
        return fieldErrors.stream().map(error -> new AjaxError(error.getField(), error.getDefaultMessage
                ())).collect(Collectors.toList());
    }
}
