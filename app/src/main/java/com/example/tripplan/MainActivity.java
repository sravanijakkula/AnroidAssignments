package com.example.tripplan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double leg = 0.0;
    private double totalTime = 0.0;
    private double totalDistance = 0.0;
    private double restTime = 10.0;
    private double timeToNextRest = 85.0;
    double total_distance_value;
    double vaalueof_total_time;
    int valuecount=0;
    double valuedist=0.0;
    double valuet=0.0;
    String leg_value="";
    String res1="";
    int stopsval;


    TextView tv1val;
    TextView tv2val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null)
        {
            leg= savedInstanceState.getDouble("leg");
            totalTime= savedInstanceState.getDouble("totalTime");
            totalDistance= savedInstanceState.getDouble("totalDistance");
            restTime= savedInstanceState.getDouble("restTime");
            timeToNextRest= savedInstanceState.getDouble("timeToNextRest");
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putDouble("leg value", 0.0);
        outState.putDouble("totalTime value", 0.0);
        outState.putDouble("totalDistance value", 0.0);
        outState.putDouble("restTime value", 10.0);
        outState.putDouble("timeToNextRest value", 85.0);
        super.onSaveInstanceState(outState);

    }

    public void method1(View view) {
        Intent intent = new Intent(this, TripLegActivity.class);
        intent.putExtra("restTime value", restTime);
        intent.putExtra("timeToNextRest value", timeToNextRest);
        startActivityForResult(intent, 1);
    }
    public void reset(View view)
    {
        leg=0.0;
        totalTime=0.0;
        totalDistance=0.0;
        restTime=10.0;
        timeToNextRest=85.0;
        tv1val= findViewById(R.id.tv1field);
        tv2val= findViewById(R.id.tv2fld);
        valuecount=0;
        total_distance_value=0.0;
        vaalueof_total_time=0.0;
        valuedist=0.0;
        valuet=0.0;
        stopsval=0;


        String res= "Summary: Total Distance "+ totalDistance+" Total Time: "+totalTime;
        tv1val.setText(res);
        tv2val.setText("");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==0)
        {
            valuecount++;
            total_distance_value= data.getDoubleExtra("distance", 0.0);
            vaalueof_total_time = data.getDoubleExtra("total_time", 0.0);
            stopsval = data.getIntExtra("stops", 0);
            valuedist= valuedist+total_distance_value;
            valuet= valuet+ vaalueof_total_time;

            leg_value= "Leg "+valuecount+" has distance "+total_distance_value+" and time "+vaalueof_total_time +" no of stops is "+stopsval+"\n";
            res1= "Summary: Total Distance "+ valuedist+" Total Time: "+valuet;
            tv1val= findViewById(R.id.tv1field);
            tv1val.setText(res1);
            tv2val= findViewById(R.id.tv2fld);
            tv2val.append(leg_value);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}