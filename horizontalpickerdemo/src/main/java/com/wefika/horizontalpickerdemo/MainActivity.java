package com.wefika.horizontalpickerdemo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.wefika.horizontalpicker.HorizontalPicker;

public class MainActivity extends AppCompatActivity implements HorizontalPicker.OnItemSelected, HorizontalPicker.OnItemClicked {

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

        HorizontalPicker picker = (HorizontalPicker) findViewById(R.id.picker);
        picker.setOnItemClickedListener(this);
        picker.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(int index)    {
        Toast.makeText(this, "Item selected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, "Item clicked", Toast.LENGTH_SHORT).show();
    }


}