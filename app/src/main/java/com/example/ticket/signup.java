package com.example.ticket;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {

    private EditText editTextUserName, editTextEmailOrPhone, editTextCity, editTextPassword, editTextConfirmPassword;
    private Button buttonSignUp;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child("User Details");


        // Set Firebase Auth language code
        mAuth.setLanguageCode("en"); // Change to desired locale

        // Initialize views
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextEmailOrPhone = findViewById(R.id.editTextEmailOrPhone);
        editTextCity = findViewById(R.id.editTextCity);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        // Set OnClickListener for SignUp button
        buttonSignUp.setOnClickListener(view -> signUp());
    }

    private void signUp() {
        String userName = editTextUserName.getText().toString().trim();
        String emailOrPhone = editTextEmailOrPhone.getText().toString().trim();
        String city = editTextCity.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        // Perform validation
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(emailOrPhone)) {
            Toast.makeText(this, "Enter email or phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(city)) {
            Toast.makeText(this, "Enter city", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        // Obtain reCAPTCHA token
        obtainRecaptchaToken(new RecaptchaTokenCallback() {
            @Override
            public void onTokenReceived(String recaptchaToken) {
                if (!TextUtils.isEmpty(recaptchaToken)) {
                    createUserWithEmail(emailOrPhone, password, userName, city, recaptchaToken);
                } else {
                    Toast.makeText(signup.this, "Failed to get reCAPTCHA token", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void obtainRecaptchaToken(RecaptchaTokenCallback callback) {
        // Placeholder for reCAPTCHA verification logic
        String recaptchaToken = getRecaptchaToken();
        callback.onTokenReceived(recaptchaToken);
    }

    private String getRecaptchaToken() {
        // Placeholder method to simulate obtaining a reCAPTCHA token
        return "dummy-recaptcha-token"; // Replace with actual token
    }

    private void createUserWithEmail(String email, String password, String userName, String city, String recaptchaToken) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign up success
                            Toast.makeText(signup.this, "Sign up successful", Toast.LENGTH_SHORT).show();

                            // Get the user's unique ID (UID)
                            String userId = mAuth.getCurrentUser().getUid();

                            // Reference to the location in the Realtime Database where you want to store the user's information
                            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(userId);
                            mDatabase.child("text");

                            // Create a User object or simply a Map with the user's information
                            Map<String, Object> user = new HashMap<>();
                            user.put("username", userName);
                            user.put("emailOrPhone", email);
                            user.put("city", city);

                            // Write the user's information to the Realtime Database
                            userRef.setValue(user);
                        } else {
                            // If sign up fails, display a message to the user.
                            Toast.makeText(signup.this, "Sign up failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // Callback interface for obtaining reCAPTCHA token
    interface RecaptchaTokenCallback {
        void onTokenReceived(String recaptchaToken);
    }
}
