package com.example.mapper;

import com.example.entities.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper //指定这是一个操作数据库的mapper
public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);
    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(Integer id);
}
