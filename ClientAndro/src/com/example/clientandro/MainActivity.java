/*
 * This is a simple Android mobile client
 * This application send any file to a remort server when the 
 * send button is pressed
 * Author by Lak J Comspace
 */

package com.example.clientandro;

import java.text.DecimalFormat;

import logika.Kontroler;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import domen.Artikal;
import domen.Pazar;

public class MainActivity extends Activity {

	private final static String TAG = "ThreadingAsyncTask";
	private TextView tvlabela;
	private EditText etBarCode;
	

	Pazar p;
	Artikal a;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.e(TAG, "Usli u onCreate");

		Log.e(TAG, "1");
		etBarCode = (EditText) findViewById(R.id.etBarCode);
		Log.e(TAG, "2");
		tvlabela = (TextView) findViewById(R.id.tvLabela);
		Log.e(TAG, "3");
		tvlabela.setVisibility(TextView.INVISIBLE);
		Log.e(TAG, "4");

		final Button button = (Button) findViewById(R.id.bSacuvaj);
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Log.e(TAG, "Usli u onClick");
				new LoadSQLPazar().execute();
			}
		});

		final Button podesavanja = (Button) findViewById(R.id.bPodesavanja);
		podesavanja.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(v.getContext(), Settings.class);
				startActivity(intent);
			}
		});

		final Button barcod = (Button) findViewById(R.id.button1);
		barcod.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				new LoadSQLArtikal().execute();
			}
		});

	}

	class LoadSQLPazar extends AsyncTask<Integer, Integer, Pazar> {

		@Override
		protected void onPreExecute() {

		}

		@Override
		protected Pazar doInBackground(Integer... resId) {

			try {
				p = Kontroler.vratiObjekat().traziPazar();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//Toast.makeText(this, "Trazeni bar kod nije u bazi", Toast.LENGTH_LONG).
			}

			Log.e(TAG, p.toString());

			return p;
		}

		@Override
		protected void onPostExecute(Pazar p) {
			DecimalFormat df = new DecimalFormat("########.00");
			String cena = df.format(p.getIznos());
			tvlabela.setText("Iznos dnevnog pazara je " + cena);
			tvlabela.setVisibility(TextView.VISIBLE);

		}
	}

	class LoadSQLArtikal extends AsyncTask<Integer, Integer, Artikal> {

		@Override
		protected void onPreExecute() {
			tvlabela.setText("");
			tvlabela.setVisibility(TextView.VISIBLE);
		}

		@Override
		protected Artikal doInBackground(Integer... resId) {

			String barkod = etBarCode.getText().toString();
			try {
				a = Kontroler.vratiObjekat().traziArtikal(barkod);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Log.e(TAG, a.toString());

			return a;
		}

		@Override
		protected void onPostExecute(Artikal a) {

			DecimalFormat df = new DecimalFormat("####.00");
			String cena = df.format(a.getCena());
			tvlabela.setText("Cena artikla " + a.getNaziv() + " je: " + cena);
			Log.e(TAG, String.valueOf(a.getCena()));

		}
	}
}


