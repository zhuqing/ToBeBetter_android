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
import xyz.tobebetter.controller.TimeGridViewController;
import xyz.tobebetter.util.BundleUtil;
import xyz.tobebetter.util.TimingUtil;

/**
 * Created by zhuleqi on 2018/2/11.
 */
public class TimingActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private TextView cancel;

    private TimingUtil timingUtil;

    private boolean isRuning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timing);


        this.init();
    }

    private void init(){
        this.textView = (TextView) this.findViewById(R.id.timing_text);
        this.button = (Button) this.findViewById(R.id.timing_start_button);
        this.cancel = (TextView) this.findViewById(R.id.timing_cancel_textview);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isRuning){
                    if(timingUtil!=null){
                        timingUtil.cancel();
                    }
                    isRuning = false;
                    gotoTimingSaver();
                    return;
                }
                timingUtil = TimingUtil.createTimingUtil();
                timingUtil.start(new TimingHandler());
                button.setText(R.string.end);
                isRuning = true;
            }
        });
        this.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                getApplicationContext().startActivity(intent);
            }
        });

        this.textView.setText("00:00:00");
    }

    public void gotoTimingSaver(){
        Intent intent = new Intent(getApplicationContext(), TimingSaverActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtras(BundleUtil.create(BundleUtil.DATA,timingUtil.getSeconds()));
        getApplicationContext().startActivity(intent);
    }


    class TimingHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case TimingUtil.TIMING:
                    textView.setText(msg.getData().getString(TimingUtil.TIMING_STR));
                    break;
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timingUtil!=null){
            timingUtil.cancel();
        }
    }
}
