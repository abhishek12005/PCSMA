package com.example.videoinfo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Info extends ActionBarActivity {
	
	private EditText name;
	private EditText type;
	private EditText duration;
	private EditText height;
	private EditText width;
	
	private Button Submit;

	private String n,t,d,h,w;
	long d1,h1,w1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		
		
		name = (EditText)findViewById(R.id.editText1);
		type = (EditText)findViewById(R.id.editText2);
		duration = (EditText)findViewById(R.id.editText3);
		height = (EditText)findViewById(R.id.editText4);
		width = (EditText)findViewById(R.id.editText5);
		
		Submit = (Button)findViewById(R.id.button1);
		
		Submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				n=name.getText().toString();
				t=type.getText().toString();
				d=duration.getText().toString();
				h=height.getText().toString();
				w=width.getText().toString();
				
				d1=Long.parseLong(d);
				h1=Long.parseLong(h);
				w1=Long.parseLong(w);
				List<Video> Meta = new ArrayList<Video>();
				Meta.add(new Video(n,t,d1,h1,w1));
				HttpClient httpClient = new DefaultHttpClient();
		        HttpPost httpPost = new HttpPost("http://localhost:8080/ServVideo/video");
		        try {
		            httpPost.setEntity(new UrlEncodedFormEntity((List<? extends NameValuePair>) Meta));
		        } catch (UnsupportedEncodingException ex) {
		            ex.printStackTrace();
		        }
		        
		        try {
		            HttpResponse response = httpClient.execute(httpPost);
		            TextView txt = (TextView) findViewById(R.id.textView1);
		            txt.setText("Response:"+response.toString());

		        } catch (ClientProtocolException ex) {
		            
		            ex.printStackTrace();
		        } catch (IOException ex) {
		            
		            ex.printStackTrace();

		        }
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info, menu);
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
