package com.example.clientandro;

import transfer.Klijent;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends Activity {
	
	public EditText etIp;
	public EditText etPort;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setings);
		
		etIp = (EditText) findViewById(R.id.etIP);
		etPort = (EditText) findViewById(R.id.etPort);	
		
		final Button sacuvaj = (Button) findViewById(R.id.bSacuvaj);

		sacuvaj.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					
					String ip = etIp.getText().toString();
					int port = Integer.parseInt(etPort.getText().toString());
				
					
					Klijent.ip = ip;				
					Klijent.port = port;
				} catch (Exception e) {
					Toast.makeText(v.getContext(), "Pogresan unos!!", Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}
				
				finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



}
