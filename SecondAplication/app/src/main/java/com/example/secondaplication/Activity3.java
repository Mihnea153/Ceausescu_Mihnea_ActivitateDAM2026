package com.example.secondaplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


   public class Activity3 extends AppCompatActivity {



    private ArrayList<Camera> listaPrimita;
    private CameraAdapter adapter;

    private final ActivityResultLauncher<Intent> editLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Camera cameraModificata = result.getData().getParcelableExtra("cameraModificata");
                    int pozitie = result.getData().getIntExtra("pozitieEditare", -1);

                    if (cameraModificata != null && pozitie != -1) {
                        listaPrimita.set(pozitie, cameraModificata);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_3);

        ListView lvCamere = findViewById(R.id.lvCamere);


        listaPrimita = MainActivity.listaCamere;

        if (listaPrimita != null) {
            adapter = new CameraAdapter(this, listaPrimita);
            lvCamere.setAdapter(adapter);

            lvCamere.setOnItemClickListener((parent, view, position, id) -> {
                Camera cameraSelectata = listaPrimita.get(position);

                Intent intent = new Intent(Activity3.this, Activity2.class);
                intent.putExtra("cameraEditare", cameraSelectata);
                intent.putExtra("pozitieEditare", position);

                editLauncher.launch(intent);
            });


            lvCamere.setOnItemLongClickListener((parent, view, position, id) -> {
                listaPrimita.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            });
        }
    }
}