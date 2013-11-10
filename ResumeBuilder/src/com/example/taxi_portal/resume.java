package com.example.taxi_portal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;



public class resume extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resume);
		Parse.initialize(this, "nqM79I305EayjIyXh8CVjDMmNy6JjMqtbVpiUHDm", "LcG6e35iPrMy4AmHQXEHK4mOhMLVDNXEYH0jxxx1");
		ParseAnalytics.trackAppOpened(getIntent());
		final ParseUser currentUser = ParseUser.getCurrentUser();
		TextView name = (TextView) findViewById(R.id.textView15);
		TextView email = (TextView) findViewById(R.id.textView16);
		TextView age = (TextView) findViewById(R.id.textView17);
		TextView gender = (TextView) findViewById(R.id.textView18);
		TextView dob = (TextView) findViewById(R.id.textView19);
		TextView contact = (TextView) findViewById(R.id.textView20);
		TextView branch = (TextView) findViewById(R.id.textView21);
		TextView degree = (TextView) findViewById(R.id.textView22);
		TextView dur = (TextView) findViewById(R.id.textView23);
		TextView acc = (TextView) findViewById(R.id.textView24);
		TextView x = (TextView) findViewById(R.id.textView25);
		TextView xii = (TextView) findViewById(R.id.textView26);
		TextView cg = (TextView) findViewById(R.id.textView27);
		final TextView we = (TextView) findViewById(R.id.textView28);
		name.setText(currentUser.getUsername());
		email.setText(currentUser.getEmail());
		age.setText(currentUser.getString("Age"));
		gender.setText(currentUser.getString("Gender"));
		dob.setText(currentUser.getString("Dob"));
		contact.setText(currentUser.getString("Contact"));
		branch.setText(currentUser.getString("Branch"));
		degree.setText(currentUser.getString("Degree"));
		dur.setText(currentUser.getString("Duration"));
		acc.setText(currentUser.getString("Accomplishments"));
		x.setText(currentUser.getString("X marks"));
		xii.setText(currentUser.getString("XII marks"));
		cg.setText(currentUser.getString("CGPA"));
		we.setText(currentUser.getString("Company"));
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			   @Override
			   public void onClick(View v) {
			       Bitmap bitmap = takeScreenshot();
			       saveBitmap(bitmap);
			       we.setText("done");
			   }
			});
		
		findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
			   @Override
			   public void onClick(View v) {
				   if (isNetworkAvailable() == false) {
                       Toast.makeText(resume.this,
                                     "Network connection not available, Please try later",
                                     Toast.LENGTH_SHORT).show();
                } else {
                       File file = new File("/storage/emulated/0/Download" + "/screenshot.png");
                       Intent printIntent = new Intent(resume.this, PrintDialogActivity.class);
                       printIntent.setDataAndType(Uri.fromFile(file), "image/png");
                       printIntent.putExtra("title", "Resume");
                       startActivity(printIntent);
                }
   }
});

		

	}
	
	public boolean isNetworkAvailable() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
               Log.e("Network Testing", "***Available***");
               return true;
        }
        Log.e("Network Testing", "***Not Available***");
        return false;
 }



	public void saveBitmap(Bitmap bitmap) {
	    File imagePath = new File("/storage/emulated/0/Download" + "/screenshot.png");
	    FileOutputStream fos;
	    try {
	        fos = new FileOutputStream(imagePath);
	        bitmap.compress(CompressFormat.JPEG, 100, fos);
	        fos.flush();
	        fos.close();
	    } catch (FileNotFoundException e) {
	        Log.e("GREC", e.getMessage(), e);
	    } catch (IOException e) {
	        Log.e("GREC", e.getMessage(), e);
	    }
	}
	public Bitmap takeScreenshot() {
		   View rootView = findViewById(android.R.id.content).getRootView();
		   rootView.setDrawingCacheEnabled(true);
		   return rootView.getDrawingCache();
		}

}


