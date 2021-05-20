import java.lang.System;
public class ColorTest {
    public static void main(String[] args) {
        Color color = new Color(new Integer(5), 0, 0);
        System.out.println(color);
        Color red1 = new Color(255, 0, 0);
        Color red2 = new Color(255, 0, 0);
        System.out.println(red1 == red2);
    }
}