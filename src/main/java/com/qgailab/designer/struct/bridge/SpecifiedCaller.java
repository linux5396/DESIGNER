package com.qgailab.designer.struct.bridge;

/**
 * @author linxu
 * @date 2020/1/29
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class SpecifiedCaller extends AbstractCaller {
    public SpecifiedCaller(Service service) {
        super(service);
    }

    @Override
    protected void doAction() {
        service.action();
    }
}
