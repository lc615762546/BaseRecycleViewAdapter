package tvalpha.com.zero.recycleviewadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LC on 2017/3/2.
 * recycle 适配器
 */

public abstract class BaseRecycleViewAdapter<T> extends RecyclerView.Adapter<BaseRecycleViewAdapter.BsseViewHolder> {
    public Context context;
    public List<T> list;


    public BaseRecycleViewAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public BsseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BsseViewHolder(View.inflate(context, getFootViewId(), null));
    }

    @Override
    public void onBindViewHolder(BsseViewHolder holder, int position) {
        bindView(holder, position);
    }

    // 初始化item
    abstract int getFootViewId();

    //  item 数据绑定
    abstract void bindView(BsseViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    /**
     * 通用ViewHolder
     * 根据需要自行增加 getXXXView 方法
     */
    public static class BsseViewHolder extends RecyclerView.ViewHolder {
        private View itemView;
        //所有View容器
        private Map<Integer, View> map = new HashMap<>();

        public BsseViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        /**
         * 获取TextView通用方法
         *
         * @param resID 资源id
         * @return
         */
        public TextView getTextView(int resID) {
            TextView textView = (TextView) map.get(resID);
            if (textView == null) {
                textView = (TextView) itemView.findViewById(resID);
                map.put(resID, textView);
            }
            return textView;
        }

        /**
         * 获取imageview通用方法
         *
         * @param resID 资源id
         * @return
         */
        public ImageView getImageView(int resID) {
            ImageView imageView = (ImageView) map.get(resID);
            if (imageView == null) {
                imageView = (ImageView) itemView.findViewById(resID);
                map.put(resID, imageView);
            }
            return imageView;
        }
    }
}