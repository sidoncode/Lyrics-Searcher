package com.siddevlops.lyricssearcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView mTextViewResult;
    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewResult = findViewById(R.id.text_view_result);
        Button buttonParse = findViewById(R.id.button_parse);
        mQueue = Volley.newRequestQueue(this);
        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {
        String url = "https://api.lyrics.ovh/v1/Coldplay/Adventure%20of%20a%20Lifetime";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //JSONArray jsonArray = response.getJSONArray("lyrics");
                            //JSONObject jsonObject =response.getJSONObject("lyrics");
                            //response.get("lyrics");

                            String s = response.optString("lyrics");
                            //String a = response.getString("lyrics");
                            /**for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);
                                String firstName = employee.getString("firstname");
                                int age = employee.getInt("age");
                                String mail = employee.getString("mail");
                                mTextViewResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
                            }**/

                            //Toast.makeText(MainActivity.this,"s" + a,Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this,"->" + s,Toast.LENGTH_SHORT).show();

                            Log.i("s",s);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }
}

/**
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchPackages();

        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navlistener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout,new Search()).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            //return false;
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.search_frag:
                    selectedFragment = new Search();
                    break;
                case R.id.more_frag:
                    selectedFragment = new More();

            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_layout,selectedFragment).commit();
            return true;
        }
    };
    private void fetchPackages() {



        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://app.careerguide.com/api/main" +

                "fetch_pkg_amount", response -> {

            try {
                JSONObject jsonObject = new JSONObject(response);
                boolean status = jsonObject.optBoolean("status", false);
                if (status)
                {
                    JSONArray packagesJsonArray = jsonObject.optJSONArray("packages_amounts");
                    Log.e("lengthname--> " , "==> " +packagesJsonArray.length() );

                    Toast.makeText(MainActivity.this,"s" + packagesJsonArray.length(),Toast.LENGTH_SHORT).show();


                    for (int i = 0; i < packagesJsonArray.length(); i++) {
                        JSONObject JsonObject = packagesJsonArray.optJSONObject(i);
                        String id = JsonObject.optString("package_id");
                        int amount = Integer.parseInt(JsonObject.optString("packages_amounts"));
                        int duration = Integer.parseInt(JsonObject.optString("min"));
                        int validity = Integer.parseInt(JsonObject.optString("validation(in days)"));
                        String perk1 = JsonObject.optString("perk_1");
                        String perk2 = JsonObject.optString("perk_2");
                        String perk3 = JsonObject.optString("perk_3");

                    }


                } else {
                    Toast.makeText(MainActivity.this,"Something went wrong.",Toast.LENGTH_LONG).show();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> {
            //Toast.makeText(MainActivity.this, VoleyErrorHelper.getMessage(error,MainActivity.this),Toast.LENGTH_LONG).show();

        });
        //VolleySingleton.getInstance(MainActivity.this).addToRequestQueue(stringRequest);
    }
}**/