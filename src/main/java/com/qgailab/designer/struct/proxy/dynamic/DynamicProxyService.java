package com.qgailab.designer.struct.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author linxu
 * @date 2020/1/21
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
@SuppressWarnings("unchecked")
public class DynamicProxyService implements InvocationHandler {
    private Object target;

    public DynamicProxyService(Object target) {
        this.target = target;
    }

    public Object getProxyObject() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //do before
        System.out.println("前置增强");
        Object retObj = method.invoke(target, args);
        System.out.println("后置增强");
        return retObj;
    }
}
