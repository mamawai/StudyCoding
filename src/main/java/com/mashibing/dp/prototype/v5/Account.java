package com.mashibing.dp.prototype.v5;


import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Cloneable{
    /** 主键 */
    private Long id;
    /** 账户名称 */
    private String name;
    /** 账户详情 */
    private AccountDetail detail;
    /** 重写clone方法，改为public用以外部调用 */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Account clone = (Account)super.clone();
        clone.detail = (AccountDetail) detail.clone();
        return clone;

    }
}
