package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnConfirm = (Button) findViewById(R.id.button);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String[] stack = getResources().getStringArray(R.array.steaks);
                Spinner sp = (Spinner) findViewById(R.id.spinner);
               // int index = sp.getSelectedItemPosition();//所選中的位置
               // Log.v("SelectedPosition", String.valueOf(index));
                TextView output = (TextView) findViewById(R.id.lblOutput);
               // output.setText("牛排要" + stack[index]);
                output.setText("牛排要" + sp.getSelectedItem().toString());
            }
        });
    }
}