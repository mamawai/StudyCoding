package com.mashibing.dp.mediatorMMY.ddd;

interface SoftwareSystem {
    // 注册
    public void rigister(Employee e);

    // 得到系统中具体同事角色的消息
    public void getMessage(String msg, Employee employee);

    // 向系统中所有角色发送信息
    public void putMessage(String msg);

    // 向系统中指定的角色发送信息
    public void putMessage(String msg, Employee employee);
}
