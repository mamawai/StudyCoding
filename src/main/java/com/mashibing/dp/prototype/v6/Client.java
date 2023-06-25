package com.mashibing.dp.prototype.v6;


public class Client {
    public static void main(String[] args) {
        System.out.println("序列化之前：");
        Address address = new Address("中国", "吉林", "长春");// 创建address对象
        Employee employee1 = new Employee("小虚竹", 30, address);// 创建employee1对象
        System.out.println("员工1的信息：");
        System.out.println(employee1);// 输出employee1对象
        System.out.println("序列化之后：");

        Employee employee2 = null;
        try {
            employee2 = employee1.deepClone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(employee2 == employee1);

        if (employee2 != null) {
            employee2.getAddress().setState("中国"); // 修改员工地址
            employee2.getAddress().setProvince("四川"); // 修改员工地址
            employee2.getAddress().setCity("成都"); // 修改员工地址
            employee2.setName("大虚竹"); // 修改员工名字
            employee2.setAge(24);// 修改员工年龄
            System.out.println("员工1的信息：");
            System.out.println(employee1);// 输出employee1对象
            System.out.println("员工2的信息：");
            System.out.println(employee2);// 输出employee2对象
        }

    }
}
