package xyz.tobebetter.pop;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.NumberPicker;

import xyz.tobebetter.R;

/**
 * Created by zhuleqi on 2018/2/25.
 */
public class CustomTimeDialog extends CustomDialog {

    private NumberPicker minitues;
    private NumberPicker seconds;


    private  View.OnClickListener onClickListener;
    public CustomTimeDialog(Activity context, View.OnClickListener onClickListener) {
        super(context);
        this.onClickListener = onClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.custom_time_popwindow);
        Button okButton = this.findViewById(R.id.custom_time_ok);
        okButton.setOnClickListener(this.onClickListener);
        this.minitues = this.findViewById(R.id.custom_time_minites);
        this.seconds = this.findViewById(R.id.custom_time_seconds);

        this.minitues.setMaxValue(180);
        this.minitues.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return value + getActivity().getResources().getString(R.string.minute);
            }
        });
        this.minitues.setMinValue(0);
        this.seconds.setMaxValue(59);

        this.seconds.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return value + "秒";
            }
        });
        this.seconds.setMinValue(0);
    }

    public int getSeconds(){
        return this.minitues.getValue()*60+this.seconds.getValue();
    }
}
