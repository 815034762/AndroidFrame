package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.databind.User;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.demo.DemoActivity;
import com.example.myapplication.flutter.MyFlutterActivity;
import com.example.myapplication.viewmodel.ViewModelActivity;
import com.example.myapplication.viewmodel.vm.MainViewModel;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author ly-zhangty
 * 主页面
 */
public class MainActivity extends RxAppCompatActivity {

    ActivityMainBinding activityMainBinding;
    final ArrayList<User> userList = new ArrayList<>();
    // MainViewModel model = new MainViewModel(getApplication());
    int resIndex;
    int[] resIds = {R.mipmap.one, R.mipmap.ic_launcher, R.mipmap.two, R.mipmap.ic_launcher_round};
    BitmapFactory.Options options = new BitmapFactory.Options();
    ArrayList<Bitmap> list = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = 2;

        // 切换图片
        activityMainBinding.btnSwitchPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchImage();
            }
        });

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.addLast("10");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add("6");
        linkedList.add("7");

//      linkedList.clear();
        linkedList.poll(); // 检索第一个元素并删除
        linkedList.peek();// 仅仅检索第一个原因,它和getFirest的区别是，如果第一个peek第一个元素是null，那么就返回，而getFirst则是抛出nullPointer异常
        Log.e("zty", linkedList.peek() + "  " + linkedList.getFirst() + " <---> " + linkedList.getLast() + "   " + linkedList.get(0));

        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.put(1, "1");
        sparseArray.put(2, "2");
        Log.e("zty", "---sparseArray size----" + sparseArray.size());
        sparseArray.delete(1);
        // size操作会把
        Log.e("zty", "---sparseArray2 size----" + sparseArray.size());
//      sparseArray.clear();

        HashMap hashMap = new HashMap(1);
        String key = "a";
        hashMap.put(key, "测试2");
        hashMap.put(key, "测试3");
        hashMap.put(key, "测试4");
        hashMap.put(key, "测试5");
        hashMap.putIfAbsent(key, "测试1");
        int h = 0;
        int hash1 = (h = key.hashCode()) ^ (h >>> 16);
        int hash4 = (h = key.hashCode()) ^ (h >>> 16);
        int hash2 = (h = "a".hashCode()) ^ (h >>> 16);
        int hash3 = (h = "a".hashCode()) ^ (h >>> 16);
        Log.e("zty", hash1 + "    " + hash2 + "   " + hash3 + "    " + hash4 + "  " + hashMap.size() + " ---------------- " + hashMap.get(key));
//        HashSet hashSet;
//        startActivity();
//        DateUtils.getAA();
//        User user = new User();
//        for(int i = 0;i < 5; i++) {
////            user = new User();
//            user.setAge("18: " + i);
//            user.setName("ZhangTy: " + i);
//            user.setSchool("大学名称: " + i);
//            userList.add(user);
//        }
//        for (User user1 : userList) {
//            Log.e("tag", user1.getName() + "======userInfo is======" + user1.getAge() + "    " + user1.getSchool());
//        }
//
//        activityMainBinding.setMain(model);
//        model.content.set("设置字符串");
        startActivity();
//        activityMainBinding.iv01.setImageBitmap(getBitmap());
    }


    private void switchImage() {
        getBitmap();
//        activityMainBinding.iv01.setImageBitmap(getBitmap());
    }

    private Bitmap getBitmap() {
//      resIds[resIndex++ % 2]
//      if (resIndex > 3) {
//         resIndex = 0;
//      }
        String str = "";
        for(int i=0; i< 100; i++) {
            str += i;
        }
//      Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resIds[0], options);
        for (int i = 0; i < 10; i++) {
            TestBean testBean = new TestBean();
            testBean.setAddr("开始的发酵肯定是放假啊");
            byte[] bytes = new byte[100];
            testBean.setBytes(bytes);
//          Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), resIds[resIndex++ % 4], options);
//          list.add(bitmap2);
        }
        resIndex++;
        return null;
    }


    private void showTest() {

        for (int i = 0; i < 1; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    showToast();
//                    SystemClock.sleep(100);
                }
            }).start();
//            showToast();
        }
    }

    private void startActivity() {
        activityMainBinding.btDataBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyFlutterActivity.start(MainActivity.this);
//                showTest();
//                startActivity(new Intent(MainActivity.this, DataBindingActivity.class));
            }
        });

        activityMainBinding.btViewModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewModelActivity.class));
            }
        });

        activityMainBinding.btDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DemoActivity.class));
            }
        });
    }

    private void showToast() {
        if (Looper.myLooper() != getMainLooper()) {
            Looper.prepare();
        }
        Toast.makeText(MainActivity.this, "ToastTest", Toast.LENGTH_SHORT).show();
        if (Looper.myLooper() != getMainLooper()) {
            Looper.loop();
            Log.e("zty", "---------1111-------");
            Looper.myLooper().quit();
            Log.e("zty", "---------2222-------");
        }
    }

}