package com.jay.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiang.wei on 2018/6/3
 * 自动注入的方式
 * @author xiang.wei
 */
@Controller
public class TestController2 {
    @Autowired
    private HttpServletRequest request;
    public static Set<String> set = new HashSet<>();

    @RequestMapping("/test2.do")
    public void test() throws InterruptedException{
//        判断线程安全
        String value = request.getParameter("key");
        if (set.contains(value)) {
            System.out.println(value + "\t重复出现，request不安全");
        } else {
            System.out.println(value);
            set.add(value);
        }

        //模拟程序执行了一段时间
        Thread.sleep(1000);
    }
}
