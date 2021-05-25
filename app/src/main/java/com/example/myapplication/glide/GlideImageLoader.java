package com.example.myapplication.glide;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * @author ly-zhangty
 * 网络加载图片库
 */
public class GlideImageLoader {
    public static GlideImageLoader mImageLoader;
    private static Context mContext;

    public static synchronized GlideImageLoader get(@NonNull Context context) {
        if (null == mImageLoader) {
            mImageLoader = new GlideImageLoader();
        }
        mContext = context.getApplicationContext();
        return mImageLoader;
    }

    /**
     * 显示网络图片
     *
     * @param imageUrl  网络url
     * @param imageView 需要加载图片的ImageView
     */
    public void displayImage(String imageUrl, ImageView imageView) {
        RequestOptions requestOptions = RequestOptions.noTransformation().dontAnimate();
        Glide.with(mContext).load(imageUrl).diskCacheStrategy(DiskCacheStrategy.ALL).apply(requestOptions).into(imageView);
    }

    /**
     * 显示网络图片
     *
     * @param imageUrl     网络url
     * @param imageView    需要加载图片的ImageView
     * @param defaultImage 默认图片
     */
    public void displayImage(String imageUrl, ImageView imageView, int defaultImage) {
        RequestOptions requestOptions = RequestOptions.noTransformation().placeholder(defaultImage).error(defaultImage).fallback(defaultImage).dontAnimate();
        Glide.with(mContext).load(imageUrl).diskCacheStrategy(DiskCacheStrategy.ALL).apply(requestOptions).into(imageView);
    }

    /**
     * 显示圆角网络图片
     *
     * @param imageUrl  网络url
     * @param rounde    圆角半径
     * @param imageView 需要加载图片的ImageView
     */
    public void displayRoundImageView(String imageUrl, int rounde, ImageView imageView) {
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(dp2px(mContext, rounde));
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners).dontAnimate();
        Glide.with(mContext).load(imageUrl).apply(requestOptions).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /**
     * 显示网络图片
     *
     * @param imageUrl     网络url
     * @param rounde       圆角半径
     * @param imageView    需要加载图片的ImageView
     * @param defaultImage 默认图片
     */
    public void displayRoundImageView(String imageUrl, int rounde, ImageView imageView, @NonNull int defaultImage) {
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(dp2px(mContext, rounde));
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners).placeholder(defaultImage).error(defaultImage).fallback(defaultImage).dontAnimate();
        Glide.with(mContext).load(imageUrl).apply(requestOptions).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /**
     * 显示网络图片
     *
     * @param imageUrl  网络url
     * @param imageView 需要加载图片的ImageView
     */
    public void displayImage(String imageUrl, ImageView imageView, int width, int height) {
        RequestOptions requestOptions = RequestOptions.noAnimation().dontAnimate().override(width, height);
        Glide.with(mContext).load(imageUrl).apply(requestOptions).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /**
     * 显示网络图片
     *
     * @param imageUrl     网络url
     * @param imageView    需要加载图片的ImageView
     * @param defaultImage 默认图片
     */
    public void displayImage(String imageUrl, ImageView imageView, @NonNull int defaultImage, int width, int height) {
        RequestOptions requestOptions = RequestOptions.noAnimation().dontAnimate().placeholder(defaultImage).error(defaultImage).fallback(defaultImage).override(width, height);
        Glide.with(mContext).load(imageUrl).apply(requestOptions).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /**
     * 显示网络图片
     *
     * @param imageUrl     网络url
     * @param rounde       圆角半径
     * @param imageView    需要加载图片的ImageView
     * @param defaultImage 默认图片
     */
    public void displayRoundImageView(String imageUrl, int rounde, ImageView imageView, @NonNull int defaultImage, int width, int height) {
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(dp2px(mContext, rounde));
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners).dontAnimate().placeholder(defaultImage).error(defaultImage).fallback(defaultImage).override(width, height);
        Glide.with(mContext).load(imageUrl).apply(requestOptions).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    /**
     * convert dp to its equivalent px
     * 将dp转换为与之相等的px
     */
    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
