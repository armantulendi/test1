package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    String question="Архитектор Исаакевского собора:" ;
    String question1="Введите номер правильного ответа:";


    String choise[]={"1 Доменико Трезини","2 Огюст Монферран","3 Карл Росси"};
    private JButton button = new JButton("Проверить");
    private JLabel label = new JLabel(question);
    private JLabel label1 = new JLabel(question1);
    private JTextField text=new JTextField();
    private JLabel radio1 = new JLabel(choise[0]);
    private JLabel radio2 = new JLabel(choise[1]);
    private JLabel radio3 = new JLabel(choise[2]);

    public Main() {
        super("Лабораторная работа 1");
        this.setBounds(400,300,400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7,1));
        container.add(label);

        container.add(radio1);
        container.add(radio2);
        container.add(radio3);
        container.add(label1);
        container.add(text);

        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message="";
            if (text.getText().equals("2"))
                message="Правильно\nАрхитектор Исаакиевского собора- "+choise[1];

            else
                message="Вы ошиблись.\nАрхитектор Исаакиевского собора- "+choise[1];
            JOptionPane.showMessageDialog(null,
                    message,
                    "Результат",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
    }
}

