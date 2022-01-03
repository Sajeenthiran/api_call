package org.sajeenthiran.apicall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginService();
        userService();

    }

    void loginService(){
        HandleApiRespone handleApiRespone = new HandleApiRespone(this,"http://www.axienta.lk/VantageCoreWebAPI/api/");
        handleApiRespone.login("22612", "12345", new HandleApiRespone.CallBackDelegate() {
            @Override
            public void onResponseSuccess(String result) {
                Log.e("login", "result "+result);
            }
        });
    }

    void userService(){
        HandleApiRespone handleApiRespone = new HandleApiRespone(this,"https://jsonplaceholder.typicode.com/");
        handleApiRespone.getAllUsers( new HandleApiRespone.CallBackUsersDelegate() {
            @Override
            public void onResponseSuccess(List<UserModel> userModelList) {
                Log.e("getAllUsers", "result "+userModelList.size());
                for (UserModel userModel : userModelList){
                    Log.e("getAllUsers", "userModel "+userModel.getName());
                }
            }
        });
    }
}