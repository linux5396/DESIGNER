package com.qgailab.designer.struct.decorator.logsample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author linxu
 * @date 2020/1/30
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class JsonLoggerFactory {
    @SuppressWarnings("rawtypes")
    public static JsonLogger getLogger(Class clazz) {
        Logger logger = LoggerFactory.getLogger(clazz);
        return new JsonLogger(logger);
    }
}
