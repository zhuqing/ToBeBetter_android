package xyz.tobebetter.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Calendar;
import java.util.UUID;

import xyz.tobebetter.MainActivity;
import xyz.tobebetter.R;
import xyz.tobebetter.database.UserTaskDataManager;
import xyz.tobebetter.database.UserTaskRecordDataManager;
import xyz.tobebetter.entity.Status;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.entity.UserTaskRecord;
import xyz.tobebetter.pop.UserTaskInputTitleDialog;
import xyz.tobebetter.util.BundleUtil;

/**
 * 计时任务完成后的保存
 * Created by zhuleqi on 2018/2/22.
 */
public class TimingSaverController extends Controller {
    private TextView timing;
    private Button saveAsTime;
    private Button close;
    private UserTask userTask;
    private UserTaskInputTitleDialog userTaskInputTitleDialog;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(userTaskInputTitleDialog == null){
                return;
            }
            UserTask  userTask = new UserTask();
            userTask.setTitle(userTaskInputTitleDialog.titleEditText.getText().toString().trim());
            userTask.setUserId("11");
            userTask.setStatus(Status.STATUS_CUSTOM_TIME);
            userTask.setId(UUID.randomUUID().toString());
            userTask.setSeconds(getUserTask().getSeconds());
            userTask.setUpdateDate(System.currentTimeMillis());
            userTask.setCreateDate(System.currentTimeMillis());
            userTask.setStartDate(System.currentTimeMillis());
            UserTaskRecord userTaskRecod = createUserTaskRecord();
            UserTaskDataManager.getInstance().insert(userTask, userTaskRecod);


            userTaskInputTitleDialog.dismiss();
            gotoMainActivity(userTask);
        }
    };

    public TimingSaverController(View view,UserTask userTask) {
        super(view);
        this.userTask = userTask;
    }

    @Override
    public void init() {
        if(this.getView() == null|this.userTask == null){
            return;
        }

        this.close = this.getView().findViewById(R.id.timing_saver_close);
        this.saveAsTime = this.getView().findViewById(R.id.timing_saver_save_as_time);
        this.timing = this.getView().findViewById(R.id.timing_saver_timing);
        this.resetTiming(userTask);
        this.saveAsTimeClickHandler();
        this.closeClickHandler();
    }

    private void resetTiming(UserTask userTask){
        this.timing.setText(userTask.getSeconds() / 60 + ":" + userTask.getSeconds());
    }
    public UserTask getUserTask() {
        return userTask;
    }

    public void setUserTask(UserTask userTask) {
        this.userTask = userTask;
    }

    private void closeClickHandler(){
        this.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTask.setTitle("完成计时任务");
                saveUserTaskRecord();
                gotoMainActivity(null);
            }
        });
    }

    private void gotoMainActivity(UserTask userTask){
        Intent intent = new Intent(getView().getContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtras(BundleUtil.create(BundleUtil.DATA,userTask));
        getView().getContext().startActivity(intent);
    }

    private void saveAsTimeClickHandler(){
        this.saveAsTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTaskInputTitleDialog = new UserTaskInputTitleDialog((Activity) getView().getContext(), onClickListener);
                userTaskInputTitleDialog.show();
            }
        });
    }

    private void  saveUserTaskRecord(){
        UserTaskRecord userTaskRecod = this.createUserTaskRecord();
        UserTaskRecordDataManager.getInstance().insert(userTaskRecod);

    }

    private UserTaskRecord createUserTaskRecord(){
        UserTaskRecord userTaskRecord = new UserTaskRecord();
        userTaskRecord.setId(UUID.randomUUID().toString());
        userTaskRecord.setTitle(Calendar.getInstance().get(Calendar.YEAR) + "-" + this.getUserTask().getTitle());
        userTaskRecord.setContent(this.userTask.getTitle());
        userTaskRecord.setUserTaskId(this.getUserTask().getId());
        userTaskRecord.setUserId("11");
        return userTaskRecord;
    }
}
