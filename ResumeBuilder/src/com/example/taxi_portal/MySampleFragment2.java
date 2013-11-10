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




public class  MySampleFragment2 extends Activity {
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample_fragment2);
		Parse.initialize(this, "nqM79I305EayjIyXh8CVjDMmNy6JjMqtbVpiUHDm", "LcG6e35iPrMy4AmHQXEHK4mOhMLVDNXEYH0jxxx1");
		ParseAnalytics.trackAppOpened(getIntent());
  		final ParseUser currentUser = ParseUser.getCurrentUser();

	        final  EditText Xm = (EditText) findViewById(R.id.editText1);
	        final  EditText XIIm = (EditText) findViewById(R.id.editText2);
	        final  EditText cgpa = (EditText) findViewById(R.id.editText3);
	        final  EditText comp = (EditText) findViewById(R.id.editText4);
	        Button sz = (Button) findViewById(R.id.button1);
			sz.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
	        currentUser.put("X marks", Xm.getText().toString());
	        currentUser.put("XII marks", XIIm.getText().toString());
	        currentUser.put("CGPA", cgpa.getText().toString());
	        currentUser.put("Company", comp.getText().toString());
	        currentUser.saveInBackground();
	  		Intent intent = new Intent(MySampleFragment2.this, resume.class);
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
    		Intent intent = new Intent(MySampleFragment2.this,MainActivity.class);
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

	    

