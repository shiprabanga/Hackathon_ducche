package com.example.taxi_portal;


import com.parse.Parse;
import java.io.FileOutputStream;
import java.util.Date;


import com.parse.ParseAnalytics;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Third  extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);
		Button lin = (Button) findViewById(R.id.button1);
		lin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Third.this,Sample.class);
    			startActivity(intent);
			}
	});
		Button lin1 = (Button) findViewById(R.id.button2);
		lin1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Third.this,MySampleFragment1.class);
    			startActivity(intent);
			}
	});
		Button lin2 = (Button) findViewById(R.id.button3);
		lin2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Third.this,MySampleFragment2.class);
    			startActivity(intent);
			}
	});
		Button lin3 = (Button) findViewById(R.id.button4);
		lin3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
	    		ParseAnalytics.trackAppOpened(getIntent());
	    		ParseUser.logOut();
	    		Intent intent = new Intent(Third.this,MainActivity.class);
	    		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    			startActivity(intent);
			}
	});
		Button lin4 = (Button) findViewById(R.id.button5);
		lin4.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(Third.this,resume.class);
    			startActivity(intent);
			}
		
	});
	}
}
		
		
