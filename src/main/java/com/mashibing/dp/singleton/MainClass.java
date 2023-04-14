package com.mashibing.dp.singleton;

import javax.swing.*;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass extends JFrame {
    public static void main(String[] args) {
        new MainClass();
    }
    private JButton button;
    private JDesktopPane desktopPane;
    private SubFrame iFrame = null;

    public MainClass(){
        super("主窗体");
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        button = new JButton("点击创建一个内部窗体");
        button.addActionListener(new BtListener());
        c.add(button,BorderLayout.SOUTH);

        desktopPane = new JDesktopPane();
        c.add(desktopPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400,400);
        this.show();
    }
    class BtListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (iFrame!=null){
                desktopPane.remove(iFrame);
            }
            iFrame = SubFrame.getFrame();
            desktopPane.add(iFrame);
        }
    }
}
class SubFrame extends JInternalFrame{
    private static SubFrame frame;

    private SubFrame(){
        super("子窗体",true,true,true,false);
        this.setLocation(20,20);
        this.setSize(200,200);
        this.addInternalFrameListener(new MyIFListener());
        this.setVisible(true);
    }

    public static SubFrame getFrame(){
        if (frame==null){
            frame = new SubFrame();
        }
        return frame;
    }
    class MyIFListener extends InternalFrameAdapter {
        public void internalFrameClosing(InternalFrameEvent e){
            if (frame!=null){
                frame = null;
            }
        }
    }
}
