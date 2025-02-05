package com.alibaba.fastjson2.v1issues.issue_1000;

import com.alibaba.fastjson2.JSON;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by wenshao on 17/03/2017.
 */
public class Issue1080 {
    @Test
    public void test_for_issue() throws Exception {
        java.util.Date date = JSON.parseObject("\"2017-3-17 00:00:01\"", java.util.Date.class);
        String json = JSON.toJSONString(date, "yyyy-MM-dd");
        assertEquals("\"2017-03-17\"", json);
    }

    @Test
    public void test_for_issue_2() throws Exception {
        java.util.Date date = JSON.parseObject("\"2017-3-7 00:00:01\"", java.util.Date.class);
        String json = JSON.toJSONString(date, "yyyy-MM-dd");
        assertEquals("\"2017-03-07\"", json);
    }
}
