package com.example.myapplication.databind;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;

import com.example.myapplication.BR;
import com.example.myapplication.R;
import com.example.myapplication.aop.Trace;
import com.example.myapplication.aop.TraceParam;
import com.example.myapplication.databinding.ActivityDataBindingBinding;

/**
 * JetPack之DataBinding
 */
public class DataBindingActivity extends AppCompatActivity {

    private static final String TAG = "DataBindingActivity";
    private   User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingBinding dataBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        user = new User("CHANG", "12", "HANGZHOU");
        final ObservableUser observableUser = new ObservableUser("CJ", "ZHEJIANG", "HANGZHOU");
        dataBindingBinding.setUser(user); // 和xml里面的user同名
        dataBindingBinding.setObservableuser(observableUser);
        dataBindingBinding.tvSchool.setText("北京");

        dataBindingBinding.setEventListener(new EventListener()); // 与xml的eventListener一样

        /**
         *
         * 实现数据变化自动驱动 UI 刷新的方式有三种：BaseObservable、ObservableField、ObservableCollection
         */

        //1.通过BaseObservable更新
        dataBindingBinding.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 因为这里的setAge方法这是更新本字段，而setSchool没有做其他处理，所以这里的setSchool并不会更新school字段
                user.setAge(String.valueOf((int) (1 + Math.random() * (10 - 1 + 1))));
                user.setSchool("北京" + (int) (1 + Math.random() * (10 - 1 + 1)));
            }
        });

        dataBindingBinding.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 因为这里的setName方法是更新所有字段，虽然setSchool没有做其他处理，但是还是会更新到school，初步估计是有个延时吧，或者是监听机制
                user.setName("CHNAHE" + (int) (1 + Math.random() * (10 - 1 + 1)));
                user.setSchool("杭州" + (int) (1 + Math.random() * (10 - 1 + 1)));
            }
        });

        // 第一次注册监听
        user.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.d(TAG, "第一次onPropertyChanged: " + "更新了age");
            }
        });

        // 第二次注册监听
        user.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.age) {
                    Log.d(TAG, "第二次onPropertyChanged: " + "更新了age");
                } else if (propertyId == BR.name) {
                    Log.d(TAG, "第二次onPropertyChanged: " + "更新了name");
                } else if (propertyId == BR.school) {
                    Log.d(TAG, "第二次onPropertyChanged: " + "更新了school");
                }
            }
        });

        //2.通过ObservableField更新
        dataBindingBinding.bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                observableUser.getCity().set("上海" + (int) (1 + Math.random() * (10 - 1 + 1)));
                observableUser.getName().set("张三" + (int) (1 + Math.random() * (10 - 1 + 1)));
            }
        });

        //3.通过ObservableCollection更新(包括list与map);
        final ObservableMap<String, String> map = new ObservableArrayMap<>();
        map.put("张三", "北京");
        map.put("李四", "深圳");
        dataBindingBinding.setMap(map);
        dataBindingBinding.setKey("张三");

        final ObservableList<String> list = new ObservableArrayList<>();
        list.add("杭州");
        list.add("西安");
        dataBindingBinding.setList(list);
        dataBindingBinding.setIndex(1);

        dataBindingBinding.bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("张三", "杭州" + (int) (1 + Math.random() * (10 - 1 + 1)));
                list.set(1, "西安" + (int) (1 + Math.random() * (10 - 1 + 1)));
            }
        });

        testAop("我是String参数");
    }

    @Trace(traceId = "traceId",isBefore = true)
    private void testAop(@TraceParam String userId) {
        Log.e("zty", "-------执行testAop--------" + userId);
    }

    /**
     * dataBinding事件绑定
     */
    public class EventListener {
        public void onUserAgeClick(View view) {
            user.setAge(String.valueOf((int) (1 + Math.random() * (10 - 1 + 1))));
            Toast.makeText(DataBindingActivity.this, "点击了button并给age赋新值", Toast.LENGTH_SHORT).show();
        }
    }
}
