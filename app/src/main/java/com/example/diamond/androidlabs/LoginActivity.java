package com.example.diamond.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;

public class LoginActivity extends Activity {

    protected static final String ACTIVITY_NAME = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.defaultEmail);
        String email = sp.getString(getString(R.string.savedEmail), defaultValue);
        final EditText loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginEmail.setText(email);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editr = sp.edit();
                editr.putString(getString(R.string.savedEmail), loginEmail.getText().toString());
                editr.commit();
                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }

}
