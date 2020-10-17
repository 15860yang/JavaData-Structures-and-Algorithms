package Main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;

public class SwingTest {
    public static void main(String[] args) {
        int x = 400;
        int y = 400;
        new SwingTest().RobotTest(x, y);
    }

    public void RobotTest(int x, int y) {
        Robot rbt = null;
        try {
            rbt = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        rbt.setAutoDelay(300);

        rbt.mouseMove(x, y);
        rbt.mouseMove(x + 300, y);

        rbt.mouseMove(x + 600, y + 300);
        rbt.mouseMove(x + 300, y + 300);

    }
}
