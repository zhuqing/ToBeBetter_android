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

public class UserTaskInputTitleDialog extends Dialog{

    private Button saveButton;

    public EditText titleEditText;
    private View.OnClickListener onClickListener;
    private Activity context;
    public UserTaskInputTitleDialog(Activity context,View.OnClickListener onClickListener) {
        super(context);
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.input_usetask_title);

        this.saveButton = this.findViewById(R.id.usertask_title_save_button);

        this.saveButton.setOnClickListener(this.onClickListener);
        this.titleEditText = this.findViewById(R.id.usertask_title_edittext);

        /*
   * 获取圣诞框的窗口对象及参数对象以修改对话框的布局设置, 可以直接调用getWindow(),表示获得这个Activity的Window
   * 对象,这样这可以以同样的方式改变这个Activity的属性.
   */
        Window dialogWindow = this.getWindow();

        WindowManager m = this.context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        // p.height = (int) (d.getHeight() * 0.6); // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.8
        dialogWindow.setAttributes(p);
    }
}
