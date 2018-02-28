package xyz.tobebetter.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

import xyz.tobebetter.MainActivity;
import xyz.tobebetter.R;
import xyz.tobebetter.database.UserTaskDataManager;
import xyz.tobebetter.database.UserTaskRecodeDataManager;
import xyz.tobebetter.entity.Status;
import xyz.tobebetter.entity.User;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.entity.UserTaskRecod;
import xyz.tobebetter.pop.UserTaskInputTitleDialog;

/**
 * 定时任务完成后的保存
 * Created by zhuleqi on 2018/2/12.
 */
public class TimeSaverController extends Controller{

    private Button resuse;
    private Button share;
    private Button cancel;
    private TextView title;
    private TextView during;
    private EditText content;

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
            UserTaskDataManager.getInstance().insert(userTask);
            setUserTask(userTask);
            saveUserTaskRecord();
            userTaskInputTitleDialog.dismiss();
            toMainAcitvity();
        }
    };


    public TimeSaverController(View view,UserTask userTask) {
        super(view);
        this.setUserTask(userTask);
    }

    @Override
    public void init() {
        this.resuse = this.getView().findViewById(R.id.count_down_save_reuse);
        this.title = this.getView().findViewById(R.id.count_down_save_title);
        this.during = this.getView().findViewById(R.id.count_down_save_during);
        this.share = this.getView().findViewById(R.id.count_down_save_share);
        this.cancel = this.getView().findViewById(R.id.count_down_save_cancel);
        this.content = this.getView().findViewById(R.id.count_down_save_content);

        if(!Status.STATUS_SYS.equals(this.getUserTask().getStatus())){
            this.resuse.setVisibility(View.GONE);
        }
        this.reuseHandler();
        this.cancelHandler();
        this.shareHandler();
    }

    private void shareHandler(){
        this.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserTaskRecord();
                Intent intent = new Intent(getView().getContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                getView().getContext().startActivity(intent);
            }
        });
    }

    private void cancelHandler(){
        this.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserTaskRecord();
                toMainAcitvity();
            }
        });
    }

    private void toMainAcitvity(){
        Intent intent = new Intent(getView().getContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getView().getContext().startActivity(intent);
    }

    private void reuseHandler(){
        this.resuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTaskInputTitleDialog= new UserTaskInputTitleDialog((Activity) getView().getContext(),onClickListener);
                userTaskInputTitleDialog.show();

            }
        });
    }

    private void  saveUserTaskRecord(){
        UserTaskRecod userTaskRecod = this.createUserTaskRecord();
        UserTaskRecodeDataManager.getInstance().insert(userTaskRecod);
    }

    public UserTask getUserTask() {
        return userTask;
    }

    public void setUserTask(UserTask userTask) {
        this.userTask = userTask;
    }

    private UserTaskRecod createUserTaskRecord(){
        UserTaskRecod userTaskRecod = new UserTaskRecod();
        userTaskRecod.setId(UUID.randomUUID().toString());
        userTaskRecod.setTitle(Calendar.getInstance().get(Calendar.YEAR) + "-" + userTask.getTitle());
        userTaskRecod.setContent(this.content.getText().toString());
        userTaskRecod.setUserTaskId(this.getUserTask().getId());
        userTaskRecod.setUserId("11");
        return userTaskRecod;
    }
}
