package com.example.sample.fragment;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sample.R;
import com.example.sample.databinding.FragmentPaymentBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaymentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaymentFragment extends Fragment {

    private FragmentPaymentBinding binding;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PaymentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PaymentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PaymentFragment newInstance(String param1, String param2) {
        PaymentFragment fragment = new PaymentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentPaymentBinding.inflate(inflater, container, false);
          View view = binding.getRoot();
          EditText payment_et = view.findViewById(R.id.payment_et);


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
                if (payment_et.getText().toString().equals("1")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
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

                } else if (payment_et.getText().toString().equals("2")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
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

                } else if (payment_et.getText().toString().equals("3")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
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

        payment_et.addTextChangedListener(textWatcher);

        // Inflate the layout for this fragment
        return view;
    }
}