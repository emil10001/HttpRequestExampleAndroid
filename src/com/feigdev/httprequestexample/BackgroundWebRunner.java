package com.feigdev.httprequestexample;

import android.os.AsyncTask;

import com.github.kevinsawicki.http.HttpRequest;

public class BackgroundWebRunner extends AsyncTask<Void, Void, String> {
	private static final String TAG = "BackgroundWebRunner";
	private static final String ENDPOINT = "http://www.feigdev.com";

	@Override
	protected String doInBackground(Void... arg0) {
		String response = HttpRequest.get(ENDPOINT).body();
		System.out.println("Response was: " + response);
		return response;
	}

	@Override
	protected void onPostExecute(String result) {
		BusProvider.getInstance().register(this);
		BusProvider.getInstance().post(result);
		BusProvider.getInstance().unregister(this);
	}
}
