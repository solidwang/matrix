package com.solid4j.matrix.aop.annotation;

import java.lang.annotation.*;

/**
 * @author: solidwang
 * @since 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    Class<? extends Annotation> annotation();
}
