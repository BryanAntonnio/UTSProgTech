package com.uc.utsprogtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.uc.utsprogtech.model.User;

public class AddUserActivity extends AppCompatActivity implements TextWatcher{

    TextInputLayout inputFName, inputAge, inputAddress;
    Button button_tambah;
    String fname, address, age;
    Toolbar toolbar;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser);
        inputFName = findViewById(R.id.input_fname);
        inputAge = findViewById(R.id.input_age);
        inputAddress = findViewById(R.id.input_address);
        button_tambah = findViewById(R.id.recyclerView);

        inputFName.getEditText().addTextChangedListener(this);
        inputAge.getEditText().addTextChangedListener(this);
        inputAddress.getEditText().addTextChangedListener(this);

        toolbar = findViewById(R.id.tooladd);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddUserActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        button_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(AddUserActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.loading_dialog);
                User user = new User(fname,age,address);
                SimpanData.dataUser.add(new AdapterUser(fname,age,address));
                Intent intent = new Intent(AddUserActivity.this, MainActivity.class);
                intent.putExtra("dataUser", user);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        fname = inputFName.getEditText().getText().toString().trim();
        age = inputAge.getEditText().getText().toString().trim();
        address = inputAddress.getEditText().getText().toString().trim();

        if (!fname.isEmpty() && !address.isEmpty() && !age.isEmpty()){
            button_tambah.setEnabled(true);
        }else{
            button_tambah.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public boolean doublebackToExitPressedOnce = false;
    @Override
    protected void onResume(){
        super.onResume();
        this.doublebackToExitPressedOnce = false;
    }

    @Override
    public void onBackPressed() {
        if (doublebackToExitPressedOnce) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(intent);
        }
        this.doublebackToExitPressedOnce = true;
        Toast.makeText(getApplicationContext(), "Press back once again to exit the apps!", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doublebackToExitPressedOnce = false;
            }
        }, 5000);
    }
}