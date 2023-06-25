package com.mashibing.dp.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

// 要作为被备份的目标类
@Data
@ToString
@AllArgsConstructor
public class Originator{
    private String state ;
    private int X;
    private int Y;
    public Memento createMemento(){
        return new Memento(state,X,Y);
    }
}
