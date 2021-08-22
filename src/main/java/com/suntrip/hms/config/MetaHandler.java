package com.suntrip.hms.config;

/**
 * @Author lizh
 * @create 2021-8-17 21:20
 */

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Date;

@Configuration
public class MetaHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //LocalDateTime now = LocalDateTime.now();
        Date now = new Date();
        // Date now = new Date();
        if (this.getFieldValByName("createdAt", metaObject) == null) {
            strictInsertFill(metaObject, "createdAt", Date.class, now);
        }
        if (this.getFieldValByName("updatedAt", metaObject) == null) {
            this.setFieldValByName("updatedAt", now, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date now = new Date();
        if (this.getFieldValByName("updatedAt", metaObject) == null) {
            this.setFieldValByName("updatedAt", now, metaObject);
        }
    }
}
