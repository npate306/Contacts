package com.example.neelpatel.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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
        final TextView sample = (TextView) findViewById(R.id.sample);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Main>> call = apiInterface.getInformation();
        call.enqueue(new Callback<List<Main>>() {
            @Override
            public void onResponse(Call<List<Main>> call, Response<List<Main>> response) {
                String s = response.body().get(0).getName();
                sample.setText(s);
            }

            @Override
            public void onFailure(Call<List<Main>> call, Throwable t) {

            }
        });
    }
}
