package com.alibaba.fastjson2.v1issues.issue_1400;

import com.alibaba.fastjson2.JSON;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class Issue1443 {
    @Test
    public void test_for_issue() throws Exception {
        String json = "{\"date\":\"3017-08-28T00:00:00+08:00\"}";
        Model model = JSON.parseObject(json, Model.class);

    }

    public static class Model {
        public Date date;
    }
}
