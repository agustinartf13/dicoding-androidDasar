package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        Button btn_move_act = findViewById(R.id.btn_move_act);
        btn_move_act.setOnClickListener(this);

        //
        Button btnMoveWithDataActivity = findViewById(R.id.btn_move_activity_data);
        btnMoveWithDataActivity.setOnClickListener(this);

        //
        Button btnMoveWithObject = findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);

        //
        Button btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);

        //
        Button btnForResult = findViewById(R.id.btn_move_for_result);
        btnForResult.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_act:
                Intent movepage = new Intent(MainActivity.this, MoveAct1.class);
                startActivity(movepage);
                break;
            case R.id.btn_move_activity_data:
                Intent moveDataIntent = new Intent(MainActivity.this, MoveWithDataAct.class);
                moveDataIntent.putExtra(MoveWithDataAct.EXTRA_NAME, "Agustina Saputra");
                moveDataIntent.putExtra(MoveWithDataAct.EXTRA_AGE, 22);
                startActivity(moveDataIntent);
                break;
            case R.id.btn_move_activity_object:
            Persona persona = new Persona();
                persona.setName("Agustina Saputra");
                persona.setAge(22);
                persona.setEmail("agustina@dicoding.com");
                persona.setCity("Bali");
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectAct.class);
                moveWithObjectIntent.putExtra(MoveWithObjectAct.EXTRA_PERSON, persona);
                startActivity(moveWithObjectIntent);
                break;
            case R.id.btn_dial_number:
                String phoneNumber = "082146640882";
                Intent dialPhoneNumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneNumber);
                break;
            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultAct.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultAct.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultAct.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}

