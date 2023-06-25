package com.mashibing.dp.prototype.v5;

/**
 * 类名 CloneTest
 * 描述 克隆测试类
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 浅克隆证明
        AccountDetail detail = new AccountDetail(1L, "1234567890@gmail.com");
        Account account = new Account(1L, "Jack", detail);
        // 克隆
        Account clone = (Account) account.clone();
        // 判断详情对对象是否相同，预期值(true)
        AccountDetail detail1 = account.getDetail();
        detail1.setEmail("dsadsa");
        account.setDetail(detail1);
        System.out.println(clone.getDetail() == account.getDetail());
        System.out.println(account);
        System.out.println("======================");
        System.out.println(clone);
    }
}
