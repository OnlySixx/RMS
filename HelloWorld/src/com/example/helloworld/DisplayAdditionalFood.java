package com.example.helloworld;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DisplayAdditionalFood extends Activity {
	EditText xihongshichaodan =  null;
	EditText cuiliubaicai =  null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_addtional_food);
	}	
	public void submitAdditionalFood(View view){
		xihongshichaodan =  (EditText) this.findViewById(R.id.editText4);
		cuiliubaicai =  (EditText) this.findViewById(R.id.editText5);
		final Builder dialog = new AlertDialog.Builder(this);
		final Bundle myBundelForGetName = this.getIntent().getExtras()==null?new Bundle():this.getIntent().getExtras();
    	if (myBundelForGetName!=null){
    		myBundelForGetName.putString(Constants.FOOD_ADDIONALFOOD_XIHONGSHICHAODAN, xihongshichaodan.getText().toString());
    		myBundelForGetName.putString(Constants.FOOD_ADDIONALFOOD_CUILIUBAICAI, cuiliubaicai.getText().toString());
    	}
        dialog.setPositiveButton("结帐 ", new DialogInterface.OnClickListener() {
        	@Override
			public void onClick(DialogInterface dialog1, int which) {
        		 Intent intent = new Intent();
        		 intent.putExtras(myBundelForGetName);
          		 intent.setClass(DisplayAdditionalFood.this, Billing.class);
          		 startActivity(intent);
        	}

            
		}); 
        dialog.setNeutralButton("继续预订 ", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialog, int whichButton) { 
            	
             Intent intent = new Intent();
             intent.putExtras(myBundelForGetName);
       		 intent.setClass(DisplayAdditionalFood.this, MainActivity.class);
       		 startActivity(intent);
            }  
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
        	@Override
			public void onClick(DialogInterface dialog1, int which) {
				
			}  
		   
        }); 
        dialog.create().show(); 
	}
}
