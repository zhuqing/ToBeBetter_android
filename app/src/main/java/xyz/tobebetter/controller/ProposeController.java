package xyz.tobebetter.controller;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import xyz.leqisoft.toast.ToastUtil;
import xyz.tobebetter.R;
import xyz.tobebetter.entity.Message;
import xyz.tobebetter.sf.LQService;
import xyz.tobebetter.util.LQHandler;
import xyz.tobebetter.util.UrlConfigUtil;

/**
 * Created by zhuleqi on 2018/2/24.
 */
public class ProposeController extends Controller {
    public Button submit ;
    private EditText connect;
    private EditText message;
    private Button findall;
    public ProposeController(View view) {
        super(view);
    }

    @Override
    public void init() {
        this.submit = this.getView().findViewById(R.id.propose_submit);
        this.connect = this.getView().findViewById(R.id.propose_connect);
        this.message = this.getView().findViewById(R.id.propose_message);
        this.findall = this.getView().findViewById(R.id.propose_findAll);

        this.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String connectStr = connect.getText().toString();
                String messageStr = message.getText().toString();

                StringBuilder url = new StringBuilder();
                url.append(UrlConfigUtil.getInstance().get("HOST"));
                url.append(UrlConfigUtil.getInstance().get("PROPOSE_CREATE"));


                Map<String, String> varibles = new HashMap<String, String>();
                varibles.put("connect", connectStr);
                varibles.put("message", messageStr);

                LQService.post(url.toString(), Message.class, varibles, new LQHandler.Consumer<Message>() {
                    @Override
                    public void applay(Message message) {
                        if (message == null || message.getStatus() == Message.ERROR) {
                            ToastUtil.show(getView().getContext(), "提交失败,查看忘了");
                            return;
                        }
                        if (message.getStatus() == Message.SUCCESS) {
                            ToastUtil.show(getView().getContext(), "提交成功");
                        }
                    }
                });
            }
        });
        this.findAllHandler();
    }

    private void findAllHandler(){
        this.findall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder url = new StringBuilder();
                url.append(UrlConfigUtil.getInstance().get("HOST"));
                url.append(UrlConfigUtil.getInstance().get("PROPOSE_CREATE"));

                LQService.get(url.toString(), Message.class, null, new LQHandler.Consumer<Object>() {
                    @Override
                    public void applay(Object o) {
                        System.err.println(o);
                    }
                });
            }
        });
    }
}
