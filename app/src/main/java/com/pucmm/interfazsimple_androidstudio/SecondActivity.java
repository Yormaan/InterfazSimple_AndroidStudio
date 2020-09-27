package com.pucmm.interfazsimple_androidstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView txtView_info;
    Button btn_newForm;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MainActivity.detailed_info);
        txtView_info = findViewById(R.id.txtView_info);
        btn_newForm = findViewById(R.id.btn_newForm);

        txtView_info.setText(message);
    }

    public void nuevoForm(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
