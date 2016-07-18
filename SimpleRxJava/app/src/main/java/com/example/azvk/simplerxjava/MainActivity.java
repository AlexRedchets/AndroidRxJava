package com.example.azvk.simplerxjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickJust(View view){

        //Emits simple string
        Observable<String> mObservable = Observable.just("Just operator used");
        Observer<String> mObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "ERROR: ", e);
            }

            @Override
            public void onNext(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        };
        Subscription mSubscription = mObservable.subscribe(mObserver);
        mSubscription.unsubscribe();
    }

    public void onClickFrom(View view){
        //Emits integer array
        Observable<Integer> mObservable = Observable.from(new Integer[]{1,8,6,7,3,9,2});
        mObservable.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.i(TAG, integer.toString());
            }
        });
    }

    public void onClickJastLambda(View view){
        Observable.just("Hello").
                subscribe(s -> System.out.println(s));
    }

    public void onClickMapLambda(View view){
        Observable.just("Just lambda")
                .map(s -> s + " + map")
                .subscribe(s -> Toast.makeText(this, s, Toast.LENGTH_SHORT).show());
    }
}
