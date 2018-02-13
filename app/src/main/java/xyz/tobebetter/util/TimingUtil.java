package xyz.tobebetter.util;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;

/**
 * Created by zhuleqi on 2018/2/11.
 */
public class TimingUtil {
    private Long startTime;

    private CountDownTimer timer;

    public static final int TIMING = 1;
    public static final String TIMING_STR = "TIMING_STR";

    private TimingUtil() {
    }


    public static TimingUtil createTimingUtil() {
        return new TimingUtil();
    }

    public void cancel(){
        if(this.timer == null){
            return;
        }

        this.timer.cancel();
    }

    public void start(final Handler handler) {


        timer = new CountDownTimer(24 * 60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long mills = System.currentTimeMillis()-startTime;
                long min = mills/1000/60;
                long sec = mills/1000%60;

                Message message = new Message();
                message.what = TIMING;
                Bundle data = new Bundle();
                data.putString(TIMING_STR,min+":"+sec);
                message.setData(data);
                handler.sendMessage(message);
            }

            @Override
            public void onFinish() {

            }
        };
        if(this.startTime == null){
            this.startTime = System.currentTimeMillis();
        }
        timer.start();


    }


}
