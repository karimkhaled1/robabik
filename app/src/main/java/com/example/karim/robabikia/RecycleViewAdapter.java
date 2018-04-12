package com.example.karim.robabikia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by karim on 9/03/2018.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<Post> posts ;

    public RecycleViewAdapter(Context context, ArrayList<Post> data) {
        this.context = context;
        this.posts = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_item,parent,false);
        MyViewHolder myHolder = new MyViewHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(posts.get(position).getTitle());
        holder.date.setText(posts.get(position).getData());
        Picasso.get().load(posts.get(position).getUrlToImage()).into(holder.imageView);
        Log.e("bla",posts.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title , date ;
        private ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            imageView=itemView.findViewById(R.id.image);
            date = (TextView) itemView.findViewById(R.id.date);

        }
    }
}