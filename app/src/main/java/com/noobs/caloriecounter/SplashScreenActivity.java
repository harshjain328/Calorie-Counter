package com.noobs.caloriecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.noobs.caloriecounter.models.LoginReq;
import com.noobs.caloriecounter.models.LoginResp;
import com.noobs.caloriecounter.models.UserDetails;
import com.noobs.caloriecounter.rest.ApiClient;
import com.noobs.caloriecounter.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = "SplashScreen";
    Button reg,login,forgot;
    EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        reg=findViewById(R.id.btn_reg);
        login=findViewById(R.id.btn_login);
        forgot=findViewById(R.id.btn_forgot);
        user=findViewById(R.id.edEmail);
        pass=findViewById(R.id.edPass);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iReg=new Intent(SplashScreenActivity.this,RegPersonalActivity.class);
                startActivity(iReg);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent home = new Intent(SplashScreenActivity.this,HomeActivity.class);
                Log.i(TAG, "onClick:  test");
                ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
                LoginReq req = new LoginReq(user.getText().toString(),pass.getText().toString());
                final Call<LoginResp> getUserCall = service.getUser(req.getEmail(),req.getPass());
                getUserCall.enqueue(new Callback<LoginResp>() {
                    @Override
                    public void onResponse(Call<LoginResp> call, Response<LoginResp> response) {
                        if(response.isSuccessful()){
                            if(response.body().isStatus()) {
                                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
//                                home.putExtra("User Details",response.body().getUser());
                                startActivity(home);
                                finish();
                            }
                            else
                                Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<LoginResp> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Failure internal",Toast.LENGTH_SHORT).show();
                        Log.i(TAG, "onFailure: ",t);
                    }
                });
            }
        });
    }
}
