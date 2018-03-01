package xyz.tobebetter.sf.task;


import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import xyz.tobebetter.entity.Message;
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

        ResponseEntity<Message> responseEntity =  restTemplate.postForEntity(this.getPath(),this.entity,Message.class,this.getVariables());
        if(responseEntity.getStatusCode() == HttpStatus.OK){
            Message message = responseEntity.getBody();
            if(message.getStatus()==Message.ERROR){
                throw new RuntimeException(message.getMessage());
            }
            String data = (String) message.getData();

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(MapperFeature.USE_GETTERS_AS_SETTERS, true);
            return mapper.convertValue(data,this.getClaz());

        }

        return null;
    }
}
