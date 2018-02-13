package xyz.tobebetter.util;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;

import xyz.tobebetter.util.LQHandler;

/**
 * 倒计时
 * Created by zhuleqi on 2018/2/10.
 */
public class TimeUtil {

    public static final String TIME = "TIME";
    public static final int CONUT_DOWN = 1;
    public static final int OVER = -1;
    public static final String TIME_STR = "TIME_STR";

    private int minute = 0;

    private long millis;

    private  CountDownTimer timer;

    private TimeUtil(int minute) {
        this.minute = minute;
        this.millis = this.minute*60*1000;
    }

    public static TimeUtil createTime(int minute) {
        return new TimeUtil(minute);
    }

    public void stop(){

        if(timer!=null){
            timer.cancel();
        }
    }

    public void runCount(final Handler handler){

        timer = new CountDownTimer(this.millis, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                millis = millisUntilFinished;
                long seconds = millisUntilFinished/1000;
                long minute = seconds/60;
                seconds = seconds%60;
                Message message = new Message();
                message.what = CONUT_DOWN;
                Bundle data = new Bundle();
                data.putString(TIME_STR,minute+":"+seconds);
                message.setData(data);
                handler.sendMessage(message);
            }

            @Override
            public void onFinish() {
                Message message = new Message();
                message.what = OVER;
                Bundle data = new Bundle();
                data.putString(TIME_STR,"00:00");
                message.setData(data);
                handler.sendMessage(message);
            }
        };
        timer.start();


    }




    /**
     * 分钟
     */
    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }


}
