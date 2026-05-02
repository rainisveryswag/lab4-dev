package com.example.lab4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    private static final String TAG = "PULSE";

    public FragmentOne() {
        super(R.layout.fragment_one);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView textOne = view.findViewById(R.id.textOne);
        Button btnHello  = view.findViewById(R.id.btnHello);

        btnHello.setOnClickListener(v ->
            textOne.setText(">_ SIGNAL RECEIVED // rainisveryswag")
        );
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "PULSE fragment online");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "PULSE fragment suspended");
    }
}
