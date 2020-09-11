package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectAct extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
        TextView tvObject = findViewById(R.id.tv_object_received);

        Persona persona = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : " + persona.getName() + ",\nEmail : " + persona.getEmail() + ",\nAge : " + persona.getAge() + ",\nLocation : " + persona.getCity();
        tvObject.setText(text);
    }
}
