package ir.amjadrad.ssoc.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import ir.amjadrad.ssoc.R;
import ir.amjadrad.ssoc.helper.FontHelper;

/**
 * Created by Amjad Qasemie Rad on 3/4/2018.
 */

public class Main_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private int logedin = -1;
    private FontHelper fontHelper;
    private Typeface tfSahel;

    //______________________________________________________________

    private void checkLogin() {
        if (getIntent().hasExtra("logedin")) {
            logedin = getIntent().getExtras().getInt("logedin");
        }

        boolean login = false;
        if (logedin == -1) {
            startActivity(new Intent(Main_Activity.this, Login_Activity.class));
        }

    }

    //______________________________________________________________

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            checkLogin();
            setContentView(R.layout.activity_main);

            fontHelper = new FontHelper();
            tfSahel = fontHelper.getFont(this, FontHelper.fontSahel);
            initToolbar();
        }catch (Exception e){
            Log.i("main_create.........." , e.getLocalizedMessage());
        }

    }

    private void initToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView mToolBarTextView = (TextView) findViewById(R.id.text_view_toolbar_title);

        mToolBarTextView.setTypeface(tfSahel);
        mToolBarTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        mToolbar.setNavigationIcon(R.drawable.ic_vpn_key_black_24dp);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mToolBarTextView.setText("سامانه مدیریت انجمن ها");


        //SideNav
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_menu_24dp));
        toggle.syncState();
        drawer.setDrawerListener(toggle);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
