package com.example.fragmenttofragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnSendListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState !=null){
                return;
            }
        }*/

        MessageFragment msgFragment = new MessageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,msgFragment,null).commit();
    }

    @Override
    public void onSend(String str) {
        DisplayFragment displayFragment = new DisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message", str);
        displayFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,displayFragment,null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
