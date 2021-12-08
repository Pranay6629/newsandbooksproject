package com.monu.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.monu.newsapp.NewsInDetailActivity;
import com.monu.newsapp.R;
import com.monu.newsapp.parameter.Articles;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Locale;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {

    Context context;
    List<Articles> articles;


    public DataAdapter(Context context, List<Articles> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {


        SharedPreferences preferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean firstStart= preferences.getBoolean("firstStart", true);
        if (firstStart){
            createTableOnFirstStart();
        }


        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        DataHolder holder = new DataHolder(listItem);
        return holder;

    }



    @Override
    public void onBindViewHolder(@NonNull final DataHolder holder, final int position) {


        final Articles art =  articles.get(position);

//        readCursorData(art, holder);

        String url = art.getUrl();
        holder.newsTitle.setText(art.getTitle());
        holder.newsAuthor.setText(art.getAuthor());
        holder.newsDesp.setText(art.getDescription());
        String imageURL = art.getUrlToImage();
         Picasso.with(context).load(imageURL).into(holder.newsImage);


//        holder.favBnt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
                //int position = getAdapterPosition();
                //Articles articl = articles.get(position);

//                if (art.getFavStatus() != null && art.getFavStatus().equals("0")){
//                    art.setFavStatus("1");
//                    fabDB.insertIntoTheDatabase(art.getTitle(), art.getAuthor(), art.getDescription(), art.getUrl(), art.getUrlToImage(), art.getPublishedAt(), art.getContent(), "0");
//                    holder.favBnt.setBackgroundResource(R.drawable.ic_favorite_red_24);
//                }else {
//                    art.setFavStatus("0");
//                    fabDB.removeData(art.getId());
//                    holder.favBnt.setBackgroundResource(R.drawable.ic_favorite_gray_24);
//                }
//            }
//        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsInDetailActivity.class);
                intent.putExtra("url", art.getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        TextView newsTitle, newsDesp, newsAuthor;
        ImageView newsImage;
        CardView cardView;
        Button favBnt;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            newsTitle = itemView.findViewById(R.id.title);
            newsDesp = itemView.findViewById(R.id.discripton);
            newsAuthor = itemView.findViewById(R.id.author);
            newsImage =itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);


//            favBnt.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = getAdapterPosition();
//                    Articles articl = articles.get(position);
//
//                    if (articl.getFavStatus() != null && articl.getFavStatus().equals("0")){
//                        articl.setFavStatus("1");
//                        fabDB.insertIntoTheDatabase(articl.getTitle(), articl.getAuthor(), articl.getDescription(), articl.getUrl(), articl.getUrlToImage(), articl.getPublishedAt(), articl.getContent(), "0");
//                        favBnt.setBackgroundResource(R.drawable.ic_favorite_red_24);
//                    }else {
//                        articl.setFavStatus("0");
//                        fabDB.removeData(articl.getId());
//                        favBnt.setBackgroundResource(R.drawable.ic_favorite_gray_24);
//                    }
//                }
//            });


        }


    }

    private void createTableOnFirstStart() {
//        fabDB.insertEmpty();

        SharedPreferences preferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

    public String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }

//    private void readCursorData(Articles articles1, DataHolder dataHolder){
//        Cursor cursor = fabDB.readAllData(articles1.getId());
//        SQLiteDatabase db = fabDB.getReadableDatabase();
//        try {
//            while (cursor.moveToNext()){
//                String item_fav_status = cursor.getString(cursor.getColumnIndex(FabDB.KEY_FAVSTATUS));
//                articles1.setFavStatus(item_fav_status);
//
//                //check for status
//
//                if (item_fav_status != null && item_fav_status.equals("1")){
//                    dataHolder.favBnt.setBackgroundResource(R.drawable.ic_favorite_red_24);
//                }else if (item_fav_status != null && item_fav_status.equals("0")){
//                    dataHolder.favBnt.setBackgroundResource(R.drawable.ic_favorite_gray_24);
//                }
//            }
//        }
//        finally {
//            if (cursor != null && cursor.isClosed())
//                cursor.close();
//            db.close();
//        }
//    }
}
