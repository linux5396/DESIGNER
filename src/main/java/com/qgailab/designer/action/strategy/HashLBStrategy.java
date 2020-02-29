package com.qgailab.designer.action.strategy;

import java.net.URL;
import java.util.List;

/**
 * @author linxu
 * @date 2020/2/29
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class HashLBStrategy extends LoadBalanceStrategy {
    int curIdx = 0;

    @Override
    int loadBalance(List<URL> urls) {
        if (curIdx < urls.size()) {
            curIdx++;
        } else {
            curIdx = 0;
        }
        return curIdx;
    }
}
