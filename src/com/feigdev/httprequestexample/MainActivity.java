package com.feigdev.httprequestexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.httprequestexample.R;
import com.squareup.otto.Subscribe;

public class MainActivity extends Activity {
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.hellostring);
		BusProvider.getInstance().register(this);

		Void param = null;
		new BackgroundWebRunner().execute(param);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Subscribe
	public void dumpOutput(String output) {
		tv.setText(output);
	}

}
