package com.example.tripplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TripLegActivity extends AppCompatActivity {

    double total_time;
    EditText valed1;
    EditText valed2;
    double timeToNextRest;
    double restTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_leg);
        TextView valtv1= findViewById(R.id.tv1field);
        Intent intVal= this.getIntent();
        restTime= intVal.getDoubleExtra("restTime", 0.0);
        Log.d("restTime entered", String.valueOf(restTime));

        timeToNextRest= intVal.getDoubleExtra("timeToNextRest", 0.0);
        String res= "Rest time: "+ restTime+ " "+"Time to next rest "+timeToNextRest;
        valtv1.setText(res);
    }

    public void method2(View v)
    {

        valed1 = findViewById(R.id.ed1field);
        valed2= findViewById(R.id.ed2field);
        TextView tv2= findViewById(R.id.tv2fld);
        String value_speed_entered= valed1.getText().toString();
        double value_speed= Double.parseDouble(value_speed_entered);
        String value_distance_entered= valed2.getText().toString();
        double value_distance= Double.parseDouble(value_distance_entered);
        if(value_speed<0 ||value_distance < 0)
        {
            Toast.makeText(this, "Enter positive value for  speed and distance", Toast.LENGTH_LONG);
        }
        else {
            double baseTime = value_distance / value_speed;
            Log.d("baseTime value", String.valueOf(baseTime));
            int no_of_stops = (int) (baseTime / timeToNextRest);
            int time = (int) (no_of_stops * restTime);
            double total_time = time + baseTime;
            Log.d("Total time ", String.valueOf(total_time));
            Log.d("distance  is at end", String.valueOf(value_distance));

            Intent intent = new Intent();
            intent.putExtra("distance value", value_distance);
            intent.putExtra("total_time is", total_time);
            intent.putExtra("stops is", no_of_stops);
            setResult(0, intent);
            finish();
        }
    }

    public void method3(View v)
    {
        valed1 = findViewById(R.id.ed1field);
        valed2= findViewById(R.id.ed2field);
        valed1.setText("");
        Log.d("qqwer", valed1.getText().toString());
        valed2.setText("");
    }
}