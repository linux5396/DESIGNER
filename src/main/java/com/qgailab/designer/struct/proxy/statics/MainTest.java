package com.qgailab.designer.struct.proxy.statics;

/**
 * @author linxu
 * @date 2020/1/21
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class MainTest {
    public static void main(String[] args) {
        ServiceInterface serviceInterface = new DefaultServiceImpl();
        ProxyService proxyService = new ProxyService(serviceInterface);
        proxyService.doService();
    }
}
