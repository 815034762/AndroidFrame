package com.example.myapplication.demo;

import com.example.myapplication.viewmodel.model.JokeModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Description:
 * @Author: ch
 * @CreateDate: 2019/7/25 21:09
 */
public class NetUtil {

    private Retrofit retrofit;

    public NetUtil() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/") // "https://cn.bing.com/"
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public interface ImageService {
        @GET("HPImageArchive.aspx")
        Observable<ImageBean> getBingImage(@Query("format") String format,
                                           @Query("idx") int idx,
                                           @Query("n") int n);

        @GET("joke/content/list.php")
        Observable<JokeModel> getJokeList(@Query("key") String key,
                                       @Query("sort") String sort,
                                       @Query("time") long time,
                                       @Query("pagesize") int pagesize,
                                       @Query("page") int page);
    }

    public Observable<ImageBean> getBingImage(String format, int idx, int n) {
        return retrofit.create(ImageService.class).getBingImage(format, idx, n);
    }

    public Observable<JokeModel> getJoke(String sort, int page, int pagesize, long time) {
        return retrofit.create(ImageService.class).getJokeList("18a7e8c8321fd5137b2f61e8cb60f007", sort, time, pagesize, page);
    }

    // 18a7e8c8321fd5137b2f61e8cb60f007
    // http://v.juhe.cn/joke/content/list.php?key=您申请的KEY&page=2&pagesize=10&sort=asc&time=1418745237

}

