package com.boen.service.impl;

import com.boen.domain.Gym;
import com.boen.mapper.GymMapper;
import com.boen.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional    //事务
public class GymServiceImpl implements GymService {

    @Autowired
    private GymMapper gymMapper;

    @Override
    public int GymUpdate(Gym gym) {
        int row = gymMapper.GymUpdate(gym);
        return row;
    }
}
