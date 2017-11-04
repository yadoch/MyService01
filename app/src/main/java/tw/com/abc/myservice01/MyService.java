package tw.com.abc.myservice01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    private Timer timer;

    private int n=10;
    @Override
    public void onCreate() {
        super.onCreate();
        timer = new Timer();
        timer.schedule(new MyTask(),1000,0);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        n=intent.getIntExtra("n",n);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer != null){
            timer.cancel();
            timer.cancel();
            timer.purge();
        }
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }
    private class MyTask extends TimerTask{

        @Override
        public void run() {
            int rand = (int)(Math.random()*n);
            Log.i("geoff","rand:"+rand);
        }
    }
}
