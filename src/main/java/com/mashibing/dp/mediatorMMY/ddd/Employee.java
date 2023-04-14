package com.mashibing.dp.mediatorMMY.ddd;

abstract class Employee {
    // 用于在注册过程中，用于给职员回复是否注册成功或查询职员是否存在于系统中
    protected SoftwareSystem softwareSystem;
    String name;

    // 由系统发送给职员接受信息
    abstract void receive(String msg);

    // 职员向系统发送信息
    abstract String send(String msg);

    // 设置职员进入的系统
    public void setSoftwareSystem(SoftwareSystem softwareSystem) {
        this.softwareSystem = softwareSystem;
        System.out.println("【注册成功】" + name + "，欢迎您加入!");
    }
}
