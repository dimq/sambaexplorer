package com.shank.SambaExplorer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class PickHost extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.pickhost);
	
		Button btn = (Button)findViewById(R.id.Button01);
		btn.setOnClickListener(mPickHostClickListener);
    }

    private OnClickListener mPickHostClickListener = new OnClickListener()
    {
        public void onClick(View v)
        {
    		EditText ip = (EditText)findViewById(R.id.EditText01);
    		String text = ip.getText().toString();
    		

			if (text.startsWith("\\\\")) {
				text = text.substring(2);
			}
    		if (text.startsWith("\\")) {
				text = text.substring(1);
    		}
    		if (text.startsWith("//")) {
				text = text.substring(2);
    		}
    		if (text.startsWith("/")) {
				text = text.substring(1);
    		}
    		if (text.endsWith("\\")) {
				text = text.substring(0, text.length()-1);
    		}
    		if (text.endsWith("/")) {
				text = text.substring(0, text.length()-1);
    		}
    		
    		text = "smb://"+text+"/";
    		
        	Intent intent = new Intent(v.getContext(), com.shank.SambaExplorer.SambaExplorer.class);
        	intent.putExtra("hostname", text);
        	startActivity(intent);  
        }
    };	
}

