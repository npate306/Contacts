package com.example.neelpatel.contacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Neel Patel on 9/26/2017.
 */

public interface ApiInterface {

    @GET("technical-challenge/v3/contacts.json")
    Call<List<Main>> getInformation();
}
