package com.example.chintan.myapplication;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.TaskStackBuilder;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;


import com.example.chintan.myapplication.ConnectionM.Connection;
import com.example.chintan.myapplication.Data.Location_;
import com.example.chintan.myapplication.Data.Offerlist;
import com.example.chintan.myapplication.Data.selectrange;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity implements  GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {


    private GoogleApiClient googleApiClient;
    private Location lastLocation;

    private LocationRequest locationRequest;

    private final int UPDATE_INTERVAL = 1000;
    private final int FASTEST_INTERVAL = 900;
    private final int REQ_PERMISSION = 999;


    ImageView btnoffer,btnregisteroffer,btnSearch,btnviewcategory;
    private PendingIntent pendingIntent;
    SharedPreferences sharedPreferences;


    ArrayList<String> nid,nname,nnotification;
    String n_name,n_notify;
    int resp;
    NumberPicker NP;

    public static final String KEY_TASK_DESC = "key_task_desc";
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createGoogleApi();


     /*   PeriodicWorkRequest.Builder periodicbuilder=new PeriodicWorkRequest.Builder(MyWorker.class, 10,TimeUnit.SECONDS);

        PeriodicWorkRequest myWork = periodicbuilder.build();

        WorkManager.getInstance().enqueue(myWork);*/


        btnoffer=findViewById(R.id.imageViewOffer);
        btnviewcategory=findViewById(R.id.imageViewCategory);
        btnregisteroffer=findViewById(R.id.imageViewRegister);
        btnSearch = findViewById(R.id.imageViewSearch);

       /* NP=findViewById(R.id.numberPicker1);
        NP.setMaxValue(10);
        NP.setMinValue(1);
        NP.setWrapSelectorWheel(false);
        NP.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                String range= (String.valueOf(newVal));
                selectrange.setRange(newVal);
            }
        });*/


        btnoffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ViewofferlistActivity.class);
                startActivity(intent);
            }
        });

        btnregisteroffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ViewExistingRegistrationActivity.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Search.class));
            }
        });


//        btnsetting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,Locationonoff.class);
//                startActivity(intent);
//            }
//        });

        btnviewcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,view_category.class);
                startActivity(intent);
            }
        });

    }




    private void createGoogleApi() {
        //Log.d(TAG, "createGoogleApi()");
        if (googleApiClient == null) {
            googleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
        googleApiClient.connect();
    }

    private boolean checkPermission() {
        // Ask for permission if it wasn't granted yet
        return (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED);
    }
    private void askPermission() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                REQ_PERMISSION
        );
    }

    @Override
    public void onLocationChanged(Location location) {
        //Log.d(TAG, "onLocationChanged ["+location+"]");
        lastLocation = location;

        double latitude = location.getLatitude();
        double longitude=location.getLongitude();

        Location_.setLatitude(latitude);
        Location_.setLongitude(longitude);
        //writeActualLocation(location);
    }
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        //Log.i(TAG, "onConnected()");
        getLastKnownLocation();
    }
    @Override
    public void onConnectionSuspended(int i) {
        //Log.w(TAG, "onConnectionSuspended()");
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        //Log.w(TAG, "onConnectionFailed()");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //Log.d(TAG, "onRequestPermissionsResult()");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQ_PERMISSION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
                    getLastKnownLocation();

                } else {
                    // Permission denied
                    Toast.makeText(MainActivity.this, "Failed !! \n Start GPS Service .....", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
    private void getLastKnownLocation() {
        //Log.d(TAG, "getLastKnownLocation()");
        if (checkPermission()) {
            lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
            if (lastLocation != null) {
                //Log.i(TAG, "LasKnown location. " +                        "Long: " + lastLocation.getLongitude() +                        " | Lat: " + lastLocation.getLatitude());
                //writeLastLocation();
                Location_.setLatitude(lastLocation.getLatitude());
                Location_.setLongitude(lastLocation.getLongitude());
                startLocationUpdates();
            } else {
                //Log.w(TAG, "No location retrieved yet");
                startLocationUpdates();
            }
        } else askPermission();
    }


    private void startLocationUpdates() {
        //Log.i(TAG, "startLocationUpdates()");
        locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(UPDATE_INTERVAL)
                .setFastestInterval(FASTEST_INTERVAL);

        if (checkPermission())
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }

    public void getnotification()
    {
        final Connection conn = new Connection();
        if (Connection.checkNetworkAvailable(MainActivity.this)) {


            Thread tthread = new Thread() {
                @Override
                public void run() {
                    try {
                        if (conn.getnotificationdata())
                        {
                            resp=0;

                        }
                        else
                        {
                            resp = 1;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            };
            tthread.start();
        } else {
            Toast.makeText(MainActivity.this,"Sorry no network access.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        try
        {
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.setting, menu);
            return true;
        }
        catch(Exception ex)
        {
            String msg=ex.getLocalizedMessage();
            return false;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        try {
            switch (item.getItemId())
            {
                case R.id.mrange:
                    set_range();
                    break;
              /*  case R.id.mnotif:
                    get_notification();
                    break;*/
                case R.id.mlogout:
                    logout();
                    break;
                default:
                    return super.onOptionsItemSelected(item);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public void logout() {
        new android.support.v7.app.AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.alert)
                .setTitle("Get Offers")
                .setMessage("Are you sure you want logout?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        sharedPreferences = getSharedPreferences(PreferencesClass.loginPref, 0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("logstatus","0");
                        editor.commit();
                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);

                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }
    public void set_range()
    {
        Intent intent=new Intent(MainActivity.this,setrangeActivity.class);
        startActivity(intent);

    }
    public void get_notification()
    {
        Intent intent=new Intent(MainActivity.this,Locationonoff.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed()
    {

    }
}
