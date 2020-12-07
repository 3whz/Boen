package com.boen.service;

import com.boen.domain.Admin;
import com.boen.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {
    /**
     *添加管理员
     * @param admin
     * @return 自增id
     */
    public int AdminInsert(Admin admin);
    /**
     * 批量删除管理员  删除的时候记得放到集合里
     * @param adminList
     * @return row 受影响行数
     */
    public int AdminDelete(@Param("idList") List<Admin> adminList);
    /**
     *修改管理员
     * @param admin
     * @return row 受影响行数
     */
    public int AdminUpdate(Admin admin);
    /**
     * 查询管理员
     * @param admin
     * @return List<Admin>
     */
    public List<Admin> AdminSelect(Admin admin);


}
