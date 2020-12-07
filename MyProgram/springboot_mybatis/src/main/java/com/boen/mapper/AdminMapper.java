package com.boen.mapper;

import com.boen.domain.Admin;
import com.boen.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Mapper
@Controller//controller控制器层（注入服务）
public interface AdminMapper {
    /**
     * 添加管理员
     *
     * @param admin
     * @return 自增id
     */
    @Insert("insert into admin (account,password,email,jurisdiction,state) values (#{account},#{password},#{email},#{jurisdiction},1)")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int AdminInsert(Admin admin);

    /**
     * 批量删除  删除的时候记得放到集合里
     *
     * @param adminList
     * @return row 受影响行数
     */
    @Delete({"<script>",
            "<foreach collection='idList' item='item'   index='index'   separator=';'>",
            " delete from admin where id = #{item.id}",
            "</foreach> ;",
            "</script>"})
    public int AdminDelete(@Param("idList") List<Admin> adminList);

    /**
     * 修改管理员
     *
     * @param admin
     * @return row 受影响行数
     */
    @Update({"<script> update admin set" +
            "<if  test= 'account != null'> account = #{account}, </if>" +
            "<if  test= 'password != null'>  password=#{password}, </if>" +
            "<if  test= 'email != null'> email=#{email}, </if>" +
            "<if  test= 'jurisdiction != null'> jurisdiction=#{jurisdiction}, </if>" +
            "<if  test= 'state != null'> state=#{state}, </if>" +
            "id =#{id} where id=#{id} </script>"})
    public int AdminUpdate(Admin admin);

    /**
     * 查询管理员
     *
     * @param admin
     * @return List<Admin>
     */
    @Select({"<script> SELECT * FROM admin WHERE 1=1" +
            "<if  test= 'id != null'> AND id = #{id} </if>" +
            "<if  test= 'account != null'> AND account = #{account} </if>" +
            "<if  test= 'password != null'>  AND password=#{password} </if>" +
            "<if  test= 'email != null'> AND email = #{email} </if>" +
            "<if  test= 'jurisdiction != null'> AND jurisdiction = #{jurisdiction} </if>" +
            "<if  test= 'state != null'> AND state = #{state} </if>" +
            "</script>"})
    public List<Admin> AdminSelect(Admin admin);
}
