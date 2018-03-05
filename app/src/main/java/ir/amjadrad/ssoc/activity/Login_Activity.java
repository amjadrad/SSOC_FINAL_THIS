package ir.amjadrad.ssoc.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ir.amjadrad.ssoc.R;
import ir.amjadrad.ssoc.helper.FontHelper;

/**
 * Created by Amjad Qasemie Rad on 3/4/2018.
 */

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    String tag = "Login_Activity__";

    private FontHelper fontHelper;
    private Typeface tfSahel;
    private AppCompatTextView tv1;
    private EditText etUsername , etPassword;
    private AppCompatButton btnLogin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            Intent intent = new Intent(Login_Activity.this , Main_Activity.class);
            intent.putExtra("logedin" , 1);
            startActivity(intent);


            setContentView(R.layout.activity_login);

            fontHelper = new FontHelper();
            tfSahel = fontHelper.getFont(this , FontHelper.fontSahel);

            tv1 = (AppCompatTextView) findViewById(R.id.tv1);
            etUsername = (EditText) findViewById(R.id.et_username);
            etPassword = (EditText) findViewById(R.id.et_password);
            btnLogin = (AppCompatButton) findViewById(R.id.btnLogin);
            tv1.setTypeface(tfSahel);
            etUsername.setTypeface(tfSahel);
            etPassword.setTypeface(tfSahel);
            btnLogin.setTypeface(tfSahel);
            btnLogin.setOnClickListener(this);





        }catch (Exception e){
            Log.i(tag , e.getLocalizedMessage());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:{
                String un = etUsername.getText().toString();
                String pw = etPassword.getText().toString();
                if(un.equals("1") && pw.equals("1")){
                    Intent intent = new Intent(Login_Activity.this , Main_Activity.class);
                    intent.putExtra("logedin" , 1);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "نام کاربری یا گذرواژه اشتباه", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }
}
