package service.asafov.naum;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SensorRestarterBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //Varian vizova service posle unitojeniya app iz taska est takje variant s pomowiy alarmanager v onTaskRemoved v service
        Log.i(SensorRestarterBroadcastReceiver.class.getSimpleName(), "Service Stops! Oooooooooooooppppssssss!!!!");
        context.startService(new Intent(context, ServiceTest.class));
       Log.d("Rece","receiver");
    }
}
