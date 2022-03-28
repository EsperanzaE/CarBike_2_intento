package com.example.carbike2intento;

import static android.widget.CompoundButton.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    CheckBox checkBoxCoches;
    CheckBox checkBoxMotos;
    RadioGroup radioGroupCoches;
    RadioGroup radioGroupMotos;
    ArrayList<Object> arrayListVehiculos;
    ListView listaViewVehiculos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ondexamos el código Java al XML
        checkBoxCoches = findViewById(R.id.checkBoxCoches);
        checkBoxMotos = findViewById(R.id.checkBoxMotos);

        radioGroupCoches = findViewById(R.id.radioGroupCoches);
        radioGroupMotos = findViewById(R.id.radioGroupMotos);

        listaViewVehiculos = findViewById(R.id.listViewVehiculos);

        arrayListVehiculos = Controlador.llenarArray();

        checkBoxCoches.setOnCheckedChangeListener(this);
        checkBoxMotos.setOnCheckedChangeListener(this);

        Adaptador adaptador = new Adaptador(arrayListVehiculos, this);
        listaViewVehiculos.setAdapter(adaptador);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        arrayListVehiculos.clear();
        if (checkBoxMotos.isChecked() && checkBoxCoches.isChecked()) {
            arrayListVehiculos = Controlador.llenarConCochesYMotos();
        } else if (checkBoxCoches.isChecked()) {
            arrayListVehiculos = Controlador.llenarconCoches();
        } else {
            if (checkBoxMotos.isChecked()) {
                arrayListVehiculos = Controlador.llenarconMotos();
            }
        }
    }
}