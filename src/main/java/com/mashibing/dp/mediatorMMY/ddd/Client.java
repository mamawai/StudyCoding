package com.mashibing.dp.mediatorMMY.ddd;

public class Client {
    public static void main(String[] args) {
        SoftwareSystem system = new campusMediator();
        Employee o_employee, t_employee, da_employee;
        o_employee = new Open("张三");
        t_employee = new Test("李四");
        da_employee = new Demand("王五");
        system.rigister(o_employee);
        system.rigister(t_employee);
        system.rigister(da_employee);
        system.putMessage("-----校园管理系统开发开始部署-----");

        system.getMessage(o_employee.send("需求太多，不能开发"), o_employee);
        system.putMessage("需求太多，不能开发", t_employee);
    }
}
