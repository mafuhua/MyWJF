package com.wjf.mywjf.home;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wjf.mywjf.MainActivity;
import com.wjf.mywjf.R;
import com.wjf.mywjf.databinding.AdapterviewpagerlistviewBinding;
import com.wjf.mywjf.databinding.LayoutHomeHeadvpBinding;
import com.wjf.mywjf.home.adapter.HomeHeadPagerAdapter;
import com.wjf.mywjf.home.entity.HomeDataModule;

import java.util.List;

/**
 * Created by Administrator on 2016/10/22.
 */
public class HomeAdvertisAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HomeDataModule.DataBean.AdvertisementsBean> advertisements;
    private MainActivity activity;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_HEADER = 999;
    public HomeAdvertisAdapter(List<HomeDataModule.DataBean.AdvertisementsBean> advertisements, MainActivity activity) {

        this.advertisements = advertisements;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapterviewpagerlistview, parent, false));
        } else {
            return new HeadViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_headvp, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder){
            ItemViewHolder holder1 = (ItemViewHolder) holder;
            holder1.bind.setViewModel(advertisements.get(position-1));
        }else {
            HeadViewHolder holder1 = (HeadViewHolder) holder;
            holder1.getBind().vpHomeHeadPics.setBackgroundColor(Color.RED);
            HomeHeadPagerAdapter homeHeadPagerAdapter = new HomeHeadPagerAdapter(activity);
            int count = homeHeadPagerAdapter.getCount();
            holder1.getBind().vpHomeHeadPics.setAdapter(homeHeadPagerAdapter);
        }
    }
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }
    @Override
    public int getItemCount() {
        return advertisements==null?0:advertisements.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private final AdapterviewpagerlistviewBinding bind;
        public ItemViewHolder(View itemView) {
            super(itemView);
            bind =  DataBindingUtil.bind(itemView);
        }

        public AdapterviewpagerlistviewBinding getBind() {
            return bind;
        }
    }
    public class HeadViewHolder extends RecyclerView.ViewHolder{
        private final LayoutHomeHeadvpBinding bind;
        public HeadViewHolder(View itemView) {
            super(itemView);
            bind =  DataBindingUtil.bind(itemView);
        }

        public LayoutHomeHeadvpBinding getBind() {
            return bind;
        }
    }
}
