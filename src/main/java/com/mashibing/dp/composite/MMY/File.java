package com.mashibing.dp.composite.MMY;

public class File extends Component{
    public File(String name) {
        super(name);
    }

    @Override
    public void display(int depth) {
        for (int i = 0;i<depth;i++) System.out.print("--");
        getName();
    }

    @Override
    public void getName() {
        System.out.println(name);
    }
}
