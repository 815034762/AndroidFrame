package com.example.myapplication.eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.eventbus.annotation.BindView;

/**
 * @author ly-zhangty
 */
public class EventBusActivity extends AppCompatActivity {

    @BindView(R.id.tv_content)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        MyButterKnife.bind(this);
        textView.setText("MyEventBus");
    }
}