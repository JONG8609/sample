package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Layout;
import android.widget.LinearLayout;

import com.example.sample.Util.WorkerProcess;
import com.example.sample.databinding.ActivityMainBinding;
import com.example.sample.fragment.BatteryInFragment;
import com.example.sample.fragment.BatteryOutFragment;
import com.example.sample.fragment.EmergencyFragment;
import com.example.sample.fragment.MainFragment;
import com.example.sample.fragment.PaymentFragment;

public class MainActivity extends AppCompatActivity {

    private WorkerProcess workerProcess;
    private ActivityMainBinding binding;
    private BatteryInFragment batteryInFragment;
    private BatteryOutFragment batteryOutFragment;
    private EmergencyFragment emergencyFragment;
    private PaymentFragment paymentFragment;
    private MainFragment mainFragment;
    private FragmentManager fragmentManager;
    LinearLayout main_layout;
    public static int FRAGMENT_CHANGE = 1;
    //0 -> mainFragment, 1 -> paymentFragment, 2 -> batteryInFragment, 3 -> batteryOutFragment, 4 -> emergencyFragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workerProcess = new WorkerProcess();
        dataBinding();
        initialize();
        changeFragment();

    }



    private void initialize() {
        batteryInFragment = new BatteryInFragment();
        batteryOutFragment = new BatteryOutFragment();
        emergencyFragment = new EmergencyFragment();
        paymentFragment = new PaymentFragment();
        mainFragment = new MainFragment();
        fragmentManager = getSupportFragmentManager();
    }

    private void dataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        main_layout = binding.mainLayout;
    }
    private void changeFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(FRAGMENT_CHANGE == 0){
            transaction.replace(R.id.main_layout, mainFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else if(FRAGMENT_CHANGE == 1){
            transaction.replace(R.id.main_layout, paymentFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else if(FRAGMENT_CHANGE == 2){
            transaction.replace(R.id.main_layout, batteryInFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else if(FRAGMENT_CHANGE == 3){
            transaction.replace(R.id.main_layout, batteryOutFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else if(FRAGMENT_CHANGE == 4){
            transaction.replace(R.id.main_layout, emergencyFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

}