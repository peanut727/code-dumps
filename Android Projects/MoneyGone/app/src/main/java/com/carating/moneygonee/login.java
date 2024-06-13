package com.carating.moneygonee;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class login extends AppCompatActivity {

    Button loginBtnn;
    TextView signActView;
    EditText email,password;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginBtnn = findViewById(R.id.loginBtn);
        signActView = findViewById(R.id.signInAct);
        email = findViewById(R.id.emailTB);
        password = findViewById(R.id.passTB);
        mAuth = FirebaseAuth.getInstance();

        signActView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), register.class);
                startActivity(intent);
                finish();
            }
        });

        loginBtnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail, pass;
                mail = String.valueOf(email.getText());
                pass = String.valueOf(password.getText());

                if (TextUtils.isEmpty(mail)) {
                    Toast.makeText(login.this, "Email can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(login.this, "Password can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    mAuth.signInWithEmailAndPassword(mail, pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(login.this, "Login Successful!",Toast.LENGTH_SHORT).show();
                                        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(mainIntent);
                                        finish();
                                    } else {
                                        Toast.makeText(login.this, "Login Failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                } catch (Exception ex) {
                    email.setText(ex.toString());
                }

            }
        });

    }
}