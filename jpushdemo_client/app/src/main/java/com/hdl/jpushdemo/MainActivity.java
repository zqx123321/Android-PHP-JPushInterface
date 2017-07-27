package com.hdl.jpushdemo;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText EtPush;
    private Button BtnPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EtPush= (EditText) findViewById(R.id.et_push);
        BtnPush= (Button) findViewById(R.id.btn_push);

        BtnPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                String text=EtPush.getText().toString();

                IpConfig ip = new IpConfig();
                JSONParser jParser = new JSONParser();
                String url = ip.ip+"/jpush/test.php";
                JSONArray products = null;

                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("text", text));

                JSONObject json = jParser.makeHttpRequest(url, "GET", params);


                String showContent = "推送成功！";
                Toast.makeText(MainActivity.this,showContent,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
