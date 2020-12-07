package com.boen.controller;

import com.boen.domain.Gym;
import com.boen.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin   //跨域
public class GymController {

    @Autowired
    private GymService gymService;
    //gym 只有一个
    //更新gym信息 最大容量
    @RequestMapping("/GymUpdate")
    @ResponseBody
    public int GymUpdate(Gym gym) {
        int row = gymService.GymUpdate(gym);
        return row;
    }

}
