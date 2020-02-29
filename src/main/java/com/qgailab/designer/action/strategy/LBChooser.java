package com.qgailab.designer.action.strategy;

import java.net.URL;
import java.util.List;

/**
 * @author linxu
 * @date 2020/2/29
 * <tip>take care of yourself.everything is no in vain.</tip>
 * lb chooser
 */
public class LBChooser {
    /**
     * 这个地方，如果加上反射修改该strategy,那么，策略就是可以灵活变动的
     */
    private LoadBalanceStrategy strategy;

    public LBChooser(LoadBalanceStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 负载均衡选择器
     *
     * @param urls
     * @return
     */
    public URL choose(List<URL> urls) {
        return urls.get(strategy.loadBalance(urls));
    }
}
