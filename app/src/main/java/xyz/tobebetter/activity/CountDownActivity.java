package xyz.tobebetter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import xyz.tobebetter.MainActivity;
import xyz.tobebetter.R;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.util.BundleUtil;
import xyz.tobebetter.util.StringUtil;
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

    private TextView countDownCancel;


    private TimeUtil time;

    private UserTask userTask;


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();


    }



    enum LQStatusEnum {
        START(R.string.start),
        STOP(R.string.stop),
        CONTINUE(R.string.continue_),
        RUNNING(R.string.start);

        private int rid;

        private LQStatusEnum(int rid) {
            this.rid = rid;
        }

        public int getRid() {
            return rid;
        }

        public void setRid(int rid) {
            this.rid = rid;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_down);

        userTask = (UserTask) this.getIntent().getExtras().getSerializable(BundleUtil.DATA);
        time = TimeUtil.createTime(userTask.getSeconds());

        this.countDownTextButton = (Button) this.findViewById(R.id.count_down_button);
        this.countDownTextView = (TextView) this.findViewById(R.id.count_down_text);
        this.countDownCancel = (TextView) this.findViewById(R.id.count_down_cancel);
        this.init();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
       // client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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




        this.countDownCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                getApplicationContext().startActivity(intent);
            }
        });

        this.initCountDownTextView();

    }

    private void initCountDownTextView(){
        int seconds = time.getSeconds()%60;
        int mins = time.getSeconds()/60;
        int hours = mins/60;
        mins = mins%60;
        this.countDownTextView.setText(StringUtil.toTime(hours,mins,seconds));
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
        if(time!=null){
            time.stop();
        }
    }
}
