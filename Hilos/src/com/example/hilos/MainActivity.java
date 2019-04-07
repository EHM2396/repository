package com.example.hilos;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public EditText minuto, segundo, hora;
	public int segundito;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void cronometro(View v){
		
		TextView hora = (TextView)findViewById(R.id.textView3);
		TextView min = (TextView)findViewById(R.id.textView2);
	    TextView seg = (TextView)findViewById(R.id.textView1);
	    TextView mer = (TextView)findViewById(R.id.meridian);
	    
	   EditText h = (EditText)findViewById(R.id.hh);
	   EditText m = (EditText)findViewById(R.id.mm);
	   
	 
	   int h1 = Integer.parseInt(h.getText().toString());
	   int m1 = Integer.parseInt(m.getText().toString());
	   
	   Reloj goahead = new Reloj(min,seg, hora, h1, m1, mer, this);
	   goahead.start();
		
	}
	
	
	
	
	
}


		