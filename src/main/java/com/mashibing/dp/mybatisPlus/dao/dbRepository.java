package com.mashibing.dp.mybatisPlus.dao;

import com.mashibing.dp.mybatisPlus.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface dbRepository extends JpaRepository<com.mashibing.dp.mybatisPlus.entity.Teacher,Integer>, JpaSpecificationExecutor<Teacher> {
}
