package com.solid4j.matrix.aop.proxy;

/**
 * @author: solidwang
 * @since 1.0
 */
public interface Proxy {

    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
