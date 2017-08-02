package com.solid4j.matrix.core;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * @author: solidwang
 * @since 1.0
 */
public interface ClassScanner {
    /**
     * 获取包下的Class列表
     * @param packageName
     * @return
     */
    List<Class<?>> getClassList(String packageName);

    /**
     * 获取指定父类的Class列表
     * @param packageName
     * @param superCls
     * @return
     */
    List<Class<?>> getClassListBySuper(String packageName, Class<?> superCls);

    /**
     * 获取指定注解的Class列表
     * @param packageName
     * @param annotation
     * @return
     */
    List<Class<?>> getClassListByAnnotation(String packageName, Class<? extends Annotation> annotation);
}
