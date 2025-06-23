package com.example.computershop;

import androidx.annotation.NonNull;

import com.example.computershop.Models.LoginRequest;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Supabase {
    public interface SBC_Callback{
        public void onFailure(IOException e);
        public void onResponse(String responseBody);
    }
    OkHttpClient client=new OkHttpClient();
    public static String DOMAIN_NAME="https://uzlmkofcyywierqzefku.supabase.co/";
    public static String REST_PATH="rest/v1/";
    public static String AUTH_PATH="auth/v1/";
    public static String API_KEY="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InV6bG1rb2ZjeXl3aWVycXplZmt1Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDkwMzM1MTIsImV4cCI6MjA2NDYwOTUxMn0.gPcsdQZwJqHSbJ01F8oLpRiMuYENNcnlxKRPiPwSXk0";
    public static String BEARER_TOKEN="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InV6bG1rb2ZjeXl3aWVycXplZmt1Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDkwMzM1MTIsImV4cCI6MjA2NDYwOTUxMn0.gPcsdQZwJqHSbJ01F8oLpRiMuYENNcnlxKRPiPwSXk0";
 public void fetchAllProduct(final SBC_Callback callback){
     Request request = new Request.Builder()
             .url(DOMAIN_NAME + REST_PATH+ "Products?select=*")
             .addHeader("apikey", API_KEY)
             .addHeader("Authorization", BEARER_TOKEN )
             .build();
     client.newCall(request).enqueue(new Callback() {
         @Override
         public void onFailure(@NonNull Call call, @NonNull IOException e) {
             callback.onFailure(e);
         }
         @Override
         public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
             if (response.isSuccessful()){
                 String responseBody = response.body().string();
                 callback.onResponse(responseBody);
             }
             else{
                 callback.onFailure(new IOException("Ошибка сервера: " + response));
             }
         }
     });
    }
    public void fetchKitchen(final SBC_Callback callback){
        Request request = new Request.Builder()
                .url(DOMAIN_NAME + REST_PATH+ "Products?select=*&category_id=eq.1")
                .addHeader("apikey", API_KEY)
                .addHeader("Authorization", BEARER_TOKEN )
                .addHeader("Range", "0-9")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailure(e);
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String responseBody = response.body().string();
                    callback.onResponse(responseBody);
                }
                else{
                    callback.onFailure(new IOException("Ошибка сервера: " + response));
                }
            }
        });
    }

    public void fetchLivingroom(final SBC_Callback callback){
        Request request = new Request.Builder()
                .url(DOMAIN_NAME + REST_PATH+ "Products?select=*&category_id=eq.2")
                .addHeader("apikey", API_KEY)
                .addHeader("Authorization", BEARER_TOKEN )
                .addHeader("Range", "0-9")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailure(e);
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String responseBody = response.body().string();
                    callback.onResponse(responseBody);
                }
                else{
                    callback.onFailure(new IOException("Ошибка сервера: " + response));
                }
            }
        });
    }

    public void fetchBedroom(final SBC_Callback callback){
        Request request = new Request.Builder()
                .url(DOMAIN_NAME + REST_PATH+ "Products?select=*&category_id=eq.3")
                .addHeader("apikey", API_KEY)
                .addHeader("Authorization", BEARER_TOKEN )
                .addHeader("Range", "0-9")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailure(e);
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String responseBody = response.body().string();
                    callback.onResponse(responseBody);
                }
                else{
                    callback.onFailure(new IOException("Ошибка сервера: " + response));
                }
            }
        });
    }
    public void fetchBathroom(final SBC_Callback callback){
        Request request = new Request.Builder()
                .url(DOMAIN_NAME + REST_PATH+ "Products?select=*&category_id=eq.4")
                .addHeader("apikey", API_KEY)
                .addHeader("Authorization", BEARER_TOKEN )
                .addHeader("Range", "0-9")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailure(e);
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String responseBody = response.body().string();
                    callback.onResponse(responseBody);
                }
                else{
                    callback.onFailure(new IOException("Ошибка сервера: " + response));
                }
            }
        });}

    public void fetchOffice(final SBC_Callback callback){
        Request request = new Request.Builder()
                .url(DOMAIN_NAME + REST_PATH+ "Products?select=*&category_id=eq.5")
                .addHeader("apikey", API_KEY)
                .addHeader("Authorization", BEARER_TOKEN )
                .addHeader("Range", "0-9")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailure(e);
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String responseBody = response.body().string();
                    callback.onResponse(responseBody);
                }
                else{
                    callback.onFailure(new IOException("Ошибка сервера: " + response));
                }
            }
        });
 }

    public void fetchDiningroom(final SBC_Callback callback){
        Request request = new Request.Builder()
                .url(DOMAIN_NAME + REST_PATH+ "Products?select=*&category_id=eq.6")
                .addHeader("apikey", API_KEY)
                .addHeader("Authorization", BEARER_TOKEN )
                .addHeader("Range", "0-9")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailure(e);
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String responseBody = response.body().string();
                    callback.onResponse(responseBody);
                }
                else{
                    callback.onFailure(new IOException("Ошибка сервера: " + response));
                }
            }
        });
    }
    public void fetchDecor(final SBC_Callback callback){
        Request request = new Request.Builder()
                .url(DOMAIN_NAME + REST_PATH+ "Products?select=*&category_id=eq.7")
                .addHeader("apikey", API_KEY)
                .addHeader("Authorization", BEARER_TOKEN )
                .addHeader("Range", "0-9")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailure(e);
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String responseBody = response.body().string();
                    callback.onResponse(responseBody);
                }
                else{
                    callback.onFailure(new IOException("Ошибка сервера: " + response));
                }
            }
        });
    }
    public void login(LoginRequest loginRequest, final SBC_Callback callback){
        MediaType mediaType = MediaType.parse("application/json");
       Gson gson = new Gson();
       String json = gson.toJson(loginRequest);
       RequestBody body = RequestBody.create(json, mediaType);
        Request request = new Request.Builder()
                .url(DOMAIN_NAME + AUTH_PATH + "token?grant_type=password")
                .method("POST", body)
                .addHeader("apikey", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InV6bG1rb2ZjeXl3aWVycXplZmt1Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDkwMzM1MTIsImV4cCI6MjA2NDYwOTUxMn0.gPcsdQZwJqHSbJ01F8oLpRiMuYENNcnlxKRPiPwSXk0")
                .addHeader("Content-Type", "application/json")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailure(e);
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String responseBody = response.body().string();
                    callback.onResponse(responseBody);
                }
                else{
                    callback.onFailure(new IOException("Ошибка сервера: " + response));
                }
            }
        });
    }
}
