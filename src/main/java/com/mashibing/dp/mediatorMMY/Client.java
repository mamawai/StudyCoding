package com.mashibing.dp.mediatorMMY;

public class Client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        Button button = new Button();
        List list = new List();
        ComboBox comboBox = new ComboBox();
        TextBox textBox = new TextBox();

        button.setMediator(mediator);
        list.setMediator(mediator);
        comboBox.setMediator(mediator);
        textBox.setMediator(mediator);

        mediator.addButton = button;
        mediator.list = list;
        mediator.cb = comboBox;
        mediator.userNameTextBox = textBox;

        button.Changed();
        System.out.println("-----------------");
        list.Changed();
        System.out.println("-----------------");
        comboBox.Changed();
    }
}
