package org.bdigital.ocd.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

public class CustomValidator {
	public static boolean validateOneFieldRequired(
			Object bean, ValidatorAction action,
	        Field field, ActionMessages errors, Validator validator,
	            HttpServletRequest request) {

		    String value = ValidatorUtils.getValueAsString(
		        bean, 
		        field.getProperty());
		    String sProperty2 = field.getVarValue("secondProperty");
		    String value2 = ValidatorUtils.getValueAsString(
		        bean, 
		        sProperty2);
		    String sProperty3 = field.getVarValue("thirdProperty");
		    String value3 = ValidatorUtils.getValueAsString(
		        bean, 
		        sProperty3);

		    if (GenericValidator.isBlankOrNull(value) &&
		    		GenericValidator.isBlankOrNull(value2) &&
		    		GenericValidator.isBlankOrNull(value3)) {
		    	errors.add(field.getKey(),
	            		 Resources.getActionMessage(validator, request, action, field));

	            return false;
		    }

		    return true;
		}

}
