package com.example.uebung11;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.widget.Toast;

public class ExampleService extends Service {

    private Looper serviceLooper;
    private ServiceHandler serviceHandler;

    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void onCreate() {
            HandlerThread thread = new HandlerThread("ServiceStartArguments",
                    Process.THREAD_PRIORITY_BACKGROUND);
            thread.start();
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            Toast.makeText(this,"service starting", Toast.LENGTH_SHORT).show();

            String personName = intent.getStringExtra(MainActivity.EXTRA_PERSON_NAME);

            Message msg = serviceHandler.obtainMessage();
            msg.arg1 = startId;
            Bundle bundle = msg.getData();
            bundle.putString(MainActivity.EXTRA_PERSON_NAME, personName);

            serviceHandler.sendMessage(msg);
            return START_STICKY;
        }

        public void onDestroy() {
            Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show();
        }

        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
    }
}

