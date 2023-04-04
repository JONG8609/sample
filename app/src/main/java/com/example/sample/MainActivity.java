package com.example.sample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sample.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    EditText hello_et;
    TextView hello_tv;
    Button change_btn;
    String a = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBinding();
        hello_tv = binding.hellotv;
        hello_et = binding.helloEt;
        change_btn = binding.changeBtn;


//        a = MainActivity2.sample_et.getText().toString();

        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("key1", "1");
                intent.putExtra("key2", "2");
                intent.putExtra("key3", "3");
                startActivity(intent);
            }
        });

    }

    private void dataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }


}