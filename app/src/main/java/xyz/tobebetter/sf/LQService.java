package xyz.tobebetter.sf;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;



import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.Map;

import xyz.tobebetter.sf.task.HttpEntityPostTask;
import xyz.tobebetter.sf.task.HttpGetTask;
import xyz.tobebetter.sf.task.HttpPostTask;
import xyz.tobebetter.util.LQHandler;

/**
 * Created by zhuqing on 2017/8/19.
 */

public class LQService {
    private HttpURLConnection hipClient;

   // private static String http = "http://192.168.1.94:8080";

    public static  <T> void  get(String path , Class claz, Map<String,?> variables, LQHandler.Consumer<T> consumer){
         new HttpGetTask(path,claz,consumer,variables).execute();
    }

    public static <T> void post(String path , Class claz,Map<String,?> variables,LQHandler.Consumer<T> consumer){
        new HttpPostTask<>(path,claz,consumer,variables).execute();
    }

    public static <T> void post(String path , Class claz,Object entity,Map<String,?> variables,LQHandler.Consumer<T> consumer){
        new HttpEntityPostTask<>(path,claz,entity,consumer,variables).execute();
    }







}


