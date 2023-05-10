package com.mashibing.dp.composite.MMY;

public class Client {
    public static void main(String[] args) {
        Folder root = new Folder("Root");

        Folder folder1 = new Folder("Unit 1");
        folder1.addComponent(new File("AAA"))
                .addComponent(new File("BBB"));
        Folder folder2 = new Folder("Unit 2");
        folder2.addComponent(new File("CCC"));

        root.addComponent(folder1)
                .addComponent(folder2)
                .addComponent(new File("DDD"));

        root.display(0);
    }
}
