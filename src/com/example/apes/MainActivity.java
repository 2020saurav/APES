package com.example.apes;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	DB testdb = new DB(this);
	EditText arunNew, enayatNew, pranavNew, sauravNew;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*TextView total = (TextView) findViewById(R.id.textView5);
		
		DB testdb = new DB(this);
		testdb.open();
		val = testdb.getValue(1);
		testdb.close();
		test.setText(Integer.toString(val));*/
		
		TextView arunMoney = (TextView) findViewById(R.id.textArunMoney);
		TextView enayatMoney = (TextView) findViewById(R.id.textEnayatMoney);
		TextView pranavMoney = (TextView) findViewById(R.id.textPranavMoney);
		TextView sauravMoney = (TextView) findViewById(R.id.textSauravMoney);
		TextView totalMoney = (TextView) findViewById(R.id.textTotal);
		Button go = (Button) findViewById(R.id.button1);
		
		arunNew = (EditText) findViewById(R.id.editTextArun);
		enayatNew = (EditText) findViewById(R.id.editTextEnayat);
		pranavNew = (EditText) findViewById(R.id.editTextPranav);
		sauravNew = (EditText) findViewById(R.id.editTextSaurav);
		
		/*arunNew.setText(0);
		enayatNew.setText(0);
		pranavNew.setText(0);
		sauravNew.setText(0);
		*/
		
		
		testdb.open();
		arunMoney.setText("Arun: "+ Integer.toString(testdb.getValue(1)));
		enayatMoney.setText("Enayat: " + Integer.toString(testdb.getValue(2)));
		pranavMoney.setText("Pranav: " + Integer.toString(testdb.getValue(3)));
		sauravMoney.setText("Saurav: " + Integer.toString(testdb.getValue(4)));
		totalMoney.setText(Integer.toString(testdb.getValue(1)+testdb.getValue(2)+testdb.getValue(3)+testdb.getValue(4) ));		
		testdb.close();
		
		go.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				testdb.open();
				int arun = testdb.getValue(1) + Integer.parseInt((arunNew.getText().toString()));
				int enayat = testdb.getValue(2) + Integer.parseInt((enayatNew.getText().toString()));
				int pranav = testdb.getValue(3) + Integer.parseInt((pranavNew.getText().toString()));
				int saurav = testdb.getValue(4) + Integer.parseInt((sauravNew.getText().toString()));
				
				testdb.insertValues(arun, enayat, pranav, saurav);
				testdb.close();
				finish();
				startActivity(getIntent());
				
				
			}
			
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
