package xyz.tobebetter.sf.task;


import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import xyz.tobebetter.util.LQHandler;

/**
 * Created by zhuqing on 2017/8/20.
 */

public class HttpEntityPostTask<T> extends HttpTask<T> {

    private Object entity;
    public HttpEntityPostTask(String path, Class<T> claz, Object entity,LQHandler.Consumer<T> consumer, Map<String, ?> variables) {
        super(path, claz, consumer, variables);
        this.entity = entity;
    }

    @Override
    protected T request(RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

       // HttpEntity formEntity = new HttpEntity(entity, headers);

        ResponseEntity<T> responseEntity =  restTemplate.postForEntity(this.getPath(),this.entity,this.getClaz(),this.getVariables());
        if(responseEntity.getStatusCode() != HttpStatus.OK){
            responseEntity.getBody();
        }
        return responseEntity.getBody();
    }
}
