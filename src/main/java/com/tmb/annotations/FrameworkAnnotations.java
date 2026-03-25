package com.tmb.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.tmb.enums.TestCategory;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotations {

	public String[] authorName() default " ";

	public TestCategory[] testCategory() default {};

}
