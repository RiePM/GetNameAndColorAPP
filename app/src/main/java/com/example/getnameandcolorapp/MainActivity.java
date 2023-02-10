package com.example.getnameandcolorapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Erklær elementer
    ActivityResultLauncher<Intent> GetNameActivityLauncher;
    ActivityResultLauncher<Intent> GetColorActivityLauncher;
    TextView tvType, tvName;
    Button btnGetName, btnGetColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find elementer
        tvType = findViewById(R.id.tvType);
        tvName = findViewById(R.id.tvName);
        btnGetName = findViewById(R.id.btnGetName);
        //Sæt Intent (til at åbne ny aktivitet):
        GetNameActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == Activity.RESULT_OK)
                    {
                        Intent intent = result.getData();
                        String type = intent.getStringExtra("typeFromSecond");
                        tvType.setText(type);
                        String name = intent.getStringExtra("nameFromSecond");
                        tvName.setText(name);
                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
                    }
                }
        );
        //Sæt eventhandler til GetName:
        btnGetName.setOnClickListener(this);

/*        Intent thirdActivityIntent = new Intent(MainActivity.this, GetColorActivity.class);
        thirdActivityIntent.putExtra("Title", tvType +" Color");
        btnGetColor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(thirdActivityIntent);
            }
        });*/
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, GetNameActivity.class);
        //intent.putExtra("textFromCaller", text);
        GetNameActivityLauncher.launch(intent);
    }
}