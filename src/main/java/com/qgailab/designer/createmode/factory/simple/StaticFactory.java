package com.qgailab.designer.createmode.factory.simple;

/**
 * @author linxu
 * @date 2020/1/20
 * <tip>take care of yourself.everything is no in vain.</tip>
 * 简单静态工厂
 */
public class StaticFactory {
    /**
     * @param level VIP level
     * @return 根据用户的LEVEL生成不同折扣策略
     */
    public static Strategy getStrategy(int level) {
        if (level == Level.NORMAL.val) {
            return new NormalStrategy(0.8);
        } else if (level == Level.SUPER.val) {
            return new SuperStrategy(0.6);
        } else {
            return null;
        }
    }

    enum Level {
        NORMAL(1), SUPER(2);
        int val;

        Level(int val) {
            this.val = val;
        }
    }
}
