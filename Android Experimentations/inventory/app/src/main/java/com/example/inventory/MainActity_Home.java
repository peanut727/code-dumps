package com.example.inventory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActity_Home extends AppCompatActivity {


    SharedPreferences sharedPrefs;
    public static final String SHARED_PREFS_NAME = "myPref";
    TextView shwID, shwCpu, shwRam, shwGpu;
    Button srchBtn, backBtn;
    EditText textSearch;
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
        setContentView(R.layout.activity_main_actity_home);

        shwID      = findViewById(R.id.tvID);
        shwCpu     = findViewById(R.id.tvCpu);
        shwRam     = findViewById(R.id.tvRam);
        shwGpu     = findViewById(R.id.tvGpu);
        srchBtn    = findViewById(R.id.showBtn);
        backBtn    = findViewById(R.id.bkButton);
        textSearch = findViewById(R.id.searchText);

        srchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchData();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActity_Home.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void searchData() {
        sharedPrefs = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);

        String[] keys    = {key_id, key_id2, key_id3};
        String[] cpuKeys = {key_cpu, key_cpu2, key_cpu3};
        String[] ramKeys = {key_ram, key_ram2, key_ram3};
        String[] gpuKeys = {key_gpu, key_gpu2, key_gpu3};

        String data = textSearch.getText().toString().trim();

        for (int i = 0; i < keys.length; i++) {
            String id =  sharedPrefs.getString(keys[i], null);
            String cpu = sharedPrefs.getString(cpuKeys[i], null);
            String ram = sharedPrefs.getString(ramKeys[i], null);
            String gpu = sharedPrefs.getString(gpuKeys[i], null);

            if (id != null && data.equals(id)) {
                shwID.setText(id);
                shwCpu.setText(cpu);
                shwRam.setText(ram);
                shwGpu.setText(gpu);
                return;
            }
        }
        Toast.makeText(this, "Non-Existent", Toast.LENGTH_SHORT).show();
    }
}