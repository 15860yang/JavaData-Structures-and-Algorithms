package Main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class cbxTest extends JFrame {
    public cbxTest() {
        setBounds(400, 100, 600, 500);
        setLayout(new FlowLayout());





        String[] provinceData = new String[]{"周至县", "户县", "蓝田", "长安区", "碑林区"};
        String[] cityData = new String[]{"凤翔县", "岐山县", "扶风县", "千阳县", "麟游县"};
        String[] countyData = new String[]{"凤翔县", "岐山县", "扶风县", "千阳县", "麟游县"};


        JComboBox<String> province = new JComboBox<>(provinceData);
        province.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("选中了" + province.getSelectedItem());
            }
        });

        JComboBox<String> city = new JComboBox<>(cityData);
        city.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("选中了" + city.getSelectedItem());
            }
        });


        JComboBox<String> county = new JComboBox<>(countyData);
        county.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("选中了" + county.getSelectedItem());
            }
        });

        add(province);
        add(city);
        add(county);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new cbxTest();
    }

}
