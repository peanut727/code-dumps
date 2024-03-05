package com.example.inventory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnReg, btnhome;
    private EditText pc_cpu, pc_ram, pc_gpu, pc_id;
    SharedPreferences sharedPrefs;
    public static final String SHARED_PREFS_NAME = "myPref";
    public String key_id  = "id";
    public String key_cpu = "cpu";
    public String key_ram = "ram";
    public String key_gpu = "gpu";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pc_id   = findViewById(R.id.pcId);
        pc_cpu  = findViewById(R.id.pcCpu);
        pc_ram  = findViewById(R.id.pcRam);
        pc_gpu  = findViewById(R.id.pcGpu);
        btnReg  = findViewById(R.id.btnRegister);
        btnhome = findViewById(R.id.homeBtn);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               saveData();
            }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActity_Home.class);
                startActivity(intent);
            }
        });

    }

    // This is what saves the data
    public void saveData() {
        sharedPrefs = getSharedPreferences(SHARED_PREFS_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(key_id ,  pc_id.getText().toString());
        editor.putString(key_cpu, pc_cpu.getText().toString());
        editor.putString(key_ram, pc_ram.getText().toString());
        editor.putString(key_gpu, pc_gpu.getText().toString());
        editor.apply();

        Toast.makeText(this,"Data saved", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,MainActity_Home.class);
        startActivity(intent);
    }


}