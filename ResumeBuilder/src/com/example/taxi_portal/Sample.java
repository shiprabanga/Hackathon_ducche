package com.example.taxi_portal;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseUser;

public class Sample extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample_fragment);
		Parse.initialize(this, "nqM79I305EayjIyXh8CVjDMmNy6JjMqtbVpiUHDm", "LcG6e35iPrMy4AmHQXEHK4mOhMLVDNXEYH0jxxx1");
		ParseAnalytics.trackAppOpened(getIntent());
		
		
		final ParseUser currentUser = ParseUser.getCurrentUser();
		if (currentUser != null) {
		  // do stuff with the user

			Button next = (Button) findViewById(R.id.button1);
			next.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					TextView tv = (TextView) findViewById(R.id.textView1);
					tv.setText("Done till here");
					
					// TODO Auto-generated method stub
					
					EditText age = (EditText) findViewById(R.id.editText1);
			        EditText gender = (EditText) findViewById(R.id.editText2);
			        EditText contact = (EditText) findViewById(R.id.editText3);
					
			        currentUser.put("Age", age.getText().toString());
			  		currentUser.put("Gender", gender.getText().toString());
			  		currentUser.put("Contact", contact.getText().toString());
					currentUser.saveInBackground();
					
				      Intent intent = new Intent(Sample.this, MySampleFragment1.class);
					  startActivity(intent);
					
				}
			});
			
			
			
		} else {
			Intent intent = new Intent(Sample.this, MainActivity.class);
			startActivity(intent);
		  // show the signup or login screen
		}
		
		
		
		
		
		
		
		
	}
public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch(item.getItemId())
    	{
    	case R.id.logout : 
    		Log.i("Check","LOGOUT");
    		Parse.initialize(this, "nqM79I305EayjIyXh8CVjDMmNy6JjMqtbVpiUHDm", "LcG6e35iPrMy4AmHQXEHK4mOhMLVDNXEYH0jxxx1");
    		ParseAnalytics.trackAppOpened(getIntent());
    		ParseUser.logOut();
    		Intent intent = new Intent(Sample.this,MainActivity.class);
    		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	  //  intent.putExtra("Exit me", true);
			startActivity(intent);
			finish();
    		return true;
    	default: 
    		return super.onOptionsItemSelected(item);
	    }
	}
}



