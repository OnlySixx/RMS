package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {
	Bundle myBundelForGetName = null;
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	myBundelForGetName=this.getIntent().getExtras();
    	if (myBundelForGetName!=null){
    		String name=myBundelForGetName.getString(Constants.FOOD_MAINFOOD_MANTOU);
    	} else {
    		myBundelForGetName = new Bundle();
    	}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    
    /** Called when the user clicks the Send button */
    public void turnToMainFood(View view) {
    	
    	Intent intent = new Intent(this, DisplayMainFood.class);
    	intent.putExtras(myBundelForGetName);
    	startActivity(intent);
    }
    public void turnToAddtionalFood(View view) {
    	Intent intent = new Intent(this, DisplayAdditionalFood.class);
    	intent.putExtras(myBundelForGetName);
    	startActivity(intent);
    }
}
