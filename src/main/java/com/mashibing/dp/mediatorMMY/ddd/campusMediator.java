package com.mashibing.dp.mediatorMMY.ddd;

import java.util.ArrayList;
import java.util.List;

public class campusMediator implements SoftwareSystem{
    // 用于管理具体同事类角色
    private List<Employee> members = new ArrayList<Employee>();

    @Override
    public void rigister(Employee e) {
        if (!members.contains(e)) {
            members.add(e);
            e.setSoftwareSystem(this);
        }
    }

    @Override
    public void putMessage(String msg, Employee employee) {
        employee.receive(msg);
    }

    @Override
    public void putMessage(String msg) {
        for (Employee ob : this.members) {
            ob.receive(msg);
        }
    }

    @Override
    public void getMessage(String msg, Employee employee) {
        System.out.println(employee.name + "发送信息:" + msg);
    }
}
