package com.example.mobile_labs_20521247;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity {

    Button backToLogin;
    Button btnSignUp;
    EditText FullName;
    EditText Phone;
    EditText Username;
    EditText Password;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSignUp = findViewById(R.id.btnSignUp);
        FullName = findViewById(R.id.etFullname);
        Phone = findViewById(R.id.etPhone);
        Username = findViewById(R.id.etUsername);
        Password = findViewById(R.id.etPassword);
        backToLogin = findViewById(R.id.btnBackToLogin);
        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(view.getContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = Phone.getText().toString();
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                String fullname = FullName.getText().toString();
                // Tạo một đối tượng User mới
                User user = new User(username, fullname,phone, password);
                SupportClass sp = new SupportClass();
                user.setPassword(sp.PasswordHash(password));
                databaseReference.child(user.getUsername()).setValue(user);
                Toast.makeText(getApplicationContext(),"Dang ki thanh cong", Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent(view.getContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }


}
