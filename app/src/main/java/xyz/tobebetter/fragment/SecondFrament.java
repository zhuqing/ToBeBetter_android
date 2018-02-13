package xyz.tobebetter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xyz.tobebetter.R;
import xyz.tobebetter.controller.SecondViewController;


/**
 * Created by zhuqing on 2017/8/19.
 */

public class SecondFrament extends Fragment {
    private View homeView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(this.homeView == null){
            homeView = inflater.inflate(R.layout.second,null);

            new SecondViewController(homeView).init();

        }

        return this.homeView;
    }

}
