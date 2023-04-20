package com.mashibing.dp.FactoryAndStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestMoney {
    Double amount;
    Double historySpend;
    public Double getAll(){
        return amount+historySpend;
    }
}
