package com.e.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnFrag;
boolean status = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFrag =findViewById(R.id.btnFrag);
        btnFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                if(status){
                    FirstFragment firstFragment = new FirstFragment();
                    fragmentTransaction.replace(R.id.fragContainer,firstFragment);
                    fragmentTransaction.commit();
                    btnFrag.setText("go to second fragment");
                    status=false;
                }
                else {
                    SecondFragment secondFragment = new SecondFragment();
                    fragmentTransaction.replace(R.id.fragContainer, secondFragment);
                    fragmentTransaction.commit();
                    btnFrag.setText("go to first fragment");
                    status=true;
                }
            }
        });
    }
}
