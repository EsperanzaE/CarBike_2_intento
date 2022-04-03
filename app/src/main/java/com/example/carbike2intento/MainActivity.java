package com.example.carbike2intento;

import static android.widget.CompoundButton.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener {
    CheckBox checkBoxCoches;
    CheckBox checkBoxMotos;
    RadioGroup radioGroupCoches;
    RadioGroup radioGroupMotos;
    ArrayList<Object> arrayListVehiculos;
    ListView listaViewVehiculos;
    //estas variables las llenaré en el escuchador de los radiogroup
    public static int layoutParaCoches = 0;
    public static int layoutParaMotos = 0;
    //para saber como tengo que llenar mi array de vehiculos
    boolean llenoConCoches;
    boolean llenoConMotos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("on Create", "entro");

        //ondexamos el código Java al XML
        checkBoxCoches = findViewById(R.id.checkBoxCoches);
        checkBoxMotos = findViewById(R.id.checkBoxMotos);

        radioGroupCoches = findViewById(R.id.radioGroupCoches);
        radioGroupMotos = findViewById(R.id.radioGroupMotos);

        listaViewVehiculos = findViewById(R.id.listViewVehiculos);

//lleno al principio la pantalla con los datos de todos lo coches
        arrayListVehiculos = Controlador.llenarConCochesYMotos();
        layoutParaMotos = R.layout.bike_row_left;
        layoutParaCoches = R.layout.car_row_left;
        Adaptador adaptador = new Adaptador(arrayListVehiculos, this, layoutParaMotos,
                layoutParaCoches);
        listaViewVehiculos.setAdapter(adaptador);
//con los checkBoxes controlo si la lista la lleno de coches, de motos o con los dos
// dentro del escuchador es cuando llamo al adaptador
        checkBoxCoches.setOnCheckedChangeListener(this);
        checkBoxMotos.setOnCheckedChangeListener(this);
//con los radioButtons controlo los layout de la lista

        radioGroupCoches.setOnCheckedChangeListener(this);
        radioGroupMotos.setOnCheckedChangeListener(this);
    }

    @Override
    //es el escuchador para los checkbuttons. Pueden marcarse uno o los dos y por cada "toque"
    //se entraría aquí. Compoundbutton te va a decir el boton que se ha marcado, puedes saberlo
    //por el getId o pregutando directamente si la variable donde en el onCreate se ha guardado
    //el id de los botones: checkBoxCoches = findViewById(R.id.checkBoxCoches);
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        Log.i("on ChekedChanged", "entro");

        arrayListVehiculos.clear();
        if (compoundButton.getId() == R.id.checkBoxCoches)
            if (compoundButton.isChecked()) {
                llenoConCoches = true;
            } else {
                llenoConCoches = false;
            }
        if (compoundButton.getId() == R.id.checkBoxMotos) {
            if (compoundButton.isChecked()) {
                llenoConMotos = true;
            } else {
                llenoConMotos = false;
            }
        }

        //una vez que sé si ha pulsado uno de los dos checkbox o los dos, lleno el arrayList
        if (llenoConCoches && llenoConMotos) {
            arrayListVehiculos = Controlador.llenarConCochesYMotos();
        } else {
            if (llenoConCoches) {
                arrayListVehiculos = Controlador.llenarconCoches();
            } else {
                if (llenoConMotos) {
                    arrayListVehiculos = Controlador.llenarconMotos();
                }
            }
        }
        /*
               if (checkBoxMotos.isChecked() && checkBoxCoches.isChecked()) {
            arrayListVehiculos = Controlador.llenarConCochesYMotos();
        } else if (checkBoxCoches.isChecked()) {
            arrayListVehiculos = Controlador.llenarconCoches();
        } else {
            if (checkBoxMotos.isChecked()) {
                arrayListVehiculos = Controlador.llenarconMotos();
            }
        }*/
            radioGroupCoches.check(R.id.radioGroupCoches);
            radioGroupMotos.check(R.id.radioGroupMotos);
    }

    //en el radigroup tiene el Id del bton que se ha pulsado, en "int i" va a indicar
    ///dentro del radio group el id del radiobutton pulsado porque un R.id. es un entero
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        Log.i("Radiogroup", "entro");

        if (checkBoxCoches.isChecked()){
        Log.i("RadiogroupCoches", "entro");
        if (radioGroup.getId() == R.id.radioGroupCoches) {
            switch (i) {
                case R.id.radioButtonCocheDrcha:{
                    layoutParaCoches = R.layout.car_row_right;
                    break;}
                case R.id.radioButtonCocheIzda:{
                    layoutParaCoches = R.layout.car_row_left;
                    break;}
                case R.id.radioButtonCocheDoble:{
                    layoutParaCoches = R.layout.car_row_double;
                    break;}
            }
        }}
        if (checkBoxMotos.isChecked())
            Log.i("RadiogroupMotos", "entro");
        {        if (radioGroup.getId() == R.id.radioGroupMotos) {
            switch (i) {
                case R.id.radioButtonMotoDrcha:{
                    layoutParaMotos = R.layout.bike_row_right;
                    break;}
                case R.id.radioButtonMotoIzda:{
                    layoutParaMotos = R.layout.bike_row_left;
                    break;}
                case R.id.radioButtonMotoDoble:{
                    layoutParaMotos = R.layout.bike_row_double;
                    break;}
            }
        }}
        if (checkBoxMotos.isChecked()&&(radioGroupMotos.getId()==R.id.radioGroupMotos) ||
                checkBoxCoches.isChecked()&& (radioGroupCoches.getId()==R.id.radioGroupCoches)){
//llamo al adaptador aqui porque solo puede mostrar datos si tiene un layout marcado
        Log.i("on ChekedChanged", "llamo al adapatador");
        Adaptador adaptador = new Adaptador(arrayListVehiculos, this, layoutParaMotos,
                layoutParaCoches);
        listaViewVehiculos.setAdapter(adaptador);
    }}
}


