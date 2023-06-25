package com.mashibing.dp.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mashibing.dp.mybatisPlus.domain.PageReq;
import com.mashibing.dp.mybatisPlus.domain.Teacher;
import com.mashibing.dp.mybatisPlus.service.dbService;
import com.mashibing.dp.mybatisPlus.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class dbServiceImpl extends ServiceImpl<dbDao,Teacher> implements dbService {
    @Autowired
    private dbDao dbDao;
    @Autowired
    private dbRepository dbRepository;
    @Override
    public List<Teacher> queryTeachers(String name, String subject) {
        return dbDao.queryTeachers(name, subject);
    }
    public boolean insertTeacherByIService(Teacher teacher){
        // return dbDao.insert(teacher);
        return save(teacher);
    }
    public int updateByDao(String name,String email,Integer id){
        return dbDao.update(name,email,id);
    }
    public int insertTeacherBySelectKey(Teacher t){
        return dbDao.insertTeacherBySelectKey(t);
    }

    @Override
    public int insertTeacherByOptions(Teacher teacher) {
        return dbDao.insertTeacherByOptions(teacher);
    }

    @Override
    public Teacher queryTeacherByChooseWhen(String name, Integer teacherid) {
        return dbDao.queryTeacherByChooseWhen(name,teacherid);
    }

    @Override
    public List<Teacher> queryTeacherByLike(Integer[] ids, String[] names) {
        return dbDao.queryTeacherByLike(ids,names);
    }

    @Override
    public List<com.mashibing.dp.mybatisPlus.entity.Teacher> findTeachersByJpaCriteriaAPI(Integer[] ids, String[] names){
        return dbRepository.findAll(new Specification<com.mashibing.dp.mybatisPlus.entity.Teacher>() {
            @Override
            public Predicate toPredicate(Root<com.mashibing.dp.mybatisPlus.entity.Teacher> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                Predicate conjunction = criteriaBuilder.conjunction();
                List<Integer> idList = Arrays.asList(ids);
                Predicate idPredicate = root.get("userId").in(idList);
                List<Predicate> namePredicates = new ArrayList<>();
                for (String name : names){
                    namePredicates.add(criteriaBuilder.like(root.get("teacherName"),"%"+name+"%"));
                }
                // list转数组
                Predicate[] array = namePredicates.toArray(new Predicate[0]);
                // 得到or
                Predicate or = criteriaBuilder.or(array);
                Predicate finalPredicate = criteriaBuilder.and(idPredicate, or);
//                conjunction.getExpressions().add(idPredicate);

//                conjunction.getExpressions().add(or);
                // Predicate finalPredicate = criteriaBuilder.and(idPredicate, or);
                return finalPredicate;
            }
        });
    }

    @Override
    public int updateTeacherBySet(Integer id, String name, String subject) {
        return dbDao.updateTeacherBySet(id,name,subject);
    }

    @Override
    public List<Teacher> selectTeachersByConcatAndScript(String name) {
        return dbDao.selectTeachersByConcatAndScript(name);
    }

    @Override
    public List<Teacher> selectTeachersByBindAndScript(Teacher teacher) {
        return dbDao.selectTeachersByBindAndScript(teacher);
    }

    @Override
    public PageInfo<Teacher> selectAllByPage(PageReq pageReq) {
        // 每页多少条记录
        int pageSize = pageReq.getPageInfo().getPageSize();
        // 当前页码
        int pageNum = pageReq.getPageInfo().getPageNum();
        PageHelper.startPage(pageNum,pageSize);

        List<Teacher> teachers = dbDao.selectAll();
        return new PageInfo<>(teachers);
    }

    @Override
    public Page<Teacher> selectAllByNewPage(PageReq pageReq){
        int size = pageReq.getPageInfo().getPageSize();
        int currentPage = pageReq.getPageInfo().getPageNum();
        Page<Teacher> page = new Page<>(currentPage, size);
//        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        return dbDao.selectPage(page,null);
    }
    /**
     * QueryWrapper示例练习
     *
     * @return List
     */
    @Override
    public List<Teacher> queryTeacherByQW1(String name){
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name),"teachername",name);
        queryWrapper.eq("subject","pe");
        queryWrapper.orderByDesc("create_time");
        List<Teacher> teachers = dbDao.selectList(queryWrapper);
        return teachers;
    }
    @Override
    public List<Teacher> queryTeacherbyQW2(String name){
        QueryWrapper<Teacher> qw = new QueryWrapper<>();
//        qw.likeRight("teachername",name);
//        qw.isNotNull("teacherid");
//        qw.orderByDesc("create_time");
        qw.between("id",5,8);
        List<Teacher> teachers = dbDao.selectList(qw);
        return teachers;
    }
    public List<Teacher> queryTeacherbyQW3(String createTime){

        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply(StringUtils.isNotBlank("create_time"),"DATE(create_time) = STR_TO_DATE('"+createTime+"','%Y-%m-%d')");
        queryWrapper.orderByDesc("create_time");
        return dbDao.selectList(queryWrapper);
    }
    public List<Teacher> queryTeacherbyQW4(String name){
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("teachername",name).and(teacherQueryWrapper -> {
            teacherQueryWrapper.isNotNull("subject").or().gt("teacherid",2332);
        });
        return dbDao.selectList(queryWrapper);
    }
    public List<Teacher> queryTeacherbyQW5(String ids){
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(ids)){
            String[] split = ids.split(",");
            List<String> list = Arrays.asList(split);
            queryWrapper.in(list.size()>0,"id",list);
        }
        queryWrapper.orderByDesc("create_time");
        return dbDao.selectList(queryWrapper);
    }
}
