	package de.fhworms.inf1954.helloworld;

import java.awt.font.NumericShaper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HelloWorldActivity extends Activity {
	private static final String COUNTER_KEY = "counterKey";
	private static final String TAG = "de.fhworms.inf1954";
	private static final String SHARED_PREFERENCES = "sharedPreferences";
	private int pressedCounter = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        pressedCounter = sharedPreferences.getInt(COUNTER_KEY, 0);
//        if(savedInstanceState != null){
//        	pressedCounter = savedInstanceState.getInt(COUNTER_KEY, 0);
//        }
        Log.v(TAG, "onCreate(Bundle savedInstanceState)");
        setContentView(R.layout.activity_hello_world);
        Button pressedButton = (Button) this.findViewById(R.id.buttonID);
        pressedButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
//				Toast.makeText(getApplicationConext(), "Button pressed "+ ++pressedCounter+" times", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(HelloWorldActivity.this, NumberListActivity.class);
			    startActivity(intent);      
	            finish();
				

			}
		});
        
    }
    
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//    	super.onSaveInstanceState(outState);
//    	outState.putInt(COUNTER_KEY, pressedCounter);
//    	
//    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    	Log.v(TAG, "onStart()");
    	// The activity is about to become visible
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	Log.v(TAG, "onResume()");
    	// The activity has become visible (it is now "resumed")
    }
    
    @Override
    protected void onPause() {
    	super.onPause();
    	SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
    	Editor editor = sharedPreferences.edit();
    	editor.putInt(COUNTER_KEY, pressedCounter);
    	editor.commit();
    	Log.v(TAG, "onPause()");
    	// Another activity is taking focus (this activity is about to be "paused")
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	Log.v(TAG, "onStop()");
    	// The activity is no longer visible (it is now "stopped")
    }
    
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	// The activity is about to be destroyed.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_hello_world, menu);
        return true;
    }
}
