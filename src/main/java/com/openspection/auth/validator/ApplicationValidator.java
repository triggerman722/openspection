package com.openspection.auth.validator;

import com.openspection.auth.model.Application;
import com.openspection.auth.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ApplicationValidator implements Validator {
    @Autowired
    private ApplicationService applicationService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Application.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Application application = (Application) o;

	/*
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty");
        if (post.getTitle().length() < 3 || post.getTitle().length() > 255) {
            errors.rejectValue("title", "Size.postForm.title");
        }
	*/
    }
}
