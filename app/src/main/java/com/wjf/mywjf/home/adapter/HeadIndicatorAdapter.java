package com.wjf.mywjf.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wjf.mywjf.R;
import com.wjf.mywjf.home.entity.HeadNavMenu;

/**
 * Created by Administrator on 2016/10/20.
 */

public class HeadIndicatorAdapter extends RecyclerView.Adapter<HeadIndicatorAdapter.HeadIndicatorHolder> {
    private HeadNavMenu.DataBean appMenus;
    private int mrcPosition;

    public HeadIndicatorAdapter(HeadNavMenu.DataBean appMenus) {
        this.appMenus = appMenus;
    }

    @Override
    public HeadIndicatorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_recycle_textview,
                parent, false);
        HeadIndicatorHolder headIndicatorHolder = new HeadIndicatorHolder(view);
        return headIndicatorHolder;
    }

    @Override
    public void onBindViewHolder(HeadIndicatorHolder holder, int position) {
        mrcPosition = position;
        holder.text.setText(appMenus.getAppMenus().get(position).getName());

    }

    @Override
    public int getItemCount() {
        return appMenus.getAppMenus()==null?0:appMenus.getAppMenus().size();
    }
    public class HeadIndicatorHolder extends RecyclerView.ViewHolder{
        private final TextView text;

        public HeadIndicatorHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.home_icon_item_text);
        }
    }
}
