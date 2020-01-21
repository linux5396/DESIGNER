package com.qgailab.designer.struct.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author linxu
 * @date 2020/1/21
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
@SuppressWarnings("unchecked")
public class CglibProxyService {
    private Object target;

    public CglibProxyService(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        //设置代理类
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("CGLIB前置增强");
            Object ret = methodProxy.invoke(target, objects);
            System.out.println("CGLIB后置增强");
            return ret;
        });
        return enhancer.create();
    }
}
