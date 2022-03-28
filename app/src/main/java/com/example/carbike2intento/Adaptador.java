package com.example.carbike2intento;

import android.content.Context;
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

    public Adaptador(ArrayList<Object> miArrayList, Context context) {
        this.miArrayList = miArrayList;
        this.context = context;
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
        //este el método principal del adaptador para adaptar el layout del coche al listview
        //Tenemos que inflar el layout. Para eso existe la clase LayoutInflater (como iterator)
        // y se crear una variable y se llama al método inflate que necesita el layout que
        //vamos a usar para cada fila de la lista
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.car_row_left, null);
        //una vez seleccionado el layout tenemos que identificar los campos que vamos a enganchar
        //java con xml, en este caso el nombre y la imagen del coche
        ImageView imageView= view.findViewById(R.id.car_left_image);
        TextView textView=view.findViewById(R.id.car_left_name);
        //creamos un objeto coche y lo instanciamos con el método getitem implementado anteriormente
        Car car= (Car) getItem(position);
        //de ese coche tomamos el nombre y la imagen para setearlo en los campos del layout
        textView.setText( car.getName());
        imageView.setImageResource(car.getImage());
        //devolvemos la vista
        return view;
        }
}
