package com.qgailab.designer.struct.bridge;

/**
 * @author linxu
 * @date 2020/1/29
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public abstract class AbstractCaller {
    protected Service service;

    public AbstractCaller(Service service) {
        this.service = service;
    }

    protected abstract void doAction();
}
