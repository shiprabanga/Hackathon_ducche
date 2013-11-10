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

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseUser;




public class  MySampleFragment1 extends Activity {
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample_fragment1);
		Parse.initialize(this, "nqM79I305EayjIyXh8CVjDMmNy6JjMqtbVpiUHDm", "LcG6e35iPrMy4AmHQXEHK4mOhMLVDNXEYH0jxxx1");
		ParseAnalytics.trackAppOpened(getIntent());
  		final ParseUser currentUser = ParseUser.getCurrentUser();

	        Button sz = (Button) findViewById(R.id.button1);
			sz.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					EditText deg = (EditText) findViewById(R.id.editText1);
			          EditText branch = (EditText) findViewById(R.id.editText2);
			         EditText dur = (EditText) findViewById(R.id.editText3);
			          EditText accomp = (EditText) findViewById(R.id.editText4);
			  		currentUser.put("Degree", deg.getText().toString());
			  		currentUser.put("Branch", branch.getText().toString());
			  		currentUser.put("Duration", dur.getText().toString());
			  		currentUser.put("Accomplishments", accomp.getText().toString());
			  		currentUser.saveInBackground();
			  		Intent intent = new Intent(MySampleFragment1.this, MySampleFragment2.class);
					startActivity(intent);
				}
			});
	    	}
public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch(item.getItemId())
    	{
    	case R.id.logout : 
    		Log.i("Check","LOGOUT");
    		Parse.initialize(this, "nqM79I305EayjIyXh8CVjDMmNy6JjMqtbVpiUHDm", "LcG6e35iPrMy4AmHQXEHK4mOhMLVDNXEYH0jxxx1");
    		ParseAnalytics.trackAppOpened(getIntent());
    		ParseUser.logOut();
    		Intent intent = new Intent(MySampleFragment1.this,MainActivity.class);
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

	    
