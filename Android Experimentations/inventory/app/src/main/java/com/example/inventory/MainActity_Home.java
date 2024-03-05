package com.example.inventory;

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
    Button srchBtn;
    EditText textSearch;
    public String key_id  = "id";
    public String key_cpu = "cpu";
    public String key_ram = "ram";
    public String key_gpu = "gpu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_actity_home);

        shwID  = findViewById(R.id.tvID);
        shwCpu = findViewById(R.id.tvCpu);
        shwRam = findViewById(R.id.tvRam);
        shwGpu = findViewById(R.id.tvGpu);
        srchBtn = findViewById(R.id.showBtn);
        textSearch = findViewById(R.id.searchText);

        srchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //loadData();
                searchData();

            }
        });
    }

    public void loadData() {
        sharedPrefs = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);

        String id  = sharedPrefs.getString(key_id, null);
        String cpu = sharedPrefs.getString(key_cpu, null);
        String ram = sharedPrefs.getString(key_ram, null);
        String gpu = sharedPrefs.getString(key_gpu, null);

        if (id != null || cpu != null || ram != null || gpu != null) {
            shwID.setText(id);
            shwCpu.setText(cpu);
            shwRam.setText(ram);
            shwGpu.setText(gpu);
        }
    }

    public void searchData() {
        sharedPrefs = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);

        String id  = sharedPrefs.getString(key_id, null);
        String cpu = sharedPrefs.getString(key_cpu, null);
        String ram = sharedPrefs.getString(key_ram, null);
        String gpu = sharedPrefs.getString(key_gpu, null);

        String data = textSearch.getText().toString().trim();

        if (id != null && data.equals(id)) {
            shwID.setText(id);
            shwCpu.setText(cpu);
            shwRam.setText(ram);
            shwGpu.setText(gpu);
        } else {
            Toast.makeText(this, "Non-Existent", Toast.LENGTH_SHORT).show();
        }
    }
}