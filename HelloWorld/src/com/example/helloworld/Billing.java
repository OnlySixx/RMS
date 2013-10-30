package com.example.helloworld;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Billing extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		String xhs = null;
		String clbc = null;
		String mantou = null;
		String bing= null;
		String mifan = null;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_bill);
		TextView xhsTextView= (TextView)findViewById(R.id.textView1);

		TextView clbcTextView= (TextView)findViewById(R.id.textView2);

		TextView mantouTextView= (TextView)findViewById(R.id.textView3);
		

		TextView bingTextView= (TextView)findViewById(R.id.textView4);

		TextView mifanTextView= (TextView)findViewById(R.id.textView5);
		
		Bundle myBundelForGetName=this.getIntent().getExtras();
    	if (myBundelForGetName!=null){
    		xhs = myBundelForGetName.getString(Constants.FOOD_ADDIONALFOOD_XIHONGSHICHAODAN);
    		clbc = myBundelForGetName.getString(Constants.FOOD_ADDIONALFOOD_CUILIUBAICAI);
    		mantou=myBundelForGetName.getString(Constants.FOOD_MAINFOOD_MANTOU);
    		bing=myBundelForGetName.getString(Constants.FOOD_MAINFOOD_BING);
    		mifan=myBundelForGetName.getString(Constants.FOOD_MAINFOOD_MIFAN);
    	}
    	if (xhs!=null){
    		xhsTextView.setText("西红柿炒蛋"+xhs+"份 ，共 +"+Integer.valueOf(xhs)*10+"元 ");
    	}
    	if(clbc!=null){
    		clbcTextView.setText("醋熘白菜"+clbc+"份 ，共+"+Integer.valueOf(clbc)*7+"元 ");
    	}
    	if (mantou!=null){
    		mantouTextView.setText("馒头"+mantou+"份 ，共+"+Integer.valueOf(mantou)*1+"元 ");
    	}
    	if (bing!=null){
    		bingTextView.setText("饼 "+bing+"份 ，共"+Integer.valueOf(bing)*1+"元 ");
    	}
    	if (mifan!=null){
    		mifanTextView.setText("米饭 "+mifan+"份 ，共"+Integer.valueOf(mifan)*1+"元 ");
    	}
	}

	
}
