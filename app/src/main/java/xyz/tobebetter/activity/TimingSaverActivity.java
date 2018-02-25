package xyz.tobebetter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import xyz.tobebetter.R;
import xyz.tobebetter.controller.TimingSaverController;
import xyz.tobebetter.entity.User;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.util.BundleUtil;

/**
 * Created by zhuleqi on 2018/2/22.
 */
public class TimingSaverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timing_saver);


        int secondes = this.getIntent().getExtras().getInt(BundleUtil.DATA,0);
        UserTask userTask = new UserTask();
        userTask.setSeconds(secondes);
        new TimingSaverController(this.findViewById(R.id.time_saver), userTask).init();
    }

    private void init() {


    }

}
