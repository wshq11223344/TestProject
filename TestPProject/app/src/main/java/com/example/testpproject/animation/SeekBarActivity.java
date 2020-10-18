package com.example.testpproject.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testpproject.R;

public class SeekBarActivity extends AppCompatActivity {

    private SeekBar mSeekbar;
    private TextView mTextViewCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        mSeekbar = findViewById(R.id.seekbar_custom);
        mTextViewCurrent = findViewById(R.id.tv_current);
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTextViewCurrent.setText(progress + "/100");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SeekBarActivity.this, "startTrackingTouch", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SeekBarActivity.this, "stopTrackingTouch", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
