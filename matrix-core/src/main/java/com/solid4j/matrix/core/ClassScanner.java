package com.solid4j.matrix.core;

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
     * 获取指定父类的子类列表
     * @param packageName
     * @param superCls
     * @return
     */
    List<Class<?>> getClassListBySuper(String packageName, Class<?> superCls);
}
