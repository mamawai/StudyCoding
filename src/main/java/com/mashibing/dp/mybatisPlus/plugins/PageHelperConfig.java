package com.mashibing.dp.mybatisPlus.plugins;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.github.pagehelper.PageInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import java.util.Properties;
@Slf4j
@Configuration
public class PageHelperConfig {

//    @Bean
//    PageInterceptor pageInterceptor(){
//        PageInterceptor pageInterceptor = new PageInterceptor();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum","false");
//        properties.setProperty("rowBoundsWithCount","false");
//        properties.setProperty("pageSizeZero","true");
//        properties.setProperty("reasonable","false");
//        properties.setProperty("supportMethodsArguments","false");
//        properties.setProperty("returnPageInfo","none");
//        properties.setProperty("autoRuntimeDialect","true");
//        pageInterceptor.setProperties(properties);
//        return pageInterceptor;
//    }
@Bean
public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
    return interceptor;
}

}
