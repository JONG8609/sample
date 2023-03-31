package com.example.sample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText hello_et;
    TextView hello_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello_tv = findViewById(R.id.hellotv);
        hello_et = findViewById(R.id.hello_et);

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
                if (hello_et.getText().toString().equals("1")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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

                } else if (hello_et.getText().toString().equals("2")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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

                } else if (hello_et.getText().toString().equals("3")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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

        hello_et.addTextChangedListener(textWatcher);

    }


}