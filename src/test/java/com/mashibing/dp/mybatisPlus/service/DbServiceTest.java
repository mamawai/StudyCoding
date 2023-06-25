package com.mashibing.dp.mybatisPlus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.mashibing.dp.mybatisPlus.domain.PageReq;
import com.mashibing.dp.mybatisPlus.domain.Teacher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DbServiceTest {

    @Autowired
    dbService dbService;
    @Test
    public void test(){
        List<Teacher> teachers = dbService.queryTeachers("", "football");
        System.out.println(teachers);
//        boolean b = dbService.insertTeacherByIService(new Teacher(5, "jack", 10026, "dsa", "22222", "science"));
//        System.out.println(b);
//        int i = dbService.updateByDao("zzz", "xxx", 1);
//        System.out.println(i);
            Teacher teacher = new Teacher();
            teacher.setTeacherName("jack");
    //        int i = dbService.insertTeacherBySelectKey(teacher);
    //        System.out.println(i);
        /*int i = dbService.insertTeacherByOptions(teacher);
        Integer userId = teacher.getUserId();
        System.out.println(userId);*/
        Teacher teacher1 = dbService.queryTeacherByChooseWhen("", null);
        System.out.println(teacher1);
        // dbService.insertTeacher(new Teacher(4,"jack",10026,"dsa","22222","science"));

        Integer[] ids = new Integer[]{4,5,6,7,8};
        String[] names = new String[]{"j","a"};
        List<Teacher> teachers1 = dbService.queryTeacherByLike(ids, names);
        System.out.println(teachers1);

        List<com.mashibing.dp.mybatisPlus.entity.Teacher> teachersByJpaCriteriaAPI = dbService.findTeachersByJpaCriteriaAPI(ids, names);
        System.out.println(teachersByJpaCriteriaAPI);
        System.out.println(teachersByJpaCriteriaAPI.size());


    }
    @Test
    public void test2(){
//        int i = dbService.updateTeacherBySet(1, "hahaha", "physics");
//        System.out.println(i);

        /*Pattern p = Pattern.compile("[^0-9]");
        Matcher matcher = p.matcher(" 3 i ss 4n4p4u2t1 ");
        while (matcher.find()){
        String group = matcher.group();
        System.out.println(group);}
        int parsed = Integer.parseInt(matcher.replaceAll("").trim());
        System.out.println(parsed);*/
        List<Teacher> teachers = dbService.selectTeachersByConcatAndScript("j");
        System.out.println(teachers);
        Teacher teacher = new Teacher();
        teacher.setTeacherName("a");
        List<Teacher> teachers1 = dbService.selectTeachersByBindAndScript(teacher);
        System.out.println(teachers1);
    }

    @Test
    public void testPage(){
/*        PageReq req = new PageReq();
        PageInfo<Teacher> pageInfo = new PageInfo<>();
        pageInfo.setPageSize(5);
        pageInfo.setPageNum(1);
        req.setPageInfo(pageInfo);
        PageInfo<Teacher> teacherPageInfo = dbService.selectAllByPage(req);
        System.out.println("-----");
        int size = teacherPageInfo.getList().size();
        for (int i = 0;i<size;i++){
            Teacher teacher = teacherPageInfo.getList().get(i);
            System.out.println(teacher);
        }
        int pageNum = teacherPageInfo.getPageNum();
        System.out.println(pageNum);
        int pageSize = teacherPageInfo.getPageSize();
        System.out.println(pageSize);
        int pages = teacherPageInfo.getPages();
        System.out.println(pages);
        long total = teacherPageInfo.getTotal();
        System.out.println(total);
        System.out.println(teacherPageInfo);*/
                PageReq req = new PageReq();
        PageInfo<Teacher> pageInfo = new PageInfo<>();
        pageInfo.setPageSize(5);
        pageInfo.setPageNum(1);
        req.setPageInfo(pageInfo);
        Page<Teacher> teacherIPage = dbService.selectAllByNewPage(req);

        teacherIPage.getRecords().forEach(System.out::println);

        System.out.println(teacherIPage.getTotal());
    }
    @Test
    public void testQW(){
/*        List<Teacher> teachers = dbService.queryTeacherByQW1("to");
        System.out.println(teachers);*/

        /*List<Teacher> teachers1 = dbService.queryTeacherbyQW2("to");
        System.out.println(teachers1);*/

        /*List<Teacher> teachers = dbService.queryTeacherbyQW3("2023-06-22");
        System.out.println(teachers);*/

        List<Teacher> teachers1 = dbService.queryTeacherbyQW4("t");
        System.out.println(teachers1);

/*        Pattern pattern = Pattern.compile("[^A-Za-z0-9%&+,.:=_]");
        Matcher matcher = pattern.matcher("nam%e.txt");
        if (matcher.find()){
            System.out.println("找到了异常");
        }else {
            System.out.println("没有异常");
        }*/
        List<Teacher> teachers = dbService.queryTeacherbyQW5("16,17,18,19");
        System.out.println(teachers);
    }
}