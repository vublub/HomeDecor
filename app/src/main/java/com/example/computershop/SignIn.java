package com.example.computershop;

import android.app.Activity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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

import java.util.regex.Pattern;


public class SignIn extends AppCompatActivity {
    EditText emailAdrress, password;
    TextView createOne, resetPassword;
    Button continueB;
    int color = Color.rgb(255, 1, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.signin), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        emailAdrress = findViewById(R.id.emailAddressOrNumber);
        password = findViewById(R.id.password);
        createOne = findViewById(R.id.createOne);
        continueB = findViewById(R.id.contsign);
        resetPassword = findViewById(R.id.reset);
        continueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailphoneinput= emailAdrress.getText().toString().trim();
                String passinput= password.getText().toString().trim();
                if((isValueEmailOrNumber(emailphoneinput)) && (isValuePassword(passinput))){
                    Intent intent = new Intent(SignIn.this, ShopPage.class);
                    startActivity(intent);}
            }
        });
        createOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, CreateAccount.class);
                startActivity(intent);
            }
        });
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, ResetPassword.class);
                startActivity(intent);
            }
        });
    }
    private boolean isValueEmailOrNumber(String input){
        if(TextUtils.isEmpty(input)){
            emailAdrress.setHint("Put your email address or phone number");
            emailAdrress.setHintTextColor(color);
            Toast.makeText(SignIn.this, "Put an email address or phone number", Toast.LENGTH_SHORT).show();
            return false;
        }
        //Паттерн для проверки на номер телефона, можно настроить под нужный формат
        String phonePattern = "^(?:\\+7|8)\\s?\\(?\\d{3}\\)?\\s?\\d{3}[- ]?\\d{2}[- ]?\\d{2}$";
        // Проверка на email
        if (Patterns.EMAIL_ADDRESS.matcher(input).matches()) {
            return true;
        }
        //Проверка на телефон
        if(Pattern.compile(phonePattern).matcher(input).matches()){
            return true;
        }
        //Если не email и не телефон
        emailAdrress.setHint("Incorrect email or phone format");
        emailAdrress.setHintTextColor(color);
        Toast.makeText(SignIn.this, "Incorrect email or phone format", Toast.LENGTH_SHORT).show();
        return false;
    }
    private boolean isValuePassword(String pass){
        EditText password = (EditText) findViewById(R.id.password);
        if(TextUtils.isEmpty(pass)){
            password.setHint("Put your password");
            password.setHintTextColor(color);
            Toast.makeText(SignIn.this, "Put correct password", Toast.LENGTH_SHORT).show();
            return false;}
        return true;
    }
}
