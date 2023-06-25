package com.mashibing.dp.memento;


import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

// 备份管理类
public class CareTaker {
    private Memento memento;
    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public void saveStateInFile(String path){
        File file = new File(path);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            oos.writeObject(memento);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Originator loadFromFile(Originator ori, String path){
        File file = new File(path);
        try {
            ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file.toPath()));
            Memento m = (Memento) ois.readObject();
            ori.setState(m.getState());
            ori.setX(m.getX());
            ori.setY(m.getY());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ori;
    }
}
