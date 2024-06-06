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
    public String key_id2  = "id2";
    public String key_cpu2= "cpu2";
    public String key_ram2 = "ram2";
    public String key_gpu2 = "gpu2";

    public String key_id3  = "id3";
    public String key_cpu3 = "cpu3";
    public String key_ram3 = "ram3";
    public String key_gpu3 = "gpu3";


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

                saveData2();
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

    public void saveData2() {
        sharedPrefs = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        try {
            String id =  sharedPrefs.getString(key_id, "");
            String id2 = sharedPrefs.getString(key_id2, "");
            String id3 = sharedPrefs.getString(key_id3, "");

            if (id.isEmpty()) {
                editor.putString(key_id, pc_id.getText().toString());
                editor.putString(key_cpu, pc_cpu.getText().toString());
                editor.putString(key_ram, pc_ram.getText().toString());
                editor.putString(key_gpu, pc_gpu.getText().toString());
                editor.apply();

                Toast.makeText(this, pc_id.getText() + " saved!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActity_Home.class);
                startActivity(intent);

            } else if (!id.isEmpty() && id2.isEmpty()) {
                editor.putString(key_id2, pc_id.getText().toString());
                editor.putString(key_cpu2, pc_cpu.getText().toString());
                editor.putString(key_ram2, pc_ram.getText().toString());
                editor.putString(key_gpu2, pc_gpu.getText().toString());
                editor.apply();

                Toast.makeText(this, pc_id.getText() + " saved!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActity_Home.class);
                startActivity(intent);

            } else if (!id2.isEmpty()) {
                editor.putString(key_id3, pc_id.getText().toString());
                editor.putString(key_cpu3, pc_cpu.getText().toString());
                editor.putString(key_ram3, pc_ram.getText().toString());
                editor.putString(key_gpu3, pc_gpu.getText().toString());
                editor.apply();

                Toast.makeText(this, pc_id.getText() + " saved!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainActity_Home.class);
                startActivity(intent);

            } else {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}