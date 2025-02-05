package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

class FieldReaderAtomicIntegerMethodReadOnly<T> extends FieldReaderImpl<T> implements FieldReaderReadOnly<T> {
    final Method setter;

    FieldReaderAtomicIntegerMethodReadOnly(String fieldName, Class fieldType, int ordinal, Method setter) {
        super(fieldName, fieldType, fieldType, ordinal, 0, null);
        this.setter = setter;
    }

    public boolean isReadOnly() {
        return true;
    }

    public void accept(T object, Object value) {
        if (value == null) {
            return;
        }

        try {
            AtomicInteger atomic = (AtomicInteger) setter.invoke(object);
            atomic.set((Integer) value);
        } catch (Exception e) {
            throw new JSONException("set " + fieldName + " error", e);
        }
    }

    public void readFieldValue(JSONReader jsonReader, T object) {
        Integer value = jsonReader.readInt32();
        accept(object, value);
    }

    public String toString() {
        return setter.getName();
    }
}
