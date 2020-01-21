package com.qgailab.designer.struct.proxy.statics;

/**
 * @author linxu
 * @date 2020/1/21
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class ProxyService implements ServiceInterface {
    private ServiceInterface serviceInterface;

    public ProxyService(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    @Override
    public void doService() {
        //do before
        System.out.println("静态代理前置增强");
        serviceInterface.doService();
        //do after
        System.out.println("静态代理后置增强");
    }
}
