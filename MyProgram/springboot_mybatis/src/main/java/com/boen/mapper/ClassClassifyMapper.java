package com.boen.mapper;

import com.boen.domain.ClassClassify;
import com.boen.domain.GymClass;
import com.boen.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Controller;

import java.util.List;
@Mapper
@Controller//controller控制器层（注入服务）
public interface ClassClassifyMapper {
    /**
     * 添加分类
     *
     * @param classClassify
     * @return 自增id
     */
    @Insert("insert into classclassify (name,state) values (#{name},1)")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int ClassClassifyInsert(ClassClassify classClassify);

    /**
     * 批量删除分类  删除的时候记得放到集合里
     *
     * @param classClassifyList
     * @return row 受影响行数
     */
    @Delete({"<script>",
            "<foreach collection='idList' item='item'   index='index'   separator=';'>",
            " delete from classclassify where id = #{item.id}",
            "</foreach> ;",
            "</script>"})
    public int ClassClassifyDelete(@Param("idList") List<ClassClassify> classClassifyList);

    /**
     * 修改分类
     *
     * @param classClassify
     * @return row 受影响行数
     */
    @Update({"<script> update classclassify set" +
            "<if  test= 'name != null'> name = #{name}, </if>" +
            "<if  test= 'state != null'> state=#{state}, </if>" +
            "id =#{id} where id=#{id} </script>"})
    public int ClassClassifyUpdate(ClassClassify classClassify);

    /**
     * 查询分类
     *
     * @param classClassify
     * @return List<ClassClassify>
     */
    @Select({"<script> SELECT * FROM classclassify WHERE 1=1" +
            "<if  test= 'id != null'> AND id = #{id} </if>" +
            "<if  test= 'name != null'> AND name = #{name} </if>" +
            "<if  test= 'state != null'> AND state = #{state} </if>" +
            "</script>"})
    public List<ClassClassify> ClassClassifySelect(ClassClassify classClassify);
//联表
    /**
     * 联表分类和对应的课程
     * @param classClassify
     * @return List<User> 里面课程集合有值
     */
    @Select({"<script> SELECT * FROM classclassify WHERE 1=1" +
            "<if  test= 'id != null'>  AND id = #{id} </if>" +
            "<if  test= 'name != null'> AND name = #{name} </if>" +
            "<if  test= 'state != null'>  AND state = #{state} </if>" +
            "</script>"})
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "id", property = "gymClass",
                    many = @Many(
                            select = "com.boen.mapper.GymClassMapper.GymClassByCiIdSelect",
                            fetchType = FetchType.LAZY
                    )
            )
    })
    public List<ClassClassify> ClassClassifyJointGymClassSelect(ClassClassify classClassify);

    @Select("select * from classclassify where id = #{id} ")
    public ClassClassify ClassClassifyByCiIdSelect(int id);
}
