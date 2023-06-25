package com.mashibing.dp.prototype.v5;


import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetail implements Cloneable{
    /**
     * 账户ID
     */
    private Long accountId;
    /**
     * 邮箱
     */
    private String email;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
