package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.util.TypeUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

final class FieldReaderInt32ValueMethod<T> extends FieldReaderObjectMethod<T> {
    FieldReaderInt32ValueMethod(String fieldName, Type fieldType, Method setter) {
        super(fieldName, fieldType, setter);
    }

    public void readFieldValue(JSONReader jsonReader, T object) {
        int fieldInt = jsonReader.readInt32Value();
        try {
            method.invoke(object, fieldInt);
        } catch (Exception e) {
            throw new JSONException("set " + fieldName + " error", e);
        }
    }

    public void accept(T object, Object value) {
        if (value == null) {
            value = 0;
        }

        try {
            method.invoke(object
                    , TypeUtils.toIntValue(value));
        } catch (Exception e) {
            throw new JSONException("set " + fieldName + " error", e);
        }
    }

    public void accept(T object, long value) {
        try {
            method.invoke(object, (int) value);
        } catch (Exception e) {
            throw new JSONException("set " + fieldName + " error", e);
        }
    }

    public Object readFieldValue(JSONReader jsonReader) {
        return jsonReader.readInt32Value();
    }
}
