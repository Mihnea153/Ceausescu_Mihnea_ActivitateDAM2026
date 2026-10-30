package com.example.secondaplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_3);
        ListView lvCamere = findViewById(R.id.lvCamere);
        ArrayList<Camera> listaPrimita = getIntent().getParcelableArrayListExtra("listaCamere");
        if (listaPrimita != null) {
            ArrayAdapter<Camera> adapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    listaPrimita
            );
            lvCamere.setAdapter(adapter);
        }
    }
}