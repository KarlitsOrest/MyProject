//package logos.validator;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//
//@Target(value = {ElementType.FIELD, ElementType.METHOD})
//@Retention(value = RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = UniqueEmailClass.class)
//public @interface UniqueEmail {
//
//	String message() default "This email is already exists";
//	Class<?>[] groups() default{};
//	Class<? extends Payload>[] payload() default {};
//}
