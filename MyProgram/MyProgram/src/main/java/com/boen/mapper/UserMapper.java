package com.boen.mapper;

import com.boen.domain.GymClass;
import com.boen.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Controller;

import java.util.List;

@Mapper
@Controller
public interface UserMapper {


    /**
     * 添加用户
     *
     * @param user
     * @return 自增id
     */
    @Insert("insert into user (username,password,sex,email,img,coach,state) values (#{username},#{password},#{sex},#{email},'head2.jpg',0,1)")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int UserInsert(User user);


    /**
     * 批量删除  删除的时候记得放到集合里
     *
     * @param userList
     * @return row 受影响行数
     */
    @Delete({"<script>",
            "<foreach collection='idList' item='item'   index='index'   separator=';'>",
            " delete from user   where id = #{item.id}",
            "</foreach> ;",
            "</script>"})
    public int UserDelete(@Param("idList") List<User> userList);

    /**
     * 修改用户
     *
     * @param user
     * @return row 受影响行数
     */
    @Update({"<script> update user set" +
            "<if  test= 'username != null'> username = #{username}, </if>" +
            "<if  test= 'password != null'>  password=#{password}, </if>" +
            "<if  test= 'sex != null'> sex=#{sex}, </if>" +
            "<if  test= 'email != null'> email=#{email}, </if>" +
            "<if  test= 'img != null'> img=#{img}, </if>" +
            "<if  test= 'coach != null'> coach=#{coach}, </if>" +
            "<if  test= 'state != null'> state=#{state}, </if>" +
            "id =#{id} where id=#{id} </script>"})
    public int UserUpdate(User user);

    /**
     * 查询用户
     *
     * @param user
     * @return List<User>
     */
    @Select({"<script> SELECT * FROM user WHERE 1=1" +
            "<if  test= 'id != null'>  AND id = #{id} </if>" +
            "<if  test= 'username != null'> AND username = #{username} </if>" +
            "<if  test= 'password != null'>  AND password = #{password} </if>" +
            "<if  test= 'sex != null'>  AND sex = #{sex} </if>" +
            "<if  test= 'email != null'>  AND email = #{email} </if>" +
            "<if  test= 'img != null'>  AND img = #{img} </if>" +
            "<if  test= 'coach != null'>  AND coach = #{coach} </if>" +
            "<if  test= 'state != null'>  AND state = #{state} </if>" +
            "</script>"})
    public List<User> UserSelect(User user);


//联表
    //联表用户和对应的课程

    /**
     * @param user
     * @return List<User> 里面课程集合有值
     */
    @Select({"<script> SELECT * FROM user WHERE 1=1" +
            "<if  test= 'id != null'>  AND id = #{id} </if>" +
            "<if  test= 'username != null'> AND username = #{username} </if>" +
            "<if  test= 'password != null'>  AND password = #{password} </if>" +
            "<if  test= 'sex != null'>  AND sex = #{sex} </if>" +
            "<if  test= 'email != null'>  AND email = #{email} </if>" +
            "<if  test= 'img != null'>  AND img = #{img} </if>" +
            "<if  test= 'coach != null'>  AND coach = #{coach} </if>" +
            "<if  test= 'state != null'>  AND state = #{state} </if>" +
            "</script>"})
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "id", property = "gymClass",
                    many = @Many(
                            select = "com.boen.mapper.GymClassMapper.selectGymClassByuid",
                            fetchType = FetchType.LAZY
                    )
            )
    })
    public List<User> selectUserz(User user);
}
