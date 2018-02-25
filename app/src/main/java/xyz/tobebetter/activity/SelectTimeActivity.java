package xyz.tobebetter.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import xyz.tobebetter.R;
import xyz.tobebetter.controller.TimeGridViewController;

/**
 * Created by zhuleqi on 2018/2/10.
 */
public class SelectTimeActivity extends AppCompatActivity {
    private TimeGridViewController timeGridViewController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time);
        this.timeGridViewController = new TimeGridViewController(this.findViewById(R.id.time_select));
        this.timeGridViewController.init();
    }
}
