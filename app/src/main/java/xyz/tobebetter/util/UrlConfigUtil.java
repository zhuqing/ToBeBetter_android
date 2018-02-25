package xyz.tobebetter.util;

import android.content.Context;

import java.io.IOException;
import java.util.Properties;

import xyz.tobebetter.R;

/**
 * Created by zhuleqi on 2018/2/25.
 */
public class UrlConfigUtil {
    private Properties urlProperties ;
    private Context context;

    private static UrlConfigUtil urlConfigUtil;

    public UrlConfigUtil(Context context){
       this.context = context;
        init();
    }

    public static void init(Context context){
        if(urlConfigUtil == null){
            urlConfigUtil = new UrlConfigUtil(context);
        }
    }

    public static UrlConfigUtil getInstance(){
        return urlConfigUtil;
    }

    private void init(){
        urlProperties = new Properties();
        try {
            urlProperties.load(context.getApplicationContext().getResources().openRawResource(R.raw.urlconfig));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String key){
        if(urlProperties == null){
            return null;
        }

        return urlProperties.getProperty(key,null);
    }
}
