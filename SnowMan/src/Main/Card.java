package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Card extends JFrame {
    public Card() {
        String[] images = new String[]{
                "C:\\Users\\snowman\\Desktop\\纸牌\\1.JPG",
                "C:\\Users\\snowman\\Desktop\\纸牌\\2.JPG",
                "C:\\Users\\snowman\\Desktop\\纸牌\\3.JPG",
                "C:\\Users\\snowman\\Desktop\\纸牌\\4.JPG",
                "C:\\Users\\snowman\\Desktop\\纸牌\\5.JPG",
                "C:\\Users\\snowman\\Desktop\\纸牌\\6.JPG",
                "C:\\Users\\snowman\\Desktop\\纸牌\\7.JPG",
                "C:\\Users\\snowman\\Desktop\\纸牌\\8.JPG",
                "C:\\Users\\snowman\\Desktop\\纸牌\\9.JPG",
                "C:\\Users\\snowman\\Desktop\\纸牌\\10.JPG",
                "C:\\Users\\snowman\\Desktop\\纸牌\\11.JPG",
                "C:\\Users\\snowman\\Desktop\\纸牌\\12.JPG",
                "C:\\Users\\snowman\\Desktop\\纸牌\\13.JPG",
        };

        setLocation(400, 100);
        setSize(600, 500);
        JPanel jpn = new JPanel();
        CardLayout c = new CardLayout();

        for (int i = 0; i < images.length; i++) {
            JLabel jLabColor = new JLabel();
            jLabColor.setLayout(new FlowLayout(FlowLayout.RIGHT));


            ImageIcon colorIcon = new ImageIcon(images[i]);
            jLabColor.setIcon(colorIcon);
            jpn.add(jLabColor, -1);
        }

        jpn.setLayout(c);
        jpn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                c.next(jpn);
            }
        });
        jpn.setBackground(Color.GREEN);
        add(jpn, BorderLayout.CENTER);
        setTitle("大家好，我是曹妍");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Card();
    }


}

