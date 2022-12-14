package com.itany.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.itany.client.ITestClient;
import com.itany.entity.User;
import com.itany.service.IWebTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/web")
public class WebTestController {

    @Autowired
    private ITestClient testClient;

    @Autowired
    private IWebTestService webTestService;



    @RequestMapping("/findUsers")
    public ModelAndView findUsers(@RequestParam(name = "page",defaultValue = "1") Integer page,
                                  @RequestParam(name = "rows",defaultValue = "10") Integer rows){
           PageInfo<User> info = testClient.findUsers(page,rows);
           Map<String,Object> map =new HashMap<String,Object>();
           map.put("pageInfo",info);
           ModelAndView mv = new ModelAndView("userlist",map);
           return mv;
    }



}
