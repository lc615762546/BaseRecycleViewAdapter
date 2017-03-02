package tvalpha.com.zero.recycleviewadapter;

import android.content.Context;

import java.util.List;

/**
 * Created by LC on 2017/3/2.
 * BaseRecycleViewAdapter  具体使用
 */

public class UserAdapter extends BaseRecycleViewAdapter<String> {

    public UserAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    int getFootViewId() {
        return R.layout.item;
    }

    @Override
    void bindView(BsseViewHolder holder, int position) {
        holder.getTextView(R.id.text).setText("测试项目");
        holder.getImageView(R.id.img).setImageResource(R.mipmap.ic_launcher);
    }
}
