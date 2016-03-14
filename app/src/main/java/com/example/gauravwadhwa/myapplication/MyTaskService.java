package com.example.gauravwadhwa.myapplication;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by gauravwadhwa on 03/03/16.
 */
public class MyTaskService extends GcmTaskService {


    private int returnValue;

    @Override
    public void onInitializeTasks() {
        MainActivity.debug("Init called.... ");
        super.onInitializeTasks();
    }

    @Override
    public int onRunTask(TaskParams taskParams) {
        MainActivity.debug("Service started: " + taskParams);
        returnValue = GcmNetworkManager.RESULT_FAILURE;
        MainActivity.debug("return 1: " + returnValue);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Observable.just(1, 2)
                .delay(10, TimeUnit.SECONDS)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        MainActivity.debug("return 2: " + returnValue);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        returnValue = GcmNetworkManager.RESULT_SUCCESS;
                        countDownLatch.countDown();
                        MainActivity.debug("DONE COMPLETED");
                    }
                });
        MainActivity.debug("return 3: " + returnValue);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MainActivity.debug("done executing");

        return returnValue;
    }

}
