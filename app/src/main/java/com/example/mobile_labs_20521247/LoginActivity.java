package com.example.mobile_labs_20521247;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    Button btnGoToSignUp;
    Button btnLogin;
    String username,fullname,phone;
    EditText Password;
    SupportClass sp = new SupportClass();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnGoToSignUp = findViewById(R.id.btnGoToSignUp);
        btnLogin = findViewById(R.id.btnLogin);
        EditText ex = findViewById(R.id.etUsername);
        Password = findViewById(R.id.etPassword);

        btnGoToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child("users").child(ex.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Username or Password is incorrect",Toast.LENGTH_SHORT).show();
                            Log.e("firebase", "Error getting data", task.getException());
                        }
                        else {
                            Log.d("firebase", task.getResult().child("password").getValue().toString());


                            if(task.getResult().child("password").getValue().toString().equals(sp.PasswordHash(Password.getText().toString()))){
                                phone = task.getResult().child("phone").getValue().toString();
                                fullname = task.getResult().child("fullname").getValue().toString();
                                Toast.makeText(getApplicationContext(),"You have logged in",Toast.LENGTH_SHORT).show();
                                Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                finish();
                                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(intent);

                            }else{
                                Toast.makeText(getApplicationContext(),"Username or Password is incorrect",Toast.LENGTH_SHORT).show();

                            }

                        }
                    }
                });
            }
        });
    }
}
