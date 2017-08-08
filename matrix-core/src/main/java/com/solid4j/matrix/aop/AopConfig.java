/*
 * Copyright (c) 2017 Sohu. All Rights Reserved
 */
package com.solid4j.matrix.aop;

import com.solid4j.matrix.aop.annotation.Aspect;
import com.solid4j.matrix.aop.proxy.Proxy;
import com.solid4j.matrix.aop.proxy.ProxyManager;
import com.solid4j.matrix.config.BeanConfig;
import com.solid4j.matrix.config.ClassConfig;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @author: solidwang
 * @since 1.0
 */
public class AopConfig {

    static {
        try {
            // 创建 Proxy Map（代理类=>目标类列表）
            Map<Class<?>, List<Class<?>>> proxyMap = createProxyMap();
            // 创建 Target Map（目标类=>代理类列表）
            Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);
            for (Map.Entry<Class<?>, List<Proxy>> targetEntry : targetMap.entrySet()) {
                Class<?> targetClass = targetEntry.getKey();
                List<Proxy> proxyList = targetEntry.getValue();
                // 创建代理实例
                Object proxyInstance = ProxyManager.createProxy(targetClass, proxyList);
                // 用代理实例覆盖目标实例，并放入 Bean 容器中
                BeanConfig.setBean(targetClass, proxyInstance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<Class<?>, List<Class<?>>> createProxyMap() throws Exception {
        Map<Class<?>, List<Class<?>>> proxyMap = new LinkedHashMap<Class<?>, List<Class<?>>>();
        // 添加切面代理
        addAspectProxy(proxyMap);
        return proxyMap;
    }

    private static void addAspectProxy(Map<Class<?>, List<Class<?>>> proxyMap) throws Exception {
        // 获取切面类
        List<Class<?>> aspectProxyClassList = ClassConfig.getClassListBySuper(AspectProxy.class);
        for (Class<?> aspectProxyClass : aspectProxyClassList) {
            if (aspectProxyClass.isAnnotationPresent(Aspect.class)) {
                Aspect aspect = aspectProxyClass.getAnnotation(Aspect.class);
                List<Class<?>> targetClassList = createTargetClassList(aspect);
                proxyMap.put(aspectProxyClass, targetClassList);
            }
        }
    }

    private static List<Class<?>> createTargetClassList(Aspect aspect) throws Exception {
        List<Class<?>> targetClassList = new ArrayList<Class<?>>();
        Class<? extends Annotation> annotation = aspect.annotation();
        if (annotation != null && !annotation.equals(Aspect.class)) {
            targetClassList.addAll(ClassConfig.getClassListByAnnotation(annotation));
        }
        return targetClassList;
    }

    private static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, List<Class<?>>> proxyMap) throws Exception {
        Map<Class<?>, List<Proxy>> targetMap = new HashMap<Class<?>, List<Proxy>>();
        for (Map.Entry<Class<?>, List<Class<?>>> proxyEntry : proxyMap.entrySet()) {
            Class<?> proxyClass = proxyEntry.getKey();
            List<Class<?>> targetClassList = proxyEntry.getValue();
            for (Class<?> targetClass : targetClassList) {
                Proxy baseAspect = (Proxy) proxyClass.newInstance();
                if (targetMap.containsKey(targetClass)) {
                    targetMap.get(targetClass).add(baseAspect);
                } else {
                    List<Proxy> baseAspectList = new ArrayList<Proxy>();
                    baseAspectList.add(baseAspect);
                    targetMap.put(targetClass, baseAspectList);
                }
            }
        }
        return targetMap;
    }

}