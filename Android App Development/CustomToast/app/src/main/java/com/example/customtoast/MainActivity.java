package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomAlert();
            }
        });
    }

    private void showCustomAlert() {
        Context context = getApplicationContext();
        LayoutInflater inflater = getLayoutInflater();
        View toastRoot = inflater.inflate(R.layout.toast,null);
        Toast toast = new Toast(context);
        toast.setView(toastRoot);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

        Toast.makeText(context,"messge here",Toast.LENGTH_LONG).show();
    }
}