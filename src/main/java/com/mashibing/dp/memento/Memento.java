package com.mashibing.dp.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
public class Memento implements Serializable {
    private String state ;
    private int X;
    private int Y;
}
