package com.example.amaya.myapplication1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button btnPiedra,btnPapel,btnTijera;
    TextView txtMarcador;
    ImageView ImgJugador,ImgCPU;
    int JugadorPuntaje=0;
    int CPUPuntaje=0;

    /*LayoutInflater ImagenAlerta= LayoutInflater.from(MainActivity.this);
    final View VistaGanador = ImagenAlerta.inflate(R.layout.ganador,null);*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPiedra=(Button)findViewById(R.id.BtnPiedra);
        btnPapel=(Button)findViewById(R.id.BtnPapel);
        btnTijera=(Button)findViewById(R.id.BtnTijera);
        txtMarcador=(TextView)findViewById(R.id.TxtMarcador);
        ImgJugador=(ImageView)findViewById(R.id.ImgJugador);
        ImgCPU=(ImageView)findViewById(R.id.ImgCPU);

        btnPiedra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ImgJugador.setImageResource(R.drawable.puno);
                String mensaje=turno("Piedra");
                Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_SHORT).show();
                txtMarcador.setText("Jugador: "+Integer.toString(JugadorPuntaje)+ "CPU: "+Integer.toString(CPUPuntaje) );
            }});

        btnPapel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ImgJugador.setImageResource(R.drawable.papel);
                String mensaje=turno("Papel");
                Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_SHORT).show();
                txtMarcador.setText("Jugador: "+Integer.toString(JugadorPuntaje)+ "CPU: "+Integer.toString(CPUPuntaje) );
            }});

        btnTijera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ImgJugador.setImageResource(R.drawable.tijera);
                String mensaje=turno("Tijera");
                Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_SHORT).show();
                txtMarcador.setText("Jugador: "+Integer.toString(JugadorPuntaje)+ "CPU: "+Integer.toString(CPUPuntaje) );
            }
        });

    }
    public String turno (String elejido){
        String dispositivo_selecciono=" ";
        Random r=new Random();

        int dispos_selecciono_numero =r.nextInt(3)+1;
        if(dispos_selecciono_numero==1){
            dispositivo_selecciono="Piedra";
        }else
        if(dispos_selecciono_numero==2){
            dispositivo_selecciono="Papel";
        }else
        if(dispos_selecciono_numero==3){
            dispositivo_selecciono="Tijera";
        }
        if(dispositivo_selecciono=="Piedra"){
            ImgCPU.setImageResource(R.drawable.puno);
        }else
        if(dispositivo_selecciono=="Papel"){
            ImgCPU.setImageResource(R.drawable.papel);
        }else
        if(dispositivo_selecciono=="Tijera"){
            ImgCPU.setImageResource(R.drawable.tijera);
        }
        if(dispositivo_selecciono == elejido ){
            return "Empatados";
        } else if(elejido=="Piedra" && dispositivo_selecciono=="Tijera"){
            JugadorPuntaje++;
           // DialogoGanador();
            return "La piedra rompio tijera, HAS GANADO";
        }else if(elejido=="Piedra" && dispositivo_selecciono=="Papel"){
            CPUPuntaje++;
            return "Papel gana a piedra, HAS PERDIDO";
        }else if(elejido=="Tijera" && dispositivo_selecciono=="Piedra"){
            CPUPuntaje++;
            return "Piedra gana a Tijeras, HAS PERDIDO";
        }else if(elejido=="Tijera" && dispositivo_selecciono=="Papel"){
            JugadorPuntaje++;
           // DialogoGanador();
            return "Tijera corta papel, HAS GANADO";
        }else if(elejido=="Papel" && dispositivo_selecciono=="Piedra"){
            JugadorPuntaje++;
           // DialogoGanador();
            return "Papel cubre a la piedra, HAS GANADO";
        }else if(elejido=="Papel" && dispositivo_selecciono=="Tijera"){
            CPUPuntaje++;
            return "Tijera gana Papel, HAS Perdido";
        }
        else return "No Seguro";
    }

   /* public void DialogoGanador(){

        AlertDialog.Builder Alerta = new AlertDialog.Builder(MainActivity.this);
        Alerta.setMessage("Muchas Felicidades")
        .setCancelable(true)
                .setPositiveButton("Listo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog titulo= Alerta.create();
        titulo.setTitle("GANADOR");
       titulo.setView(VistaGanador);
        titulo.show();

    }*/
}
