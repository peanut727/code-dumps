package com.carating.moneygonee;

import static android.app.PendingIntent.getActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.carating.moneygonee.ui.incomeFragment;
import com.carating.moneygonee.ui.budgetsFragment;
import com.carating.moneygonee.ui.expenseFragment;
import com.carating.moneygonee.ui.dashboardFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView btv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btv = findViewById(R.id.bottomNavigationView);
        btv.setOnNavigationItemSelectedListener(this);
        btv.setSelectedItemId(R.id.dashboardbtv);
    }

    incomeFragment analFrag = new incomeFragment();
    budgetsFragment  budFrag  = new budgetsFragment();
    expenseFragment catFrag = new expenseFragment();
    dashboardFragment recFrag = new dashboardFragment();

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.dashboardbtv:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, recFrag)
                        .commit();
                return true;

            case R.id.incomebtv:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, analFrag)
                        .commit();
                return true;

            case R.id.expensesbtv:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, catFrag)
                        .commit();
                return true;
        }
        return false;
    }
}