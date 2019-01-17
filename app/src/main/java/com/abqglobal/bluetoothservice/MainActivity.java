package com.abqglobal.bluetoothservice;

import android.bluetooth.BluetoothAdapter;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        constraintLayout=findViewById(R.id.constraint);

        if(bluetoothAdapter.isEnabled())
        {
            Snackbar.make(constraintLayout,"Bluetooth on",15000)
                    .setAction("Turn Off?", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // turn BlueTooth off
                            bluetoothAdapter.disable();
                            Toast.makeText(MainActivity.this,
                                    "Bluetooth is off now!!", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
            }

            else
                {
                    Snackbar.make(constraintLayout,"Bluetooth off",15000)
                            .setAction("Turn on", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // turn on Bluetooth
                                    bluetoothAdapter.isEnabled();
                                    Toast.makeText(MainActivity.this, "Bluetooth is on now!!", Toast.LENGTH_SHORT).show();
                                }
                            }).show();
        }

    }
}
