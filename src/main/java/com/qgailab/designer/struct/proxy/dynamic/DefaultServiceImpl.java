package com.qgailab.designer.struct.proxy.dynamic;

import com.qgailab.designer.struct.proxy.dynamic.ServiceInterface;

/**
 * @author linxu
 * @date 2020/1/21
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class DefaultServiceImpl implements ServiceInterface {
    @Override
    public void doService() {
        System.out.println("this is default service.");
    }

    @Override
    public void doAnoService() {
        System.out.println("this is ano service.");
    }
}
