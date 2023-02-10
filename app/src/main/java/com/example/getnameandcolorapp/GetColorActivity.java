package com.example.getnameandcolorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class GetColorActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    View vShowColor;
    TextView tvError;
    Spinner spnRed, spnGreen, spnBlue;
    Button btnSend;
    String[] color = {"00", "10", "20", "30", "40", "50", "60",
            "70", "80", "90", "A0","B0", "C0","D0","E0","F0","FF"};
    private String color1, color2, color3, finalColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_color);

        vShowColor = findViewById(R.id.vShowColor);
        spnBlue = findViewById(R.id.spnBlue);
        spnGreen = findViewById(R.id.spnGreen);
        spnRed = findViewById(R.id.spnRed);
        btnSend = findViewById(R.id.btnSend);

        //Sæt spinner indhold (check om det er nødvendigt med 3 hvis muligt)
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, color);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnRed.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, color);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnGreen.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, color);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBlue.setAdapter(adapter3);

        spnRed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                color1 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spnGreen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                color2 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spnBlue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                color3 = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        btnSend.setOnClickListener(this);



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private void SetColor () {
        if (color1 != null && color2 != null && color3 != null) {
            finalColor = color1 + color2 + color3;
            vShowColor.setBackgroundColor(Integer.parseInt(finalColor));

        } else  { tvError.setText("Please pick 3 colors to generate"); }
    }

    @Override
    public void onClick(View v) {
        SetColor();
        //Thread.sleep(4000);
        //Finish();

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }


}