package xyz.tobebetter.controller.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import xyz.leqisoft.util.log.LOGGER;
import xyz.tobebetter.R;
import xyz.tobebetter.controller.Controller;

/**
 * Created by zhuleqi on 2018/2/25.
 */
public class LoginController extends Controller {

    LOGGER logger = new LOGGER(LoginController.class);

    private EditText userName;
    private EditText password;
    private Button weChatLoginButton;
    private Button qqLoginButton;
    private TextView forgetPassword;
    private TextView regist;

    private Button loginButton;


    public LoginController(View view) {
        super(view);
    }

    @Override
    public void init() {
        this.userName = this.getView().findViewById(R.id.login_username);
        this.password = this.getView().findViewById(R.id.login_passeord);

        this.weChatLoginButton = this.getView().findViewById(R.id.login_wechat_button);
        this.qqLoginButton = this.getView().findViewById(R.id.login_qq_button);

        this.forgetPassword = this.getView().findViewById(R.id.login_forget_password);
        this.regist = this.getView().findViewById(R.id.login_regist);

        this.loginButton = this.getView().findViewById(R.id.login_buton);

        this.loginHandler();
        this.forgetPasswordHandler();
        this.registHandler();
    }

    private void registHandler(){
        this.regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logger.v("注册");
            }
        });
    }

    private void forgetPasswordHandler(){
        this.forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logger.v("忘记密码");
            }
        });
    }

    private void loginHandler(){
        this.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logger.v("登陆");
                String userNameStr = userName.getText().toString();
                String passwordStr = password.getText().toString();

            }
        });
    }
}
