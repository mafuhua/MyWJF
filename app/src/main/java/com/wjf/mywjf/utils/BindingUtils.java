package com.wjf.mywjf.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.wjf.mywjf.R;

public class BindingUtils {

    /**
     * Imv根据url加载原生图片
     *
     * @param imageView
     * @param url
     */


    @BindingAdapter({"bind:ivUrl"})
    public static void bindUrl(ImageView imageView, String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(R.mipmap.testpic)
                .error(R.mipmap.testpic)
                .crossFade()
                .centerCrop()
                .into(imageView);
    }

    /**
     * Imv根据url加载图片，并转换成圆角
     * @param imageView
     * @param url
     */
    @BindingAdapter({"bind:ivCircleUrl"})
    public static void bindCircleUrl(ImageView imageView, String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Glide.with(imageView.getContext())
                .load(url)
//                .placeholder(R.mipmap.ic_wkzs_list_placeholder)
//                .error(R.mipmap.ic_wkzs_list_placeholder)
                .crossFade()
                .centerCrop()
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }



    /**
     * 圆形图片转化器
     */
    public static class GlideCircleTransform extends BitmapTransformation {
        public GlideCircleTransform(Context context) {
            super(context);
        }

        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private static Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;
            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;
            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);
            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            return result;
        }

        @Override
        public String getId() {
            return getClass().getName();
        }
    }
}
