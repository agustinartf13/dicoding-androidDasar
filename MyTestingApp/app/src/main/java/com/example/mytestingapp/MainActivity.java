package com.example.mytestingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSetValue;
    private TextView tvText;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetValue = findViewById(R.id.btn_set_value);

        tvText = findViewById(R.id.tv_text);
        btnSetValue.setOnClickListener(this);

        names = new ArrayList<>();
        names.add("Agustina Saputra");
        names.add("agustinasaputraa");

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_set_value) {
            StringBuilder name = new StringBuilder();
            for (int i = 0; i <= 1; i++) {
                name.append(names.get(i)).append("\n");
            }
            tvText.setText(name.toString());
        }
    }
}
