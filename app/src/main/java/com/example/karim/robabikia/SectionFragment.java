package com.example.karim.robabikia;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class SectionFragment extends Fragment  {
// api key 2b211dc3274a4dfa96eb88676ca7830c

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new RecycleViewAdapter(getContext(), posts);

    }

    @Override
    public void onStart() {
        super.onStart();
        getData();
    }

    private  ArrayList<Post> posts = new ArrayList<>();
     RecycleViewAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_section, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return v;
    }

    private void getData() {
        String url = "https://newsapi.org/v2/top-headlines?category="+getCatgory()+"&country=us&apiKey=2b211dc3274a4dfa96eb88676ca7830c";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            parseJson(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(getContext()).addToRequestQueue(jsonObjectRequest);
    }

    private String getCatgory() {
       int index= news.index;
       Log.e("bbba",index+"");
        if (index==0){
            return "science";
        }
        if (index==1){
            return "business";
        }
        if (index==2){
            return "technology";
        }
        if (index==3){
            return "sports";
        }
        return null;
    }

    private void parseJson(JSONObject response) throws JSONException {
        JSONArray jsonArray = response.getJSONArray("articles");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
             posts.add(new Post(jsonObject.getString("title"),jsonObject.getString("description"),jsonObject.getString("publishedAt"),jsonObject.getString("urlToImage")));
        }
        adapter.notifyDataSetChanged();
    }


}

