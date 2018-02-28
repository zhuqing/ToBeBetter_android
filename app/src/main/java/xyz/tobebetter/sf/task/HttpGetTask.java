package xyz.tobebetter.sf.task;



import org.springframework.web.client.RestTemplate;

import java.util.Map;

import xyz.tobebetter.util.LQHandler;

public  class HttpGetTask<T> extends HttpTask<T> {

    public HttpGetTask(String path, Class<T> claz, LQHandler.Consumer<T> consumer, Map<String, ?> variables) {
        super(path, claz, consumer, variables);
    }

    @Override
    protected T request(RestTemplate restTemplate) {
       return restTemplate.getForObject(this.getPath(), this.getClaz(),this.getVariables());
    }


}