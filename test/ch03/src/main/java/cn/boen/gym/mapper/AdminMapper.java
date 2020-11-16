package cn.boen.gym.mapper;

import cn.boen.gym.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;



public interface AdminMapper {
   //登录方法
   @Select("select * from admin where account = #{account} and password= #{password}")
   public Admin loginAdmin(Admin admin);

}
