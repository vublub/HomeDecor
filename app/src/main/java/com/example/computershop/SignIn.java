package com.example.computershop;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.computershop.Adapters.OfficeAdapter;
import com.example.computershop.Models.AuthResponse;
import com.example.computershop.Models.LoginRequest;
import com.example.computershop.Models.Product;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Pattern;


public class SignIn extends AppCompatActivity {
    TextInputLayout emailTextInput, passwordTextInputLayout;
    TextInputEditText emailedit, passwordedit;
    TextView createOne, resetPassword;
    Button continueB;
    int color = Color.rgb(255, 1, 1);
    @SuppressLint("MissingInflatedId")
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
        emailedit = findViewById(R.id.emailedit);
        passwordedit = findViewById(R.id.passwordedit);
        emailTextInput = findViewById(R.id.emailTextInput);
        passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout);
        createOne = findViewById(R.id.createOne);
        continueB = findViewById(R.id.contsign);
        resetPassword = findViewById(R.id.reset);
        continueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInput()){
                    String email = emailedit.getText().toString().trim();
                    String password = passwordedit.getText().toString();
                    loginUser(email, password);
                }
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
    private boolean validateInput() {

        String email = emailedit.getText().toString().trim();
        String password = passwordedit.getText().toString().trim();

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

 public void loginUser(String email, String password){
        Supabase supabase = new Supabase();
        LoginRequest loginRequest = new LoginRequest(password, email);
        supabase.login(loginRequest, new Supabase.SBC_Callback() {
            @Override
            public void onFailure(IOException e) {
                runOnUiThread(() -> {
                    Log.e("loginUser:onFailure", e.getLocalizedMessage());
                });
            }

            @Override
            public void onResponse(String responseBody) {
                runOnUiThread(() -> {
                    Log.e("loginUser:onResponse", responseBody);
                    Gson gson = new Gson();
                    AuthResponse auth = gson.fromJson(responseBody, AuthResponse.class);
                   DataBinding.saveBearerToken("Bearer " + auth.getAccess_token());
                   DataBinding.saveUuidUser(auth.getUser().getId());
                   startActivity(new Intent(getApplicationContext(), ShopList.class));
                   Log.e("loginUser:onResponse", auth.getUser().getId());
                });
            }
        });
 }
}
