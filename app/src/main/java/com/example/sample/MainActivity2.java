package com.example.sample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sample.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    public EditText sample_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String value1 = intent.getStringExtra("key1");
        String value2 = intent.getStringExtra("key2");
        String value3 = intent.getStringExtra("key3");

        dataBinding();
        sample_et = binding.sampleEt;

        waitingPopup();

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                /*
                값에 의해 즉각적으로 다이얼로그가 뜨는지 테스트 하기위하여 1.2.3으로 if문 분기처리
                 */
                if (sample_et.getText().toString().equals(value1)) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                    builder.setMessage("Hello, world!"); // Set the message text

                    AlertDialog dialog = builder.create(); // Create the dialog object

                    Window dialogWindow = dialog.getWindow();

                    //다이얼로그 배경색 변경 부분 Color.원하는 색
                    dialogWindow.setBackgroundDrawable(new ColorDrawable(Color.YELLOW));

                    dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                        @Override
                        public void onShow(DialogInterface dialog) {
                            TextView messageTextView = ((AlertDialog) dialog).findViewById(android.R.id.message); // Get a reference to the message TextView
                            assert messageTextView != null;

                            //텍스트 size 변경 부분 단위 sp
                            messageTextView.setTextSize(40);

                            //텍스트 컬러 변경 부분 Color.원하는 컬러색
                            messageTextView.setTextColor(Color.BLACK);
                        }
                    });

                    dialog.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                        }
                    }, 1000);

                } else if (sample_et.getText().toString().equals(value2)) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                    builder.setMessage("Hello, world!"); // Set the message text

                    AlertDialog dialog = builder.create(); // Create the dialog object

                    Window dialogWindow = dialog.getWindow();
                    dialogWindow.setBackgroundDrawable(new ColorDrawable(Color.YELLOW));

                    dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                        @Override
                        public void onShow(DialogInterface dialog) {
                            TextView messageTextView = ((AlertDialog) dialog).findViewById(android.R.id.message); // Get a reference to the message TextView
                            assert messageTextView != null;
                            messageTextView.setTextSize(40); // Change the text size to 24sp
                            messageTextView.setTextColor(Color.RED);
                        }
                    });

                    dialog.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                        }
                    }, 1000);

                } else if (sample_et.getText().toString().equals(value3)) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                    builder.setMessage("Hello, world!"); // Set the message text

                    AlertDialog dialog = builder.create(); // Create the dialog object

                    Window dialogWindow = dialog.getWindow();
                    dialogWindow.setBackgroundDrawable(new ColorDrawable(Color.YELLOW));

                    dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                        @Override
                        public void onShow(DialogInterface dialog) {
                            TextView messageTextView = ((AlertDialog) dialog).findViewById(android.R.id.message); // Get a reference to the message TextView
                            assert messageTextView != null;
                            messageTextView.setTextSize(40);
                            messageTextView.setTextColor(Color.BLUE);
                        }
                    });

                    dialog.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dialog.dismiss();
                        }
                    }, 1000);

                }
            }
        };

        sample_et.addTextChangedListener(textWatcher);
    }

    private void waitingPopup(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
        builder.setMessage("NFC를 태깅 해주세요."); // Set the message text

        AlertDialog dialog = builder.create();
        dialog.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 2000);
    }

    private void dataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
    }
}