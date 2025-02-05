package com.alibaba.fastjson.basicType;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;

/**
 * Created by wenshao on 10/08/2017.
 */
public class IntNullTest_primitive extends TestCase {
    public void test_null() throws Exception {
        Model model = JSON.parseObject("{\"v1\":null,\"v2\":null}", Model.class);
        assertNotNull(model);
        assertEquals(0, model.v1);
        assertEquals(0,model.v2);
    }

    public void test_null_1() throws Exception {
        Model model = JSON.parseObject("{\"v1\":null ,\"v2\":null }", Model.class);
        assertNotNull(model);
        assertEquals(0,model.v1);
        assertEquals(0,model.v2);
    }

    public void test_null_2() throws Exception {
        Model model = JSON.parseObject("{\"v1\":\"null\",\"v2\":\"null\" }", Model.class);
        assertNotNull(model);
        assertEquals(0,model.v1);
        assertEquals(0,model.v2);
    }

    public static class Model {
        public int v1;
        public int v2;
    }
}
