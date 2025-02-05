package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

final class FieldReaderBoolValueMethod<T> extends FieldReaderObjectMethod<T> {
    FieldReaderBoolValueMethod(String fieldName, Type fieldType, Method setter) {
        super(fieldName, fieldType, setter);
    }

    public void readFieldValue(JSONReader jsonReader, T object) {
        boolean fieldValue = jsonReader.readBoolValue();
        try {
            method.invoke(object, fieldValue);
        } catch (Exception e) {
            throw new JSONException("set " + fieldName + " error", e);
        }
    }

    public void accept(T object, Object value) {
        if (value == null) {
            value = false;
        }

        try {
            method.invoke(object, value);
        } catch (Exception e) {
            throw new JSONException("set " + fieldName + " error", e);
        }
    }

    public Object readFieldValue(JSONReader jsonReader) {
        return jsonReader.readBool();
    }
}
