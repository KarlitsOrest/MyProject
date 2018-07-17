package logos.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import logos.service.ItemsMakerService;

public class IfExistMaker implements ConstraintValidator<IfExistItemsMaker, String> {

	@Autowired ItemsMakerService itemsMakerService;
	@Override
	public void initialize(IfExistItemsMaker arg0) {
		
		
	}

	@Override
	public boolean isValid(String title, ConstraintValidatorContext context) {
		if (itemsMakerService.findAll()!=null) {
			return false;
		}
		else {
		return true;
		}
	}

}

