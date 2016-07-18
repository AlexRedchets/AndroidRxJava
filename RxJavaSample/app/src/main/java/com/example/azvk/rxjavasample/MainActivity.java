package com.example.azvk.rxjavasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import rx.Observable;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Observable.just("WTF is RxJava")
                .map(s -> s.hashCode())
                .map(i -> Integer.toString(i))
                .subscribe(s -> Toast.makeText(this, s, Toast.LENGTH_SHORT).show());
    }
}
