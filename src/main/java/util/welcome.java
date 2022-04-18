package util;

import java.util.Random;

import static java.lang.Math.abs;

public class welcome {
    private static String[] wel = {"一天八杯水哦！","久坐不利于身体健康，请多活动活动!","今天在群里吹水了吗？","好好学习，天天向上！","今天写代码了吗？"};
    public static String getwelcome()
    {
        int i = wel.length;
        Random ran = new Random();
        int randi = abs(ran.nextInt())%i;
        String re = wel[randi];

        return re;
    }
}
