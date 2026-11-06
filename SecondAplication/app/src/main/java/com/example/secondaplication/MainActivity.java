package com.example.secondaplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Camera> listaCamere = new ArrayList<>();

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bundle bundle = result.getData().getExtras();
                    if (bundle != null) {
                        Camera cameraPrimita = bundle.getParcelable("CameraMea");
                        if (cameraPrimita != null) {


                            listaCamere.add(cameraPrimita);



                            Toast.makeText(this, cameraPrimita.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
    );



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

        Button btnAdauga = findViewById(R.id.btnAdauga);


        btnAdauga.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            launcher.launch(intent);

        });

        Button btnAdaugaAi = findViewById(R.id.btnAdaugaAi);

        btnAdaugaAi.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ActivityAi.class);
            launcher.launch(intent);
        });

        Button btnVL=findViewById(R.id.btnVL);

        btnVL.setOnClickListener(v->{
          Intent intent = new Intent (MainActivity.this, Activity3.class);
            intent.putParcelableArrayListExtra("listaCamere",listaCamere);
            startActivity(intent);

        });



    }
}