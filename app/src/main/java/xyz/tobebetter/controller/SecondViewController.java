package xyz.tobebetter.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import xyz.tobebetter.R;
import xyz.tobebetter.database.UserTaskRecodeDataManager;
import xyz.tobebetter.entity.UserTaskRecod;
import xyz.tobebetter.util.LQHandler;


/**
 * Created by zhuqing on 2017/8/19.
 */

public class SecondViewController extends Controller<View> {
   private ListView userTaskListView;
    public SecondViewController(View fragment) {
        super(fragment);
    }

    @Override
    public void init() {
       userTaskListView = this.getView().findViewById(R.id.useTaskRecord_listview);

        UserTaskRecodeDataManager.getInstance().query("11", new LQHandler.Consumer<List<UserTaskRecod>>() {
            @Override
            public void applay(List<UserTaskRecod> userTaskRecods) {
                initAdapter(userTaskRecods);
            }
        });
    }

    final class ViewHolder{
        // ImageView imageView;
        TextView title;
        //TextView subTitle;
    }

    private void initAdapter(List<UserTaskRecod> userTaskRecods){
        UserTaskRecordListViewAdapter userTaskRecordListViewAdapter = new UserTaskRecordListViewAdapter(LayoutInflater.from(this.getView().getContext()));
        userTaskRecordListViewAdapter.setItems(userTaskRecods);
        userTaskListView.setAdapter(userTaskRecordListViewAdapter);

        //userTaskListView.setOnItemClickListener();
    }

    class UserTaskRecordListViewAdapter extends BaseAdapter {
        private List<UserTaskRecod> items;

        private LayoutInflater mInflater;

        public UserTaskRecordListViewAdapter(LayoutInflater mInflater){
            this.mInflater = mInflater;
        }

        @Override
        public int getCount() {
            return this.getItems().size();
        }

        @Override
        public Object getItem(int position) {
            if(this.getItems().size()>position){
                return this.getItems().get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;

            if(convertView!=null){
                holder = (ViewHolder) convertView.getTag();
            }else{
                holder = new ViewHolder();
                convertView = this.mInflater.inflate(R.layout.usetaskrecord_listview_item,null);
                holder.title = convertView.findViewById(R.id.useTaskRecord_listview_item_title);
                convertView.setTag(holder);

            }

            UserTaskRecod userTaskRecod = (UserTaskRecod) this.getItem(position);
            if(userTaskRecod == null){
                return null;
            }
            holder.title.setText(userTaskRecod.getTitle());
            return convertView;
        }

        public List<UserTaskRecod> getItems() {
            if(this.items == null){
                return Collections.EMPTY_LIST;
            }
            return items;
        }

        public void setItems(List<UserTaskRecod> items) {
            this.items = items;
        }
    }
}
