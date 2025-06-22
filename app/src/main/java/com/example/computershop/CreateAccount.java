package com.example.computershop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class CreateAccount extends AppCompatActivity {
    int color = Color.rgb(255, 1, 1);
    EditText firstName, emailAddressPhone, passwordNew, passwirdAgain;
    Button contsign, returntoPage, SingIn, Reg;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.create_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.reg), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        returntoPage = findViewById(R.id.returnToPage);
        SingIn = findViewById(R.id.singIn);
        Reg = findViewById(R.id.reg);
        contsign = findViewById(R.id.contsign);
        firstName = findViewById(R.id.name);
        emailAddressPhone = findViewById(R.id.email);
        passwordNew = findViewById(R.id.pas1n);
        returntoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateAccount.this, SignIn.class);
                startActivity(intent);
            }
        });
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstnameInput = firstName.getText().toString().trim();
                String emailphoneInput = emailAddressPhone.getText().toString().trim();
                String pass1Input = passwordNew.getText().toString().trim();
                String pass2Input = passwirdAgain.getText().toString().trim();
                if(isValuePassword(pass1Input, pass2Input) && isValueName(firstnameInput)
                && isValueEmailOrNumber(emailphoneInput)) {
                    Toast.makeText(CreateAccount.this, "Account has been created!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CreateAccount.this, ShopPage.class);
                    startActivity(intent);
                }
            }
        });
    }
    private boolean isValuePassword(String pass1, String pass2){
        if(TextUtils.isEmpty(pass1)){
            passwordNew.setHint("Put a password");
            passwirdAgain.setHintTextColor(color);
            Toast.makeText(CreateAccount.this, "Please, put a password in", Toast.LENGTH_SHORT).show();
            return false;}
        if(pass1.length()<8){
            Toast.makeText(CreateAccount.this, "Password is too short", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean isValueName(String fname){
        if(TextUtils.isEmpty(fname)){
            firstName.setHint("Needs a name");
            firstName.setHintTextColor(color);
            Toast.makeText(CreateAccount.this, "Please, put a name", Toast.LENGTH_SHORT).show();
            return false;}
        return true;
    }
    private boolean isValueEmailOrNumber(String input){
        if(TextUtils.isEmpty(input)){
            emailAddressPhone.setHint("Put your email address");
            emailAddressPhone.setHintTextColor(color);
            Toast.makeText(CreateAccount.this, "Put an email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (Patterns.EMAIL_ADDRESS.matcher(input).matches()) {
            return true;
        }
        emailAddressPhone.setHint("Incorrect email or phone format");
        emailAddressPhone.setHintTextColor(color);
        Toast.makeText(CreateAccount.this, "Incorrect email", Toast.LENGTH_SHORT).show();
        return false;
    }
}
