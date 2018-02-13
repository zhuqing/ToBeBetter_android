package xyz.tobebetter.activity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import xyz.tobebetter.MainActivity;
import xyz.tobebetter.R;
import xyz.tobebetter.controller.TimeGridViewController;
import xyz.tobebetter.controller.TimeSaverController;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.util.BundleUtil;

/**
 * Created by zhuleqi on 2018/2/12.
 */
public class TimeSaverActicity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_down_save);
        UserTask userTask = (UserTask) this.getIntent().getExtras().getSerializable(BundleUtil.DATA);
        new TimeSaverController(this.findViewById(R.id.count_down_save_r),userTask).init();
        playAudio();
    }

    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void playAudio() {
        mediaPlayer = MediaPlayer.create(this, R.raw.audio2);
        mediaPlayer.setVolume(50, 50);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        // mediaPlayer.setAudioAttributes(AudioAttributes.CREATOR.createFromParcel());
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;

//                CountDownPopWindow pop = new CountDownPopWindow(CountDownActivity.this.getApplicationContext());
//                pop.showAtLocation(findViewById(R.id.count_down_main), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        });
        mediaPlayer.start();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if( mediaPlayer == null){
            mediaPlayer.release();
        }
    }
}
