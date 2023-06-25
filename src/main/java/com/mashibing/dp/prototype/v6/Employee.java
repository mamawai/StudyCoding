package com.mashibing.dp.prototype.v6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    private static final long serialVersionUID = 3049633059823371192L;
    private String name; // 表示员工的姓名
    private int age; // 表示员工的年龄
    private Address address;// 表示员工的地址
    public Employee deepClone() throws IOException, ClassNotFoundException {
        // 将对象写入流中
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(this);
        // 将对象从流中取出
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (Employee) ois.readObject();// 从内存读取对象
    }
}
