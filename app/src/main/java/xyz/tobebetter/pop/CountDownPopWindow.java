package xyz.tobebetter.pop;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import xyz.tobebetter.R;

/**
 * Created by zhuleqi on 2018/2/11.
 */
public class CountDownPopWindow extends PopupWindow {
    private Button save;

    public CountDownPopWindow(Context context) {
        super(context);

        //xyz.leqisoft.R.anim.abc_popup_enter;
        View view =LayoutInflater.from(context).inflate(R.layout.count_down_popwindow,null);
        this.setContentView(view);
        this.save = view.findViewById(R.id.count_down_popwindow_save);
        // 设置弹出窗体的宽和高
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);

        // 设置弹出窗体可点击
        this.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        // 设置弹出窗体的背景
        this.setBackgroundDrawable(dw);

        // 设置弹出窗体显示时的动画，从底部向上弹出
        this.setAnimationStyle(R.style.count_down_popwindow);
        this.initSave();

    }

    private void  initSave(){
        this.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }
}
