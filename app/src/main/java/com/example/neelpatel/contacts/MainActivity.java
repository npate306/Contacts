package com.example.neelpatel.contacts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String TAG = "Bad request";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView r1 = (RecyclerView) findViewById(R.id.recycle1);
        r1.setLayoutManager(new LinearLayoutManager(this));
        final RecyclerView r2 = (RecyclerView) findViewById(R.id.recycle2);
        r2.setLayoutManager(new LinearLayoutManager(this));
        CardView cardView = (CardView) findViewById(R.id.card_view);
        final ArrayList<Main> favs = new ArrayList<Main>();
        final ArrayList<Main> nonfavs = new ArrayList<Main>();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Main>> call = apiInterface.getInformation();
        call.enqueue(new Callback<List<Main>>() {
            @Override
            public void onResponse(Call<List<Main>> call, Response<List<Main>> response) {
                List<Main> main = response.body();
                for (int i = 0; i < main.size(); i++) {
                    if (main.get(i).getIsFavorite() == true) {
                        favs.add(main.get(i));
                    } else {
                        nonfavs.add(main.get(i));
                    }
                }
                r1.setAdapter(new MainAdapter(favs, R.layout.main_user, getApplicationContext()));
                r2.setAdapter(new MainAdapter(nonfavs, R.layout.main_user, getApplicationContext()));

            }
            @Override
            public void onFailure(Call<List<Main>> call, Throwable t) {
                Log.e(TAG, "Failed");
            }
        });
    }
}
