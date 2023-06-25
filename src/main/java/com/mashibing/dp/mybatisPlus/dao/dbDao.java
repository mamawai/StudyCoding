package com.mashibing.dp.mybatisPlus.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mashibing.dp.mybatisPlus.domain.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
@Mapper
public interface dbDao extends BaseMapper<Teacher>{
    List<Teacher> queryTeachers(@Param("name") String name,@Param("subject") String subject);

    @Update("update teacher_info set teachername = #{name},email = #{email} where id = #{userId}")
    int update(@Param("name") String name,@Param("email") String email,@Param("id") Integer id);

    int insertTeacherBySelectKey(Teacher teacher);

    @Insert("insert into teacher_info (id,teachername) values (#{userId},#{teacherName})")
    //@Options(useGeneratedKeys = true,keyProperty = "userId",keyColumn = "id")
     @SelectKey(statement = "select last_insert_id()", keyProperty = "userId", before = false, resultType = Integer.class)
    int insertTeacherByOptions(Teacher teacher);

    Teacher queryTeacherByChooseWhen(@Param("name") String name,@Param("teacherid") Integer teacherid);

    List<Teacher> queryTeacherByLike (@Param("ids") Integer[] ids,@Param("names") String[] names);

    int updateTeacherBySet(@Param("id") Integer id,@Param("name") String name,@Param("subject") String subject);

    @Select({"<script>",
            "select * ",
            "from teacher_info t ",
            "<where> ",
            "<if test=\"null != name and name != ''\"> ",
            "t.teachername like concat('%' ,#{name},'%') ",
            "</if> ",
            "</where> ",
            "</script>"})
    List<Teacher> selectTeachersByConcatAndScript(@Param("name") String name);

    List<Teacher> selectTeachersByBindAndScript(@Param("aTeacher") Teacher teacher);

    // 分页查询
    @Select("select * from teacher_info")
    List<Teacher> selectAll();
}