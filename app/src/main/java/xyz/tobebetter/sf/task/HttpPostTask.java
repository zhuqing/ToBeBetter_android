package xyz.tobebetter.sf.task;


import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        JSONObject jsonObj = new JSONObject(this.getVariables());
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);

        return (T) restTemplate.postForObject(this.getPath(),formEntity,this.getClaz());
    }
}
