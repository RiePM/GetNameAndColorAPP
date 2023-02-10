package com.example.getnameandcolorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class GetNameActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
//Erklær elementer
RadioGroup radioBtnFamily;
Button btnSend;
TextView txtChecked;
EditText etName;
Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);
        //Find elementer
        radioBtnFamily = findViewById(R.id.radioBtnFamily);
        btnSend = findViewById(R.id.btnSend);
        txtChecked = findViewById(R.id.txtChecked);
        //Sæt eventhandlers
        radioBtnFamily.setOnCheckedChangeListener(this);
        btnSend.setOnClickListener(this);




    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        testChecked(checkedId);
    }

    @Override
    public void onClick(View v) {
        int checkedId = radioBtnFamily.getCheckedRadioButtonId();
        testChecked(checkedId);
        intent.putExtra("typeFromSecond", txtChecked.getText().toString() );
        intent.putExtra("nameFromSecond", etName.getText().toString() );
        setResult(Activity.RESULT_OK, intent);

        finish();
    }

    //@SuppressLint("SetTextI18n")
    private void testChecked (int checkedId)
    {
        switch(checkedId)
        {
            case R.id.rdbtnMother:
                txtChecked.setText("Mother's name");
                break;
            case R.id.rdbtnFather:
                txtChecked.setText("Father's name");
                break;
            case R.id.rdbtnCat:
                txtChecked.setText("Cat's name");
                break;
            case R.id.rdbtnDog:
                txtChecked.setText("Dog's name");
                break;

        }
    }

    @Override
    public void onBackPressed() {  // Eventhandler for standard Back-knap
        super.onBackPressed();
    }

}