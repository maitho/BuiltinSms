package com.androidthon.builtinsms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SendSMS  extends Activity{
	
	Button sendButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sendButton = (Button) findViewById(R.id.bt_send);
		
		sendButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				try {
					//startign built in sms activity and parsing message to it
					Intent send = new Intent(Intent.ACTION_VIEW);
					send.putExtra("sms_body", "We are Sending SMS using the Built-in-SMS Application");					
					send.setType("vnd.android-dir/mms-sms");
					startActivity(send);
					
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(), "The SMS Application failed to initiate!, please try again later", Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}
				
			}
		});
	}
	
	

}
