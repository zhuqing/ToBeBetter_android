package xyz.tobebetter.sf.task;



import org.springframework.web.client.RestTemplate;

import java.util.Map;

import xyz.tobebetter.util.LQHandler;

/**
 * Created by zhuqing on 2017/8/20.
 */

public class HttpPostTask<T> extends HttpTask<T> {
    public HttpPostTask(String path, Class<T> claz, LQHandler.Consumer<T> consumer, Map<String, ?> variables) {
        super(path, claz, consumer, variables);
    }

    @Override
    protected T getT(RestTemplate restTemplate) {
        return restTemplate.postForObject(this.getPath(),null,this.getClaz(),this.getVariables());
    }
}
