package com.example.mobile_labs_20521247;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent animation_activity = new Intent(getApplicationContext(), AnimationActivity.class);
                startActivity(animation_activity);

                overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out);
            }
        });

    }
}
