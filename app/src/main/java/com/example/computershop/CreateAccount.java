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

import java.util.regex.Pattern;

public class CreateAccount extends AppCompatActivity {
    int color = Color.rgb(255, 1, 1);
    EditText firstName, emailAddressPhone, passwordNew, passwirdAgain, postIndex, city, street, house;
    Button continueB, returntoPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.create_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.createAcc), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        returntoPage = findViewById(R.id.returnToPage);
        continueB = findViewById(R.id.contCreate);
        firstName = findViewById(R.id.name);
        emailAddressPhone = findViewById(R.id.email);
        passwordNew = findViewById(R.id.pas1n);
        passwirdAgain = findViewById(R.id.pas2n);
        postIndex = findViewById(R.id.postIndex);
        city = findViewById(R.id.city);
        street = findViewById(R.id.street);
        house = findViewById(R.id.house);
        returntoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateAccount.this, SignIn.class);
                startActivity(intent);
            }
        });
        continueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstnameInput = firstName.getText().toString().trim();
                String emailphoneInput = emailAddressPhone.getText().toString().trim();
                String pass1Input = passwordNew.getText().toString().trim();
                String pass2Input = passwirdAgain.getText().toString().trim();
                String postindexInput = postIndex.getText().toString().trim();
                String cityInput = city.getText().toString().trim();
                String streetInput = street.getText().toString().trim();
                String houseInput = house.getText().toString().trim();
                if(isValuePassword(pass1Input, pass2Input) && isValueName(firstnameInput, cityInput, streetInput, houseInput)
                && isValueEmailOrNumber(emailphoneInput) && isValidPostalCode(postindexInput)) {
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
        if(TextUtils.isEmpty(pass2)){
            passwirdAgain.setHint("Put a password");
            passwirdAgain.setHintTextColor(color);
            Toast.makeText(CreateAccount.this, "Please, put a password in", Toast.LENGTH_SHORT).show();
            return false;}
        if(!pass1.equals(pass2)){
            Toast.makeText(CreateAccount.this, "Passwords doesn't match", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean isValueName(String fname, String cityb, String streetb, String houseb){
        if(TextUtils.isEmpty(fname)){
            firstName.setHint("Needs a name");
            firstName.setHintTextColor(color);
            street.setHintTextColor(color);
            Toast.makeText(CreateAccount.this, "Please, put a name", Toast.LENGTH_SHORT).show();
            return false;}
        if(TextUtils.isEmpty(cityb)) {
            city.setHint("Needs a name of a city");
            city.setHintTextColor(color);
            Toast.makeText(CreateAccount.this, "Please, put a name of a city", Toast.LENGTH_SHORT).show();
            return false;}
        if(TextUtils.isEmpty(streetb)) {
            street.setHint("Needs a name of a street");
            street.setHintTextColor(color);
            Toast.makeText(CreateAccount.this, "Please, put a name of a street", Toast.LENGTH_SHORT).show();
            return false;}
        if(TextUtils.isEmpty(houseb)) {
            city.setHint("Needs a number of a house");
            city.setHintTextColor(color);
            Toast.makeText(CreateAccount.this, "Please, put a number of a house", Toast.LENGTH_SHORT).show();
            return false;}
        return true;
    }
    private boolean isValueEmailOrNumber(String input){
        if(TextUtils.isEmpty(input)){
            emailAddressPhone.setHint("Put your email address or phone number");
            emailAddressPhone.setHintTextColor(color);
            Toast.makeText(CreateAccount.this, "Put an email address or phone number", Toast.LENGTH_SHORT).show();
            return false;
        }
        String phonePattern = "^(?:\\+7|8)\\s?\\(?\\d{3}\\)?\\s?\\d{3}[- ]?\\d{2}[- ]?\\d{2}$";
        if (Patterns.EMAIL_ADDRESS.matcher(input).matches()) {
            return true;
        }
        if(Pattern.compile(phonePattern).matcher(input).matches()){
            return true;
        }
        emailAddressPhone.setHint("Incorrect email or phone format");
        emailAddressPhone.setHintTextColor(color);
        Toast.makeText(CreateAccount.this, "Incorrect email or phone format", Toast.LENGTH_SHORT).show();
        return false;
    }
    private boolean isValidPostalCode(String input){
        if(TextUtils.isEmpty(input)){
            Toast.makeText(CreateAccount.this, "Put post index", Toast.LENGTH_SHORT).show();
            return false;
        }
        String postalCodePattern = "^\\d{6}$";
        if(Pattern.compile(postalCodePattern).matcher(input).matches()){
            return true;
        }
        postIndex.setHint("Wrong format");
        postIndex.setHintTextColor(color);
        Toast.makeText(CreateAccount.this, "Wrong format of post index", Toast.LENGTH_SHORT).show();
        return false;
    }
}
