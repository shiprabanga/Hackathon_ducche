package com.example.taxi_portal;

import android.os.Bundle;


import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Parse.initialize(this, "nqM79I305EayjIyXh8CVjDMmNy6JjMqtbVpiUHDm", "LcG6e35iPrMy4AmHQXEHK4mOhMLVDNXEYH0jxxx1");
		ParseAnalytics.trackAppOpened(getIntent());
		ParseUser currentUser = ParseUser.getCurrentUser();
		final EditText eid = (EditText) findViewById(R.id.editText2);
		
		// eid is username 
		final EditText pass = (EditText) findViewById(R.id.editText3);
		Button lin = (Button) findViewById(R.id.button1);
		
		// log-in
		lin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if( TextUtils.isEmpty(eid.getText().toString()) )
				{
					TextView msg = (TextView) findViewById(R.id.textView2);
					msg.setText("Invalid Email-Id");				
				}
				else if( TextUtils.isEmpty(pass.getText().toString()) )
				{
					TextView msg = (TextView) findViewById(R.id.textView2);
					msg.setText("Invalid Password");				
				}
				else
				{
					ParseUser.logInInBackground(eid.getText().toString(),pass.getText().toString(), new LogInCallback() {
						  public void done(ParseUser user, ParseException e) {
						    if (user != null) {
						    	TextView msg = (TextView) findViewById(R.id.textView2);
						    	msg.setText("Hooray! The user is logged in.");
						    	//ParseManager.sCurrentUser = user;
				                finish();
						    	Intent intent = new Intent(MainActivity.this,Third.class);
	                			startActivity(intent);
						    	
						      // Hooray! The user is logged in.
						    } else {
						    	//stopLoading();
						    	TextView msg = (TextView) findViewById(R.id.textView2);
						    	msg.setText("Please try again");
						    	Log.d("Check", "NOOO", e);
						      //  failed. Look at the ParseException to see what happened.
						    }
						  }
						});
				}
				
			}
		});

	Button sup = (Button) findViewById(R.id.button2);
	sup.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(MainActivity.this, Second.class);
			startActivity(intent);
			
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
