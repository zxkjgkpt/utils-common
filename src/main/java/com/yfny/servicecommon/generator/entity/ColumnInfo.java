package com.yfny.servicecommon.generator.entity;

import com.yfny.servicecommon.generator.utils.StringUtil;

import java.io.Serializable;

/**
 * 代码生成器数据表字段类
 * Created by jisongZhou on 2019/3/5.
 **/
public class ColumnInfo implements Serializable {
    private String columnName; // 列名
    private int type; // 类型代码
    private String propertyName; // 属性名
    private boolean isPrimaryKey; // 是否主键

    public ColumnInfo() {

    }

    public ColumnInfo(String columnName, int type, boolean isPrimaryKey) {
        this.columnName = columnName;
        this.type = type;
        this.propertyName = StringUtil.columnName2PropertyName(columnName);
        this.isPrimaryKey = isPrimaryKey;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }
}
