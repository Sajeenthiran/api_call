package org.sajeenthiran.apicall;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IpService {

    @GET("avLogin/Get")
    Call<JsonArray> loginService(@Query("id") String id, @Query("password") String password, @Query("macaddress") String macaddress, @Query("versionnumber") String versionnumber, @Query("deviceid") String deviceid);

    @GET("users")
    Call<JsonArray> getAllUsers();

    @GET("v2/everything?q=Apple&from=2022-01-02&sortBy=popularity&apiKey=API_KEY")
    Call<JsonArray> getArticles();

    @GET("v2/everything")
    Call<JsonArray> getArticles(@Query("q") String q,@Query("from") String fromDate, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);

}
