package com.example.computershop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import com.example.computershop.Models.AuthResponse;
import com.example.computershop.Models.LoginRequest;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.regex.Pattern;

public class CreateAccount extends AppCompatActivity {
    int color = Color.rgb(255, 1, 1);

    TextInputLayout emailTextInput, passwordTextInputLayout;
    TextInputEditText emailedit, passwordedit;
    Button contsign, returntoPage, Reg;
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
        emailTextInput = findViewById(R.id.emailTextInput);
        passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout);
        emailedit = findViewById(R.id.emailedit);
        passwordedit = findViewById(R.id.passwordedit);
        Reg = findViewById(R.id.reg);
        contsign = findViewById(R.id.contsign);

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
                if (validateInput()) {
                    String email = emailedit.getText().toString().trim();
                    String password = passwordedit.getText().toString();
                   signupUser(password, email);
                }
            }
        });
    }
    private boolean validateInput() {
        String email = emailedit.getText().toString().trim();
        String password = passwordedit.getText().toString().trim();

        // Email Validation
        if (email.isEmpty()) {
            emailTextInput.setError("Email is required");
            return false;
        } else if (!isValidEmail(email)) {
            emailTextInput.setError("Invalid email address");
            return false;
        } else {
            emailTextInput.setError(null);
        }
        if (password.isEmpty()) {
            passwordTextInputLayout.setError("Password is required");
            return false;
        } else if (password.length() < 6) {
            passwordTextInputLayout.setError("Password must be at least 6 characters");
            return false;
        } else {
            passwordTextInputLayout.setError(null);
        }

        return true;
    }
    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }

    private void signupUser(String email,String password){
        Supabase supabaseClient = new Supabase();
        LoginRequest loginRequest = new LoginRequest(email,password);
        supabaseClient.registerUser(loginRequest, new Supabase.SBC_Callback() {
            @Override
            public void onFailure(IOException e) {
                runOnUiThread(() -> {
                    Log.e("signupUser:onFailure", e.getLocalizedMessage());
                });
            }
            @Override
            public void onResponse(String responseBody) {
                runOnUiThread(() -> {
                    Log.e("signupUser:onResponse", responseBody);
                    Gson gson = new Gson();
                    AuthResponse auth=gson.fromJson(responseBody, AuthResponse.class);
                    DataBinding.saveBearerToken("Bearer "+auth.getAccess_token());
                    DataBinding.saveUuidUser(auth.getUser().getId());
                    startActivity(new Intent(getApplicationContext(), ShopList.class));
                    Log.e("signupUser:onResponse", auth.getUser().getId());
                });
            }
        });
    }
}