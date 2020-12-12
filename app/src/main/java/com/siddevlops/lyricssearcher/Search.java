package com.siddevlops.lyricssearcher;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Search#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Search extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Search() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Search.
     */
    // TODO: Rename and change types and number of parameters
    public static Search newInstance(String param1, String param2) {
        Search fragment = new Search();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    private Button btn_search;
    private EditText artist_et;
    private EditText title_et;
    private RequestQueue mQueue;
    private TextView lyrics_cv;

    private String title;
    private String artist;

    String s;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_search, container, false);

        btn_search = v.findViewById(R.id.btn_search);
        artist_et = v.findViewById(R.id.artist_et);
        lyrics_cv = v.findViewById(R.id.lyrics_cv);
        title_et = v.findViewById(R.id.title_et);

        mQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        //fetchPackages();

        lyrics_cv.setVerticalScrollBarEnabled(true);

        //artist = String.valueOf(artist_et.getText());
        //title = String.valueOf(title_et.getText());

        artist = artist_et.getText().toString();
        title = title_et.getText().toString();


        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
            //    jsonParse();
                // Toast.makeText(getActivity(),"s" + artist_et.getText().toString() + title_et.getText().toString(),Toast.LENGTH_SHORT).show();
                jsonParse();
            }
        });

        lyrics_cv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.lyrics_cv) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });

        lyrics_cv.setMovementMethod(new ScrollingMovementMethod());

        return v;

    }

    private void jsonParse() {
        artist = artist_et.getText().toString().trim().replaceAll("\\s","%20").toLowerCase();
        title =title_et.getText().toString().trim().replaceAll("\\s","%20").toLowerCase();

        //artist = artist_et.getText().toString().replaceAll("\\s","%20");
        //title = title_et.getText().toString().replaceAll("\\s","%20");

        String url = "https://api.lyrics.ovh/v1/"+artist+"/"+title;

        Log.i("requestedstring",url);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            s = response.optString("lyrics");
                            //String a = response.getString("lyrics");
                            //Toast.makeText(getActivity(),"->" + s,Toast.LENGTH_SHORT).show();
                            lyrics_cv.setText(s);
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