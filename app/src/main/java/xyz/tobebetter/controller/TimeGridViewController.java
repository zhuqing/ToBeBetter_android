package xyz.tobebetter.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.tobebetter.R;
import xyz.tobebetter.activity.CountDownActivity;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.pop.CustomTimeDialog;
import xyz.tobebetter.util.BundleUtil;

/**
 * Created by zhuqing on 2017/8/19.
 */

public class TimeGridViewController extends Controller<View> {
    private GridView gridView;
    private HomeGridViewAdapter homeGridViewAdapter;
    private Button customButton;

    private CustomTimeDialog customTimeDialog;

    private View.OnClickListener customeTimeOkOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(customTimeDialog == null){
                return;
            }

            int seconds =  customTimeDialog.getSeconds();
            UserTask userTask = new UserTask();
            userTask.setSeconds(seconds);
            userTask.setStatus(UserTask.STATUS_SYS);
            Intent in = new Intent();
            in.setClass(gridView.getContext(), CountDownActivity.class);

            in.putExtras(BundleUtil.create(BundleUtil.DATA, userTask));
            gridView.getContext().startActivity(in);
            customTimeDialog.dismiss();
        }
    };

    public TimeGridViewController(View fragment) {
        super(fragment);
    }


    @Override
    public void init() {
        this.gridView = this.getView().findViewById(R.id.time_gridview);
        this.customButton = this.getView().findViewById(R.id.time_custom);
        this.gridViewHandler();
        this.customTime();
    }

    public void customTime(){
        this.customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customTimeDialog = new CustomTimeDialog((Activity) getView().getContext(),customeTimeOkOnClickListener);
                customTimeDialog.show();
            }
        });
    }

    private void gridViewHandler() {
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserTask userTask = (UserTask) homeGridViewAdapter.getItem(position);
                Intent in = new Intent();
                in.setClass(gridView.getContext(), CountDownActivity.class);

                in.putExtras(BundleUtil.create(BundleUtil.DATA, userTask));
                gridView.getContext().startActivity(in);
            }
        });
        addAdapter(createUserTask());
    }

    private HomeGridViewAdapter addAdapter(List<UserTask> users) {
        homeGridViewAdapter = new HomeGridViewAdapter(LayoutInflater.from(this.getView().getContext()));
        homeGridViewAdapter.setItems(users);
        gridView.setAdapter(homeGridViewAdapter);
        homeGridViewAdapter.notifyDataSetChanged();
        return homeGridViewAdapter;
    }

    private List<UserTask> createUserTask() {
        List<UserTask> userTasks = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            UserTask userTask = new UserTask();
            userTask.setId(i * 5 + "");
            userTask.setTitle(i * 5 + "");
            userTask.setSeconds(i * 5 * 60);
            userTask.setStatus(UserTask.STATUS_SYS);
            userTasks.add(userTask);
        }

        return userTasks;
    }

    final class ViewHolder {
        // ImageView imageView;
        TextView title;
        //TextView subTitle;
    }

    class HomeGridViewAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public HomeGridViewAdapter(LayoutInflater mInflater) {
            this.mInflater = mInflater;
        }

        private List<UserTask> items;

        public List<UserTask> getItems() {
            return items;
        }

        public void setItems(List<UserTask> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public UserTask getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0L;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (view != null) {
                holder = (ViewHolder) view.getTag();
            } else {
                holder = new ViewHolder();
                view = this.mInflater.inflate(R.layout.home_gridview_item, null);
                GridView.LayoutParams param = new GridView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        400);//传入自己需要的宽高
                view.setLayoutParams(param);
                // holder.imageView=view.findViewById(R.id.home_listview_item_imageview);
                holder.title = view.findViewById(R.id.home_gridView_item_title);

                //holder.subTitle = view.findViewById(R.id.home_listview_item_subtitle);
                view.setTag(holder);
            }

            UserTask actical = this.getItem(i);

            if (actical == null) {
                return view;
            }
            holder.title.setText(actical.getTitle());
            holder.title.setTag(actical);

            return view;
        }
    }
}
