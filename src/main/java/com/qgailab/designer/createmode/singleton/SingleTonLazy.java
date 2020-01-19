package com.qgailab.designer.createmode.singleton;

/**
 * @author linxu
 * @date 2020/1/19
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class SingleTonLazy {
    public static SingleTonLazy getInstance() {
        return InstHolder.SINGLE_TON_LAZY;
    }

    private static class InstHolder {
        private static final SingleTonLazy SINGLE_TON_LAZY = new SingleTonLazy();
    }
}
