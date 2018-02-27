package xyz.tobebetter.controller;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import xyz.tobebetter.R;

import xyz.tobebetter.activity.CountDownActivity;
import xyz.tobebetter.activity.SelectTimeActivity;
import xyz.tobebetter.activity.TimingActivity;
import xyz.tobebetter.database.UserTaskDataManager;
import xyz.tobebetter.entity.Status;
import xyz.tobebetter.entity.User;
import xyz.tobebetter.entity.UserTask;
import xyz.tobebetter.util.BundleUtil;
import xyz.tobebetter.util.LQHandler;

/**
 * Created by zhuqing on 2017/8/19.
 */

public class HomeGridViewController extends Controller<View>{
    private GridView gridView;
    private HomeGridViewAdapter homeGridViewAdapter;

    public HomeGridViewController(View fragment) {
        super(fragment);
    }


    @Override
    public void init() {
       this.gridView = (GridView) this.getView().findViewById(R.id.home_gridView);

        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserTask userTask = homeGridViewAdapter.getItem(position);
                Intent in = new Intent();
                switch (userTask.getId().toString()) {
                    case "1":
                        in.setClass(gridView.getContext(), SelectTimeActivity.class);
                        break;
                    case "2":
                        in.setClass(gridView.getContext(), TimingActivity.class);
                        break;
                    default:
                        if (userTask.getStatus() == Status.STATUS_CUSTOM_TIME) {
                            in.setClass(gridView.getContext(), CountDownActivity.class);
                        } else if (userTask.getStatus() == Status.STATUS_CUSTOM_TIMEING) {
                            in.setClass(gridView.getContext(), TimingActivity.class);

                        }
                }

                in.putExtras(BundleUtil.create(BundleUtil.DATA, userTask.clone()));

                gridView.getContext().startActivity(in);

            }
        });

        fetchUserTasks();

    }

    private void fetchUserTasks(){

        UserTaskDataManager.getInstance().query(1, new LQHandler.Consumer<List<UserTask>>() {
            @Override
            public void applay(List<UserTask> os) {
                List<UserTask> userTasks = new ArrayList<>();

                UserTask tesk = new UserTask();
                tesk.setTitle("定时");
                tesk.setId(1 + "");
                tesk.setStatus(Status.STATUS_SYS);

                userTasks.add(tesk);
                tesk = new UserTask();
                tesk.setTitle("计时");
                tesk.setId(2 + "");
                tesk.setStatus(Status.STATUS_SYS);
                userTasks.add(tesk);

                userTasks.addAll(os);
                addAdapter(userTasks);
            }
        });
    }

    private HomeGridViewAdapter addAdapter(List<UserTask> users){
         homeGridViewAdapter = new HomeGridViewAdapter(LayoutInflater.from(this.getView().getContext()));
        homeGridViewAdapter.setItems(users);
        gridView.setAdapter(homeGridViewAdapter);
        homeGridViewAdapter.notifyDataSetChanged();
        return homeGridViewAdapter;
    }

    final class ViewHolder{
       // ImageView imageView;
        TextView title;
        //TextView subTitle;
    }

    class HomeGridViewAdapter extends BaseAdapter{

        private LayoutInflater mInflater;

        public HomeGridViewAdapter(LayoutInflater mInflater){
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
            if(view!=null){
                holder = (ViewHolder) view.getTag();
            }else{
                holder = new ViewHolder();
                view =this.mInflater.inflate(R.layout.home_gridview_item, null);
                GridView.LayoutParams param = new GridView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        400);//传入自己需要的宽高
                view.setLayoutParams(param);
                holder.title = view.findViewById(R.id.home_gridView_item_title);

                //holder.subTitle = view.findViewById(R.id.home_listview_item_subtitle);
                view.setTag(holder);
            }

            UserTask actical = this.getItem(i);
            if(actical == null){
                return view;
            }
            holder.title.setText(actical.getTitle());
            holder.title.setTag(actical);
            return view;
        }
    }
}
