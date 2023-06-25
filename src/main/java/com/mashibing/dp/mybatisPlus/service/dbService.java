package com.mashibing.dp.mybatisPlus.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.mashibing.dp.mybatisPlus.domain.PageReq;
import com.mashibing.dp.mybatisPlus.domain.Teacher;

import java.util.List;

public interface dbService extends IService<Teacher> {
    List<Teacher> queryTeachers(String name,String subject);

    boolean insertTeacherByIService(Teacher teacher);

    int updateByDao(String name,String email,Integer id);

    int insertTeacherBySelectKey(Teacher t);
    int insertTeacherByOptions(Teacher teacher);
    Teacher queryTeacherByChooseWhen(String name, Integer teacherid);

    List<Teacher> queryTeacherByLike(Integer[] ids,String[] names);
    List<com.mashibing.dp.mybatisPlus.entity.Teacher> findTeachersByJpaCriteriaAPI(Integer[] ids, String[] names);

    int updateTeacherBySet(Integer id,String name,String subject);

    List<Teacher> selectTeachersByConcatAndScript(String name);

    List<Teacher> selectTeachersByBindAndScript(Teacher teacher);

    PageInfo<Teacher> selectAllByPage(PageReq req);

    Page<Teacher> selectAllByNewPage(PageReq pageReq);

    List<Teacher> queryTeacherByQW1(String name);
    List<Teacher> queryTeacherbyQW2(String name);
    List<Teacher> queryTeacherbyQW3(String createTime);
    List<Teacher> queryTeacherbyQW4(String name);
    List<Teacher> queryTeacherbyQW5(String ids);
}
