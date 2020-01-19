package com.qgailab.designer.createmode.singleton;

/**
 * @author linxu
 * @date 2020/1/19
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class SingleTonSyn {
    private static SingleTonSyn inst;
    //used by double lock
    private static volatile SingleTonSyn inst1;

    private SingleTonSyn() {
    }

    /**
     * 方法锁
     */
    public synchronized static SingleTonSyn getInstance() {
        if (inst == null) {
            inst = new SingleTonSyn();
        }
        return inst;
    }

    /**
     * 双重锁加
     */
    public static SingleTonSyn getInstanceByDoubleLock() {
        if (inst1 == null) {
            synchronized (SingleTonSyn.class) {
                if (inst1 == null) {
                    inst1 = new SingleTonSyn();
                }
            }
        }
        return inst1;
    }
}
