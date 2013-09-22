package com.bknc.sgolf.sgolfbooking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.bknc.sgol.sgolfbooking.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	//public static final String URL = "http://175.115.238.81:8080/sgolf/home.do";
	EditText edtText111;
	TextView textView2;
	TextView hand_phone_no;
	TextView booking_status;
	TextView player_count;
	TextView leftright_gubn;
	TextView booking_date_time;
	TextView game_kind;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Create a new RestTemplate instance
		//RestTemplate restTemplate = new RestTemplate();
		
		// The URL for making the GET request
		//final String url = "http://175.115.238.81:8080/sgolf/home.do";
		
		// Instantiate the HTTP GET request, expecting an array of
		// Product objects in response
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TelephonyManager telManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE); 
		String phoneNum = telManager.getLine1Number();		
		
		//휴대폰 전화번호 가져오기
		EditText edtPlayerCount = (EditText) this.findViewById(R.id.EdtPlayerCount);
		//EditText edtText111 = (EditText) this.findViewById(R.id.EdtPlayerCount);
		//textView2 = (TextView) this.findViewById(R.id.hand_phone_no);
		hand_phone_no = (TextView) this.findViewById(R.id.hand_phone_no);
		booking_status = (TextView) this.findViewById(R.id.booking_status);
		player_count = (TextView) this.findViewById(R.id.player_count);
		leftright_gubn = (TextView) this.findViewById(R.id.leftright_gubn);
		booking_date_time = (TextView) this.findViewById(R.id.booking_date_time);
		game_kind = (TextView) this.findViewById(R.id.game_kind);

		edtPlayerCount.setText(phoneNum);
		
		Button b1 = (Button) this.findViewById(R.id.btnRegister);
		b1.setOnClickListener(this);	
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClick(View v) {
		GetXMLTask task = new GetXMLTask();
		task.execute(new String[] { "" });
		
		EditText edtPlayerCount = (EditText) this.findViewById(R.id.EdtPlayerCount);
		switch (v.getId()) {
		case R.id.btnRegister:
			Toast.makeText(this, "zzzzzzzzzzzzzzzzzzzzzzzzzz", Toast.LENGTH_SHORT).show();
		}
	}
	
	private class GetXMLTask extends AsyncTask<String, Void, String> {
		private ProgressDialog dialog =  new ProgressDialog(MainActivity.this);
		String list;
		@Override
		protected String doInBackground(String... urls) {
			String output = "";
			//restTemplate Test
			String url = "http://175.115.238.81:8080/sgolf/getBookingList";
			
			// Create a new RestTemplate instance
			RestTemplate restTemplate = new RestTemplate();
			
			// Add the String message converter
			restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
			
			// Make the HTTP GET request, marshaling the response to a String
			//String output = restTemplate.getForObject(url,String.class, "SpringSource");
			list = restTemplate.getForObject(url,String.class);
			
			
			//textView01.setText(shop.getName());
			
			return "";
		}
		
		 @Override        
		 protected void onPreExecute() {            
			 // TODO i18n            
			 dialog.setMessage("Please wait..");            
			 dialog.show();                 		
		 }
		@Override
		protected void onPostExecute(String output) {
			 try {
				 Type type = new TypeToken<List<BookingVO>>(){}.getType();
				 List<BookingVO> inpList = new Gson().fromJson(list, type);
				 
				 for(int i=0; i<inpList.size(); i++){
					 BookingVO x = inpList.get(i);
					 hand_phone_no.setText(x.getHand_phone_no());
					 booking_status.setText(x.getBooking_status());
					 player_count.setText(x.getPlayer_count());
					 leftright_gubn.setText(x.getLeftright_gubn());
					 booking_date_time.setText(x.getBooking_date_time());
					 game_kind.setText(x.getGame_kind());

				 }

			 } catch(Exception ex) {
				 ex.printStackTrace();
			 }
			 
			 if (dialog.isShowing()) {                
				 dialog.dismiss();            
			 }
		}
	}
	
	//전송 버튼을 눌렀을 때
	 
    public void send(View v){
 
    //서버에 전송할 데이터를 얻어와서 hashmap에 담는다.
 
//    String inputNum=num.getText().toString();
// 
//    String inputName=name.getText().toString();
// 
//    String inputAddr=addr.getText().toString();
// 
//    HashMap<String, String> map =  new HashMap<String, String>();
// 
//    map.put("num", inputNum);
// 
//    map.put("name", inputName);
// 
//    map.put("addr", inputAddr);
// 
//    
//
//    String url="http://192.168.0.205:8888/AndroidServer/insert.jsp";
// 
//    SendTextThread thread = new SendTextThread(handler, map, url);
// 
//    thread.start();
    }
    
	

}
