package com.example.carbike2intento;

import java.util.ArrayList;

public class Controlador {


    public static ArrayList<Object> llenarConCochesYMotos() {
        //llenor la lista entera con coches y motos
        ArrayList<Object> miArrayList=new ArrayList<>();

        Car car1 = new Car("Audi A8", R.drawable.audi_a8);
        Car car2 = new Car("BMW M3", R.drawable.bmw_m3);
        Car car3 = new Car("Citroen C3", R.drawable.citroen_c3);
        Car car4 = new Car("Opel Astra", R.drawable.opel_astra);
        Car car5 = new Car("Renault Captur", R.drawable.renault_captur);
        Car car6 = new Car("Seat Ibiza", R.drawable.seat_ibiza);
        Car car7 = new Car("Volkswagen Golf", R.drawable.vw_golf);

        Bike bike1 = new Bike("H-D SuperLow", R.drawable.harley_davidson_superlow);
        Bike bike2 = new Bike("Honda CBR600 RR", R.drawable.honda_cbr600_rr);
        Bike bike3 = new Bike("Suzuki GSX R600", R.drawable.suzuki_gsx_r600);
        Bike bike4 = new Bike("Yamaha R6", R.drawable.yamaha_r6);

        miArrayList.add (bike1);
        miArrayList.add (car1);
        miArrayList.add (car2);
        miArrayList.add (car3);
        miArrayList.add (car4);
        miArrayList.add (bike2);
        miArrayList.add (car5);
        miArrayList.add (bike3);
        miArrayList.add (car6);
        miArrayList.add (car7);
        miArrayList.add (bike4);

        return miArrayList;
    }

    public static ArrayList<Object> llenarconCoches() {
        //voy a llenar la lista solo con coches
        ArrayList<Object> miArrayList=new ArrayList<>();

        Car car1 = new Car("Audi A8", R.drawable.audi_a8);
        Car car2 = new Car("BMW M3", R.drawable.bmw_m3);
        Car car3 = new Car("Citroen C3", R.drawable.citroen_c3);
        Car car4 = new Car("Opel Astra", R.drawable.opel_astra);
        Car car5 = new Car("Renault Captur", R.drawable.renault_captur);
        Car car6 = new Car("Seat Ibiza", R.drawable.seat_ibiza);
        Car car7 = new Car("Volkswagen Golf", R.drawable.vw_golf);


        miArrayList.add (car1);
        miArrayList.add (car2);
        miArrayList.add (car3);
        miArrayList.add (car4);
        miArrayList.add (car5);
        miArrayList.add (car6);
        miArrayList.add (car7);

        return miArrayList;
    }

    public static ArrayList<Object> llenarconMotos() {
        //voy a llenar la lista entera con coches
        ArrayList<Object> miArrayList=new ArrayList<>();


        Bike bike1 = new Bike("H-D SuperLow", R.drawable.harley_davidson_superlow);
        Bike bike2 = new Bike("Honda CBR600 RR", R.drawable.honda_cbr600_rr);
        Bike bike3 = new Bike("Suzuki GSX R600", R.drawable.suzuki_gsx_r600);
        Bike bike4 = new Bike("Yamaha R6", R.drawable.yamaha_r6);

        miArrayList.add (bike1);
        miArrayList.add (bike2);
        miArrayList.add (bike3);
        miArrayList.add (bike4);

        return miArrayList;
    }
}
