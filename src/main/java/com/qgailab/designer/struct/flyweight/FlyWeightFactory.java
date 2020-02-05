package com.qgailab.designer.struct.flyweight;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author linxu
 * @date 2020/2/5
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class FlyWeightFactory {
    private static final Map<String, FlyWeightString> map = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static FlyWeightString getFlyWeight(String label, Class clazz, Object[] args) {
        FlyWeightString obj = map.get(label);
        if (obj == null) {
            System.out.println("享元不存在！");
            Class[] argsTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argsTypes[i] = args[i].getClass();
            }
            try {
                Constructor constructor = clazz.getConstructor(argsTypes);
                try {
                    System.out.println("创建享元:" + label);
                    obj = (FlyWeightString) constructor.newInstance(args);
                    map.put(label, obj);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                System.out.println("创建享元失败！");
            }
        }
        return obj;
    }
}
