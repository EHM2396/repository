package com.example.hilos;

import android.widget.EditText;
import android.widget.TextView;

public class Reloj extends Thread{
	TextView minuto;
	TextView segundo;
	TextView hora;
	TextView meridian;
	
	MainActivity interfazGlobal;
	int i;	
	int horacol;
	int min;
	int horuna;

	public Reloj(TextView minutos, TextView segundos, TextView horas, int h1,int m1, TextView mer, MainActivity interfaz){
		
		minuto = minutos;
		segundo = segundos;
		hora = horas;
		interfazGlobal = interfaz;
		horacol =h1;
		min =m1;
		meridian = mer;
		
	}
	
	public void run() {
		
		if (horacol > 23){
			
			horacol = horacol - 24;
			
		}
		if (min > 59){
			
			min = min - 59; 
			
		}
		
		for ( i = 1; i <= 61; i++) {
			
			interfazGlobal.runOnUiThread(new Runnable() {
				@Override
				public void run() {					
					
					if(horacol >12){
						meridian.setText("PM");
						horuna = horacol - 12;
					}
					else{ meridian.setText("AM");
						horuna = horacol;}										
					
					hora.setText(""+(horuna));
					minuto.setText(""+min);
					segundo.setText(""+i);
					
					if(i == 59){
						min = min + 1;
						minuto.setText(""+min);
						segundo.setText("0");
						i=0;						
						
						if(min > 59){
							min = 0;							
							
							hora.setText(""+horuna);
							horacol++;
								
								if(horacol > 23 ){
								horacol = 00;}								
			
						}
					}
				}
			});
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e){
			
		}
		}
	}
}

