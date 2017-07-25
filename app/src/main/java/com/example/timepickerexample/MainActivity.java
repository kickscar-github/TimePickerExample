package com.example.timepickerexample;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TimePicker tp = (TimePicker) findViewById( R.id.timePicker );

        System.out.println( "------------>" + tp.is24HourView() );
        tp.setIs24HourView( true );

        //현재 시간 세팅
        Calendar calendar = Calendar.getInstance();
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ) {
            tp.setHour( calendar.get( Calendar.HOUR ) );
            tp.setMinute( calendar.get( Calendar.MINUTE ) );
        }


        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                ((TextView)findViewById( R.id.textview )).
                        setText( "[" + hourOfDay + ":" + minute + "]" );
            }
        });

        findViewById( R.id.button ).
                setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    int hour = tp.getHour();
                    int minutes = tp.getMinute();
                    Toast.
                            makeText( MainActivity.this,
                                      hour + ":" + minutes,
                                      Toast.LENGTH_SHORT ).
                            show();
                }
            }
        });
    }
}
