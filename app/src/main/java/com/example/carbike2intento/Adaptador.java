package com.example.carbike2intento;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList<Object> miArrayList;
    private Context context;
    private int layoutParaMotos;
    private int layoutParaCoches;
    private final int CAR=1;
    private final int BIKE=0;


    public Adaptador(ArrayList<Object> miArrayList, Context context, int layoutParaMotos,
                     int layoutParaCoches) {
        this.miArrayList = miArrayList;
        this.context = context;
        this.layoutParaCoches=layoutParaCoches;
        this.layoutParaMotos=layoutParaMotos;
    }

    @Override
    public int getItemViewType(int position) {
        int tipoClase=CAR;
        if (getItem(position) instanceof Car){
            tipoClase=CAR;
        }else
        if (getItem(position) instanceof Bike){
            tipoClase=BIKE;
        }
        return tipoClase;
    }

    @Override
    public int getCount() {
        return miArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return miArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Log.i("Adaptador", "entro en getView");
        //este el método principal del adaptador para adaptar el layout del coche al listview
        //Tenemos que inflar el layout. Para eso existe la clase LayoutInflater (como iterator)
        // y se crear una variable y se llama al método inflate que necesita el layout que
        //vamos a usar para cada fila de la lista
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        //una vez seleccionado el layout tenemos que identificar los campos que vamos a enganchar
        //java con xml, en este caso el nombre y la imagen del coche
        //luego creamos un objeto coche o moto y lo instanciamos con el método getItem
        // implementado anteriormente
        //de ese coche o moto tomamos el nombre y la imagen para setearlo en los campos del layout
        // y devolvemos la vista

        if (getItemViewType(position)==CAR){
            view = layoutInflater.inflate(layoutParaCoches, null);
            ImageView imageView= view.findViewById(R.id.image);
            TextView textView=view.findViewById(R.id.name);
            Car car = (Car) getItem(position);
            textView.setText( car.getName());
            imageView.setImageResource(car.getImage());
            if (layoutParaCoches== R.layout.car_row_double){
                ImageView imageView2= view.findViewById(R.id.image2);
                imageView2.setImageResource(car.getImage());
            }
        }
            else{
            if (getItemViewType(position)==BIKE){
                view = layoutInflater.inflate(layoutParaMotos, null);
                ImageView imageView= view.findViewById(R.id.bike_image);
                TextView textView=view.findViewById(R.id.bike_name);

                Bike bike = (Bike) getItem(position);
                textView.setText( bike.getName());
                imageView.setImageResource(bike.getImage());
                if (layoutParaMotos== R.layout.bike_row_double){
                    ImageView imageView2= view.findViewById(R.id.bike_image2);
                    imageView2.setImageResource(bike.getImage());
                }
            }
        }

        return view;
        }
}
