package com.example.toggleswitchimplementation;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.materialswitch.MaterialSwitch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialSwitch materialSwitch = findViewById(R.id.material_switch);
        TextView textView = findViewById(R.id.textView);

        materialSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textView.setText("Switch is ON");
                Toast.makeText(MainActivity.this, "Switch enabled", Toast.LENGTH_SHORT).show();
            } else {
                textView.setText("Switch is OFF");
                Toast.makeText(MainActivity.this, "Switch disabled", Toast.LENGTH_SHORT).show();
            }
        });
    }
}