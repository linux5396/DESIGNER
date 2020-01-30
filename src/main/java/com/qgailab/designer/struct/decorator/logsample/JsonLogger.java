package com.qgailab.designer.struct.decorator.logsample;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author linxu
 * @date 2020/1/30
 * <tip>take care of yourself.everything is no in vain.</tip>
 */
public class JsonLogger extends LoggerDecorator {
    private static final String LOG_PREFIX = "Log Msg";
    private static final String EXCEPTION_PREFIX = "Log Ex";

    public JsonLogger(Logger logger) {
        super(logger);
    }

    /***************只实现以下方法的JSON格式化***************/
    @Override
    public void error(String msg) {
        JSONObject jsonObject = composeBasicJson();
        jsonObject.put(LOG_PREFIX, msg);
        super.logger.error(jsonObject.toString());
    }

    @Override
    public void debug(String msg) {
        JSONObject jsonObject = composeBasicJson();
        jsonObject.put(LOG_PREFIX, msg);
        super.logger.debug(jsonObject.toString());
    }

    @Override
    public void info(String msg) {
        JSONObject jsonObject = composeBasicJson();
        jsonObject.put(LOG_PREFIX, msg);
        super.logger.info(jsonObject.toString());
    }

    @Override
    public void error(String msg, Throwable t) {
        JSONObject jsonObject = composeBasicJson();
        jsonObject.put(LOG_PREFIX, msg);
        jsonObject.put(EXCEPTION_PREFIX, t.getMessage());
        super.logger.error(jsonObject.toString());
    }

    /**
     * @return 封装基础信息
     */
    private JSONObject composeBasicJson() {
        JSONObject jsonObject = new JSONObject();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jsonObject.put("DATE", dateFormat.format(new Date(System.currentTimeMillis())));
        //可以添加其它基础信息
        return jsonObject;
    }
}
