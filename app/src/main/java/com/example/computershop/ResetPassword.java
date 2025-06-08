package com.example.computershop;

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

public class ResetPassword extends AppCompatActivity {
    int color = Color.rgb(255, 1, 1);
    Button continueB, returnToPreviousPage;
    EditText emailAdd, passNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.reset_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.resetPas), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        continueB = findViewById(R.id.contforgot);
        returnToPreviousPage = findViewById(R.id.returnacc);
        emailAdd = findViewById(R.id.enterEmail);
        passNew = findViewById(R.id.pasNew);
        returnToPreviousPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPassword.this, SignIn.class);
                startActivity(intent);
            }
        });
        continueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailinput= emailAdd.getText().toString().trim();
                String passinput= passNew.getText().toString().trim();
                if((isValueEmail(emailinput)) && (isValuePassword(passinput))){
                    Toast.makeText(ResetPassword.this, "Пароль изменён!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ResetPassword.this, ShopPage.class);
                    startActivity(intent);}
            }
        });
    }
    private boolean isValueEmail(String email){
        if(TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailAdd.setHint("Put your email address");
            emailAdd.setHintTextColor(color);
            Toast.makeText(ResetPassword.this, "Put an email address", Toast.LENGTH_SHORT).show();
            return false;}
        return true;
    }
    private boolean isValuePassword(String pass){
        EditText password = (EditText) findViewById(R.id.password);
        if(TextUtils.isEmpty(pass)){
            password.setHint("Put your password");
            password.setHintTextColor(color);
            Toast.makeText(ResetPassword.this, "Put correct password", Toast.LENGTH_SHORT).show();
            return false;}
        return true;
    }
}
