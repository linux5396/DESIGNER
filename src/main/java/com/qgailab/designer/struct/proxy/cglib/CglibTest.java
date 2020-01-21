package com.qgailab.designer.struct.proxy.cglib;

/**
 * @author linxu
 * @date 2020/1/21
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class CglibTest {
    public static void main(String[] args) {
        DefaultServiceWithouInterface serviceWithouInterface = new DefaultServiceWithouInterface();
        CglibProxyService proxyService = new CglibProxyService(serviceWithouInterface);
        DefaultServiceWithouInterface proxy = (DefaultServiceWithouInterface) proxyService.getProxy();
        proxy.doAction();
    }
}
