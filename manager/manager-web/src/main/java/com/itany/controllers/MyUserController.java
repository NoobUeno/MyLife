package com.itany.controllers;

import com.github.pagehelper.PageInfo;
import com.itany.entity.User;
import com.itany.service.IMyUserService;
import com.itany.vo.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/myuser")
public class MyUserController {

    @Autowired
    IMyUserService service;

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> findAll(@RequestParam(defaultValue="1")Integer page,
                                      @RequestParam(defaultValue="10")Integer rows){

        Map<String,Object> map = new HashMap<String,Object>();
        PageInfo<User> info = service.findUserAll(page, rows);
        map.put("total", info.getTotal());
        map.put("rows", info.getList());
        return map;
    }

}
