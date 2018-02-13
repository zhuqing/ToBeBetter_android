package xyz.tobebetter.activity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import xyz.tobebetter.R;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.util.BundleUtil;
import xyz.tobebetter.util.TimeUtil;

/**
 * Created by zhuleqi on 2018/2/10.
 */
public class CountDownActivity extends AppCompatActivity {
    private TextView countDownTextView;
    /**
     * 是否正在计时
     */
    private boolean counting = false;
    private Button countDownTextButton;



    private TimeUtil time;

    private UserTask userTask;

    class LQStatus{
        private LQStatusEnum status = LQStatusEnum.START;


    }

    enum LQStatusEnum{
        START,
        STOP,
        CONTINUE,
        RUNNING

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_down);

         userTask = (UserTask) this.getIntent().getExtras().getSerializable(BundleUtil.DATA);
        time = TimeUtil.createTime(userTask.getMinutes());

        this.countDownTextButton = (Button) this.findViewById(R.id.count_down_button);
        this.countDownTextView = (TextView) this.findViewById(R.id.count_down_text);
        this.init();
    }

    private void init() {
        this.countDownTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counting) {
                    counting = false;
                    countDownTextButton.setText(R.string.continue_);
                    time.stop();
                    return;
                }
                countDownTextButton.setText(R.string.stop);
                counting = true;
                time.runCount(new CountDownHandler());
            }
        });

        this.countDownTextView.setText(time.getMinute() + ":00");

    }

    private class CountDownHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case TimeUtil.CONUT_DOWN:
                    countDownTextView.setText(msg.getData().getString(TimeUtil.TIME_STR));
                    break;
                case TimeUtil.OVER:
                    countDownTextView.setText(msg.getData().getString(TimeUtil.TIME_STR));
                    countDownTextButton.setText(R.string.close);
                    turn2NextActicity();
                    break;
            }
        }
    }


    private void turn2NextActicity() {
        Intent in = new Intent();
        in.setClass(CountDownActivity.this, TimeSaverActicity.class);
        in.putExtras(BundleUtil.create(BundleUtil.DATA, userTask));
        CountDownActivity.this.startActivity(in);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
