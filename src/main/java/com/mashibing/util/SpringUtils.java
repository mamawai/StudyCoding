package com.mashibing.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @�����ˣ�Young
 * @ʱ �䣺 2019/3/13
 * @�� ��: �ֶ���ȡspring��bean
 */
@Component("springContextUtil")
public class SpringUtils implements ApplicationContextAware {


    private static ApplicationContext applicationContext = null;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanId) {
        return (T) applicationContext.getBean(beanId);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return (T) applicationContext.getBean(requiredType);
    }
    /**
     * Spring���������󣬻�� applicationContext ���Զ�ע�������Ȼ�����ǰ� applicationContext
     *  ��ֵ����̬�����У���������õ���������
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }
}