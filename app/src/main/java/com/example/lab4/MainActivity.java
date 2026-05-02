package com.example.lab4;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private Button btnPulse, btnStatic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPulse  = findViewById(R.id.btnFragment1);
        btnStatic = findViewById(R.id.btnFragment2);

        if (savedInstanceState == null) {
            replaceFragment(new FragmentOne(), false);
            setActiveButton(btnPulse);
        }

        btnPulse.setOnClickListener(v -> {
            replaceFragment(new FragmentOne(), true);
            setActiveButton(btnPulse);
        });

        btnStatic.setOnClickListener(v -> {
            replaceFragment(new FragmentTwo(), true);
            setActiveButton(btnStatic);
        });
    }

    private void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container, fragment);
        if (addToBackStack) ft.addToBackStack(null);
        ft.commit();
    }

    private void setActiveButton(Button active) {
        int cyan    = getColor(R.color.neon_cyan);
        int surface = getColor(R.color.void_surface);
        int black   = getColor(R.color.void_black);

        active.setBackgroundTintList(ColorStateList.valueOf(cyan));
        active.setTextColor(black);

        Button inactive = (active == btnPulse) ? btnStatic : btnPulse;
        inactive.setBackgroundTintList(ColorStateList.valueOf(surface));
        inactive.setTextColor(cyan);
    }
}
