package com.example.myapplication.demo;

import com.example.myapplication.ui.notifications.Notifications;
import com.example.myapplication.viewmodel.model.Book;
import com.example.myapplication.viewmodel.model.BookDetail;
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
    private Retrofit apiRetrofit;

    public static final String NEWS_KEY = "92d4dbc31b5860b6a1d46b1e7cd1a4cf";
    public static final String KEY = "18a7e8c8321fd5137b2f61e8cb60f007";
    public static final String BOOK_KEY = "c3ef4b1e1c580d2a3307d2c3a4384e8e";

    public NetUtil() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/") // "https://cn.bing.com/"
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiRetrofit = new Retrofit.Builder()
                .baseUrl("http://apis.juhe.cn/") // "https://cn.bing.com/"
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public interface HttpService {
        @GET("HPImageArchive.aspx")
        Observable<ImageBean> getBingImage(@Query("format") String format,
                                           @Query("idx") int idx,
                                           @Query("n") int n);

        @GET("joke/content/list.php")
        Observable<Notifications> getNotificationList(@Query("key") String key,
                                          @Query("sort") String sort,
                                          @Query("time") long time,
                                          @Query("pagesize") int pagesize,
                                          @Query("page") int page);

        @GET("joke/content/list.php")
        Observable<JokeModel> getJokeList(@Query("key") String key,
                                          @Query("sort") String sort,
                                          @Query("time") long time,
                                          @Query("pagesize") int pagesize,
                                          @Query("page") int page);

        @GET("goodbook/catalog")
        Observable<Book> getBookList(@Query("key") String key);

        @GET("toutiao/index")
        Observable<Book> getNewList(@Query("key") String key);

        @GET("goodbook/query")
        Observable<BookDetail> getBookDetail(@Query("key") String key,@Query("catalog_id") String catalogId,@Query("pn") int pn,@Query("rn") int rn);
    }

    // 获取httpService
    public HttpService getHttpService() {
        return retrofit.create(HttpService.class);
    }

    // 获取api HttpService
    public HttpService getApiHttpService() {
        return apiRetrofit.create(HttpService.class);
    }

    public Observable<ImageBean> getBingImage(String format, int idx, int n) {
        return retrofit.create(HttpService.class).getBingImage(format, idx, n);
    }

    public Observable<JokeModel> getJoke(String sort, int page, int pagesize, long time) {
        return retrofit.create(HttpService.class).getJokeList(KEY, sort, time, pagesize, page);
    }
}

