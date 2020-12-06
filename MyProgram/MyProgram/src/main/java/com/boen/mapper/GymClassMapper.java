package com.boen.mapper;

import com.boen.domain.Admin;
import com.boen.domain.GymClass;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Mapper
@Controller
public interface GymClassMapper {
    /**
     * 添加课程
     *
     * @param gymClass
     * @return 自增id
     */
    @Insert("insert into gymclass (name, text,img,difficulty,u_id,ci_id,state) values (#{name},#{text}, #{img},#{difficulty},#{u_id},#{ci_id},1)")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    public int GymClassInsert(GymClass gymClass);


    /**
     * 批量删除课程  删除的时候记得放到集合里
     *
     * @param gymClassList
     * @return row 受影响行数
     */
    @Delete({"<script>",
            "<foreach collection='idList' item='item'   index='index'   separator=';'>",
            " delete from gymclass where id = #{item.id}",
            "</foreach> ;",
            "</script>"})
    public int GymClassDelete(@Param("idList") List<GymClass> gymClassList);

    /**
     * 修改课程
     *
     * @param gymClass
     * @return row 受影响行数
     */
    @Update({"<script> update gymclass set" +
            "<if  test= 'name != null'> name = #{name}, </if>" +
            "<if  test= 'text != null'>  text=#{text}, </if>" +
            "<if  test= 'img != null'> img=#{img}, </if>" +
            "<if  test= 'difficulty != null'> difficulty=#{difficulty}, </if>" +
            "<if  test= 'u_id != null'> u_id=#{u_id}, </if>" +
            "<if  test= 'ci_id != null'> ci_id=#{ci_id}, </if>" +
            "<if  test= 'state != null'> state=#{state}, </if>" +
            "id =#{id} where id=#{id} </script>"})
    public int GymClassUpdate(GymClass gymClass);

    /**
     * 查询课程
     *
     * @param gymClass
     * @return List<GymClass>
     */
    @Select({"<script> SELECT * FROM gymclass WHERE 1=1" +
            //id看单个课程时用，点封面
            "<if  test= 'id != null'> AND id = #{id} </if>" +
            //名称        ！！！记得加模糊查询
            "<if  test= 'name != null'> AND name like CONCAT('%',#{name},'%')  </if>" +
            //试试直接用图片名找这个东西
            "<if  test= 'img != null'>  AND img=#{img} </if>" +
            //难度
            "<if  test= 'difficulty != null'> AND difficulty = #{difficulty} </if>" +
            //分类id
            "<if  test= 'ci_id != null'> AND ci_id = #{ci_id} </if>" +
            //根据上传者id
            "<if  test= 'u_id != null'> AND u_id = #{u_id} </if>" +
            //查询顶置
            "<if  test= 'top != null'> AND top = #{top} </if>" +
            "</script>"})
    public List<GymClass> GymClassSelect(GymClass gymClass);

//联表
    @Select("select * from gymClass where id in(select c_id from user_gymclass where u_id=#{u_id})")
    public List<GymClass> selectGymClassByuid(@Param("u_id")int id);




}
