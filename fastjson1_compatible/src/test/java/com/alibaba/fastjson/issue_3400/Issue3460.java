package com.alibaba.fastjson.issue_3400;

import com.alibaba.fastjson.JSONValidator;
import junit.framework.TestCase;

/**
 * Description:  <br>
 *
 * @author byw
 * @create 2020/9/20
 */
public class Issue3460 extends TestCase {

    public void test_for_issue() throws Exception {
        String body = "11{\"time\":" + System.currentTimeMillis() + "}";

        assertFalse(
                JSONValidator.from(body)
                        .validate());

        assertTrue(
                JSONValidator.from(body)
                        .setSupportMultiValue(true)
                        .validate());
    }

}