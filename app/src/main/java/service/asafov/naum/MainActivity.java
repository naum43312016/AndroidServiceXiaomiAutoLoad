package service.asafov.naum;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Intent mServiceIntent;
    private SensorService mSensorService;
    Context ctx;

    public Context getCtx() {
        return ctx;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_main);
        /*mSensorService = new SensorService(getCtx());
        mServiceIntent = new Intent(getCtx(),mSensorService.getClass());
        if (!isMyServiceRunning(mSensorService.getClass())) {
            startService(mServiceIntent);
        }*/
        if (Build.BRAND.equalsIgnoreCase("xiaomi")) {//4tobi vizivalsya ontaskremoved nujno poprosit u polzovatelya na xiamio 4tobi on postavil nashe app v avtozapusk
            Log.i("MYTAG","xiaomi");
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
            startActivity(intent);
        }

        startService(new Intent(this,ServiceTest.class));
    }
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i ("isMyServiceRunning?", true+"");
                return true;
            }
        }
        Log.i ("isMyServiceRunning?", false+"");
        return false;
    }


    @Override
    protected void onDestroy() {
        /*stopService(mServiceIntent);
        Intent broadcastIntent = new Intent("service.asafov.naum.RestartSensor");
        sendBroadcast(broadcastIntent);*/
        Log.i("MAINACT", "onDestroy!");
        super.onDestroy();
        Log.d("des","after");
    }
}
