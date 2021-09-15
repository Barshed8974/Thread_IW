package com.example.thread_1_we;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    String T=MainActivity.class.getName();
    private WorkerThread workerThread;


    private Runnable taskone=new Runnable() {
        @Override
        public void run() {
            Log.d("TAG","Task One"+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException a)
            {
                a.printStackTrace();
            }
        }
    };
    private Runnable taskTwo=new Runnable() {
        @Override
        public void run() {
            Log.d("TAG","Task Two"+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException a)
            {
                a.printStackTrace();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        workerThread=new WorkerThread();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(taskone);
                workerThread.start();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToMessageQueue(taskTwo);
                workerThread.start();
            }
        });
    }

    private void initviews() {
        btn1=findViewById(R.id.tvData);
        btn2=findViewById(R.id.tvTask2);
    }
}
/*
    WHEN WE RUN ANY ANDROID APP ANDROID GIVES TWO THINGS-
     1) PROCESS( it is os level), 2)THREAD( this is called main/UI thread)

     @MAIN THREAD- is the first thread that starts running when you start your application
     @UI THREAD-   starts from Main Thread for Rendering user Interface

     THE OPERATIONS WHICH TAKES TIME SHOULDN'T BE RUN IN MAIN THREAD

     WHEN WE START A THREAD i.e. { Thread.start()} THE RUN METHOD STARTS EXECUTING

     WHEN WE DO AN UI OPERATION IN BACKGROUND, THEN IT WILL CRASH
     UI OPERATION SHOULD BE DONE IN MAIN THREAD

     TO RUN UI OPERATION FROM A BACKGROUND THREAD WE NEED TO CALL runOnUiThread() method

     WE CANNOT ONE THREAD MORE THAN ONCE, AND WHEN A THREAD COME OUT FROM RUN METHOD IT WILL
     DIE AUTOMATICALLY

 */