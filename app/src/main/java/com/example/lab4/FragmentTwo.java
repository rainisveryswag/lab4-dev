package com.example.lab4;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {

    private static final String KEY_PROGRESS = "freq_progress";
    private int progress = 0;

    public FragmentTwo() {
        super(R.layout.fragment_two);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextView tvValue = view.findViewById(R.id.tvValue);
        SeekBar  seekBar = view.findViewById(R.id.seekBar);

        if (savedInstanceState != null) {
            progress = savedInstanceState.getInt(KEY_PROGRESS, 0);
            seekBar.setProgress(progress);
            tvValue.setText("FREQ: " + progress);
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar s, int p, boolean fromUser) {
                progress = p;
                tvValue.setText("FREQ: " + p);
            }
            @Override public void onStartTrackingTouch(SeekBar s) {}
            @Override public void onStopTrackingTouch(SeekBar s) {}
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_PROGRESS, progress);
    }
}
