package com.boen.mapper;

import com.boen.domain.Gym;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;

@Mapper
@Controller
public interface GymMapper {
    @Update({"<script> update gym set" +
            "<if  test= 'maximum != null'> maximum = #{maximum}, </if>" +
            "id =1 where id=1 </script>"})
    public int GymUpdate(Gym gym);
}
