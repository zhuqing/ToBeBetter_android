package xyz.tobebetter.pop;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import xyz.tobebetter.R;

public class UserTaskInputTitleDialog extends CustomDialog{

    private Button saveButton;

    public EditText titleEditText;
    private View.OnClickListener onClickListener;

    public UserTaskInputTitleDialog(Activity context,View.OnClickListener onClickListener) {
        super(context);

        this.onClickListener = onClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.input_usetask_title);

        this.saveButton = this.findViewById(R.id.usertask_title_save_button);

        this.saveButton.setOnClickListener(this.onClickListener);


        titleEditText = this.findViewById(R.id.usertask_title_edittext);

    }
}
