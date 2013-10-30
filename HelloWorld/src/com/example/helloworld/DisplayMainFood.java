package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;

public class DisplayMainFood extends Activity {

	EditText mantou = null;
	EditText bing = null;
	EditText mifan = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_main_food);
	}

	public void submitMainFood(View view) {
		mifan = (EditText) this.findViewById(R.id.editText3);
		bing = (EditText) this.findViewById(R.id.editText2);
		mantou = (EditText) this.findViewById(R.id.editText1);
		final Builder dialog = new AlertDialog.Builder(this);
		final Bundle myBundelForGetName = this.getIntent().getExtras()==null?new Bundle():this.getIntent().getExtras();
		dialog.setTitle("提示 ");
		
		myBundelForGetName.putString(Constants.FOOD_MAINFOOD_MANTOU,
				mantou.getText().toString());
		myBundelForGetName.putString(Constants.FOOD_MAINFOOD_BING,
				bing.getText().toString());
		myBundelForGetName.putString(Constants.FOOD_MAINFOOD_MIFAN,
				mifan.getText().toString());
		dialog.setPositiveButton("结帐", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog1, int which) {
				Intent intent = new Intent();
       		 	intent.putExtras(myBundelForGetName);
         		 intent.setClass(DisplayMainFood.this, Billing.class);
         		 startActivity(intent);
			}

		});
		dialog.setNeutralButton("继续预订 ", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				
				
				Intent intent = new Intent();
				intent.putExtras(myBundelForGetName);
				intent.setClass(DisplayMainFood.this, MainActivity.class);
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
