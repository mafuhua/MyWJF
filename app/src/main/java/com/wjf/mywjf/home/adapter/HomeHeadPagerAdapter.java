package com.wjf.mywjf.home.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wjf.mywjf.MainActivity;
import com.wjf.mywjf.R;

public class HomeHeadPagerAdapter extends PagerAdapter {
    private MainActivity activity;

    public HomeHeadPagerAdapter(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_home_headview, container, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imageView);
        // ImageView imageView = new ImageView(activity);
        Glide.with(imageView.getContext()).load("http://114.112.104.151:8089/pictures/2015/06/09/1433837279572/1433837279572.png").centerCrop().error(R.mipmap.testpic).crossFade().into(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
