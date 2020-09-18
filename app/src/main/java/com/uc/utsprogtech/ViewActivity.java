package com.uc.utsprogtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputLayout;

public class ViewActivity extends AppCompatActivity {

    TextInputLayout viewName, viewAge, viewAddress;
    ImageButton goEdit;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        viewName = findViewById(R.id.view_name);
        viewAge = findViewById(R.id.view_age);
        viewAddress = findViewById(R.id.view_address);

        toolbar = findViewById(R.id.toolview);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        goEdit = findViewById(R.id.viewYes);
        goEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}