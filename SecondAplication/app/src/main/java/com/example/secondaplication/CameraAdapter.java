package com.example.secondaplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CameraAdapter extends ArrayAdapter<Camera> {

    public CameraAdapter(Context context, ArrayList<Camera> camere) {
        super(context, 0, camere);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_camera, parent, false);
        }


        Camera camera = getItem(position);


        TextView tvTitlu = convertView.findViewById(R.id.tvTitluCamera);
        TextView tvDetalii = convertView.findViewById(R.id.tvDetaliiCamera);


        if (camera != null) {
            tvTitlu.setText("Suprafata: " + camera.getMp2() + " mp"); String detalii = "Balcon: " + (camera.getBalcon() ? "Da" : "Nu") +  " | AC: " + (camera.getAerConditionat() ? "Da" : "Nu") + " | Incalzire: " + camera.getIncalzire();tvDetalii.setText(detalii);
        }

        return convertView;
    }
}
