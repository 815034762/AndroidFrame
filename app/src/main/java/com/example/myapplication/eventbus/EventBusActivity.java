package com.example.myapplication.eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.eventbus.annotation.BindView;
import com.example.myapplication.eventbus.annotation.SetContentLayout;

/**
 * @author ly-zhangty
 */
@SetContentLayout(layout=R.layout.activity_event_bus)
public class EventBusActivity extends AppCompatActivity {

    @BindView(R.id.tv_content)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyButterKnife.bind(this);
        textView.setText("MyEventBus");
    }
}