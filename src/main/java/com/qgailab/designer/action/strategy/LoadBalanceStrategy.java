package com.qgailab.designer.action.strategy;

import java.net.URL;
import java.util.List;

/**
 * @author linxu
 * @date 2020/2/29
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public abstract class LoadBalanceStrategy {
    /**
     *
     * @param urls urls
     * @return index
     */
    abstract int loadBalance(List<URL> urls);
}
