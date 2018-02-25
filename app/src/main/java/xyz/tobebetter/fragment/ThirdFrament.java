package xyz.tobebetter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.tobebetter.R;
import xyz.tobebetter.controller.ProposeController;


/**
 * Created by zhuqing on 2017/8/19.
 */

public class ThirdFrament extends Fragment {
    private View homeView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(this.homeView == null){
            homeView = inflater.inflate(R.layout.third,null);
        }

        new ProposeController(this.homeView).init();
        return this.homeView;
    }

}
