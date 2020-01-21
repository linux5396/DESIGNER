package com.qgailab.designer.struct.proxy.dynamic;

/**
 * @author linxu
 * @date 2020/1/21
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class MainTest {
    public static void main(String[] args) {
        ServiceInterface serviceInterface=new DefaultServiceImpl();
        DynamicProxyService dynamicProxyService=new DynamicProxyService(serviceInterface);
        ServiceInterface proxy=(ServiceInterface) dynamicProxyService.getProxyObject();
        proxy.doAnoService();
        //test
        System.out.println("被代理类"+serviceInterface.getClass());
        System.out.println("代理类"+proxy.getClass());
    }
}
