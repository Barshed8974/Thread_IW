package com.example.thread_1_we;

import android.os.Handler;
import android.os.Looper;

public class WorkerThread extends Thread {

    private Handler handler;

    @Override
    public void run() {
        super.run();
        Looper.prepare();// this will give you a message queue
        handler = new Handler(Looper.myLooper());// this is needed to manage the queue i.e to add the messages to the queue
        Looper.loop(); // to process the queue
    }

    public void addTaskToMessageQueue(Runnable task) {

        if (handler != null) {
            handler.post(task);
        }
    }
}
