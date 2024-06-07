package com.example.explicitintentdemo2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView output;

    ActivityResultLauncher launcher = registerForActivityResult(new ResultContract(),
            new ActivityResultCallback<String>() {
                @Override
                public void onActivityResult(String o) {
                    output.setText("計算結果"+o);
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output =(TextView) findViewById(R.id.lblOutput);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher.launch(true);
            }
        });
    }
    class ResultContract extends ActivityResultContract<Boolean, String>{

        @NonNull
        @Override
        public Intent createIntent(@NonNull Context context, Boolean aBoolean) {
            Intent intent = new Intent(MainActivity.this, OpActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("OPERAND01",((EditText) findViewById(R.id.txtOpd1)).getText().toString());
            bundle.putString("OPERAND02",((EditText) findViewById(R.id.txtOpd2)).getText().toString());
            intent.putExtras(bundle);
            return intent;
        }

        @Override
        public String parseResult(int i, @Nullable Intent intent) {
            Bundle bundle = intent.getExtras();
            Double result = bundle.getDouble("RESULT");
            return result.toString();
        }
    }
}
