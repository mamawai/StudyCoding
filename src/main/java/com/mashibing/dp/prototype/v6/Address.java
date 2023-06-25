package com.mashibing.dp.prototype.v6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private static final long serialVersionUID = 4983187287403615604L;
    private String state; // 表示员工所在的国家
    private String province; // 表示员工所在的省
    private String city; // 表示员工所在的市
}
