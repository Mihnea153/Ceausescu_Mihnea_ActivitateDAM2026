package com.example.secondaplication;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {
    private int pozitieDeEditat = -1;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etMp2 = findViewById(R.id.etMp2);
        CheckBox cbBalcon = findViewById(R.id.cbBalcon);
        Switch swAerConditionat = findViewById(R.id.swAerConditionat);
        RadioGroup rgIncalzire = findViewById(R.id.rgIncalzire);
        Button btnSalveaza = findViewById(R.id.btnSalveaza);

        Intent intent = getIntent();
        if (intent.hasExtra("cameraEditare")) {
            Camera cameraPrimita = intent.getParcelableExtra("cameraEditare");
            pozitieDeEditat = intent.getIntExtra("pozitieEditare", -1);

            if (cameraPrimita != null) {


                etMp2.setText(String.valueOf(cameraPrimita.getMp2()));
                cbBalcon.setChecked(cameraPrimita.getBalcon());


                btnSalveaza.setText("Modifica");
            }
        }


        btnSalveaza.setOnClickListener(v->{
            String textMp2 = etMp2.getText().toString();
            float mp2 = textMp2.isEmpty() ? 0f: Float.parseFloat(textMp2);
            boolean balcon = cbBalcon.isChecked();
            boolean aerConditionat = swAerConditionat.isChecked();

            int idSelectat =rgIncalzire.getCheckedRadioButtonId();
            RadioButton rbSelectat = findViewById(idSelectat);
            String incalzire = (rbSelectat != null) ? rbSelectat.getText().toString() : "Nementionat";

            Camera c = new Camera(mp2, balcon, aerConditionat, incalzire);
            Bundle bundle = new Bundle();
            bundle.putParcelable("CameraMea", c);

            Intent resultIntent = new Intent();

            if (pozitieDeEditat != -1) {

                resultIntent.putExtra("cameraModificata", c);
                resultIntent.putExtra("pozitieEditare", pozitieDeEditat);
            } else {

                resultIntent.putExtra("CameraMea", c);
            }

            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}


