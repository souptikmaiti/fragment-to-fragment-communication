package com.example.fragmenttofragmentcommunication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MessageFragment extends Fragment {

    private EditText etMsg;
    private Button btnSend;
    OnSendListener onSendListener;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        etMsg = view.findViewById(R.id.etMsg);
        btnSend = view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = etMsg.getText().toString();
                onSendListener.onSend(msg);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            onSendListener = (OnSendListener) activity;  //we can typecast subclass to superclass
        } catch (ClassCastException e) {
            throw new ClassCastException(e.getMessage() + " onSend method not implemented in MainActivity");
        }
    }
}
