package xyz.tobebetter.util;

/**
 * Created by zhuleqi on 2018/2/27.
 */
public class StringUtil {
    public static String toTime(int hour, int mins, int seconds) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(addPre(hour));
        stringBuilder.append(":");

        stringBuilder.append(addPre(mins));
        stringBuilder.append(":");
        stringBuilder.append(addPre(seconds));
        return stringBuilder.toString();
    }

    private static String addPre(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        if (num < 10) {
            stringBuilder.append("0");
        }

        stringBuilder.append(num);

        return stringBuilder.toString();
    }
}
