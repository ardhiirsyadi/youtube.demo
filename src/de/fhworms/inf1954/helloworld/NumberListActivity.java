package de.fhworms.inf1954.helloworld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NumberListActivity extends Activity {
	
	
	private ListView numberListView;
	private ArrayAdapter<String> listAdapter ; 
	static final int[] NUMBERS = new int[256];
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_number);
		
		Random randomNumber = new Random();		
		
		List<String> numberArrayList = new ArrayList<String>();
		for(int i=0; i<30;i++){
			numberArrayList.add(randomNumber.nextInt(256)+" bpm");
		}
		numberListView = (ListView) this.findViewById(R.id.numberListView);
		listAdapter = new ArrayAdapter<String>(this, R.layout.row_number, numberArrayList);  
		numberListView.setAdapter( listAdapter );    

	}

}
