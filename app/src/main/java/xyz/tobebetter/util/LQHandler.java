package xyz.tobebetter.util;

/**
 * Created by zhuqing on 2017/8/19.
 */

public class LQHandler{
    public interface Callback<T,R> {
        public R call(T t);
    }

    public interface Consumer<T>{
        public void applay(T t);
    }
}


