package com.example.administrator.jingritoutiaodukailin;

import android.graphics.Color;
import android.media.Image;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.jingritoutiaodukailin.Fragment.Fragment_care;
import com.example.administrator.jingritoutiaodukailin.Fragment.Fragment_discvoer;
import com.example.administrator.jingritoutiaodukailin.Fragment.Fragment_home;
import com.example.administrator.jingritoutiaodukailin.Fragment.Fragment_main;

import org.w3c.dom.Text;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ViewPager viewpage;
    private LinearLayout home;
    private LinearLayout discover;
    private LinearLayout care;
    private LinearLayout main;
    private Fragment_home f_home;
    private Fragment_discvoer f_discvoer;
    private Fragment_care f_care;
    private Fragment_main f_main;
    private FragmentManager manager;
    private ImageView image_home;
    private ImageView image_discover;
    private ImageView image_care;
    private ImageView image_main;
    private TextView tvhome;
    private TextView tvdiscover;
    private TextView tvcare;
    private TextView tvmain;
    private FrameLayout fl;
    private int a=0;
    private int s=0;
    private int d=0;
    private int f=0;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        tvinitview();
    }

    private void tvinitview() {
        image_home = (ImageView) findViewById(R.id.image_home);
        image_discover = (ImageView) findViewById(R.id.image_discover);
        image_care = (ImageView) findViewById(R.id.image_care);
        image_main = (ImageView) findViewById(R.id.image_main);
        tvhome = (TextView) findViewById(R.id.tvhome);
        tvdiscover = (TextView) findViewById(R.id.tvdiscover);
        tvcare = (TextView) findViewById(R.id.tvcare);
        tvmain = (TextView) findViewById(R.id.tvmain);
    }

    private void initview() {
        fl = (FrameLayout) findViewById(R.id.fl);
        home = (LinearLayout) findViewById(R.id.home);
        discover = (LinearLayout) findViewById(R.id.discover);
        care = (LinearLayout) findViewById(R.id.care);
        main = (LinearLayout) findViewById(R.id.main);
        home.setOnClickListener(this);
        discover.setOnClickListener(this);
        care.setOnClickListener(this);
        main.setOnClickListener(this);
        f_home = new Fragment_home();
        f_discvoer = new Fragment_discvoer();
        f_care = new Fragment_care();
        f_main = new Fragment_main();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.fl,f_home,"home").show(f_home);
        transaction.add(R.id.fl,f_discvoer,"discvoer").hide(f_discvoer);
        transaction.add(R.id.fl,f_care,"care").hide(f_care);
        transaction.add(R.id.fl,f_main,"main").hide(f_main);
        transaction.commit();




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home:
                FragmentManager manager1 = getSupportFragmentManager();
                FragmentTransaction transaction1 = manager1.beginTransaction();
              ;

                transaction1.show(f_home).hide(f_discvoer).hide(f_care).hide(f_main).commit();


                tvhome.setTextColor(Color.RED);
                tvdiscover.setTextColor(Color.BLUE);
                tvcare.setTextColor(Color.BLUE);
                tvmain.setTextColor(Color.BLUE);


                break;
            case  R.id.discover:
                FragmentManager manager2 = getSupportFragmentManager();
                FragmentTransaction transaction2 = manager2.beginTransaction();

                    transaction2.show(f_discvoer).hide(f_home).hide(f_care).hide(f_main).commit();
                    tvhome.setTextColor(Color.BLUE);
                    tvdiscover.setTextColor(Color.RED);
                    tvcare.setTextColor(Color.BLUE);
                    tvmain.setTextColor(Color.BLUE);


                break;
            case  R.id.care:
                FragmentManager manager3 = getSupportFragmentManager();
                FragmentTransaction transaction3 = manager3.beginTransaction();

                    transaction3.show(f_care).hide(f_discvoer).hide(f_home).hide(f_main).commit();
                    tvhome.setTextColor(Color.BLUE);
                    tvdiscover.setTextColor(Color.BLUE);
                    tvcare.setTextColor(Color.RED);
                    tvmain.setTextColor(Color.BLUE);


                break;
            case  R.id.main:
                FragmentManager manager4 = getSupportFragmentManager();
                FragmentTransaction transaction4 = manager4.beginTransaction();

                    transaction4.show(f_main).hide(f_discvoer).hide(f_care).hide(f_home).commit();
                    tvhome.setTextColor(Color.BLUE);
                    tvdiscover.setTextColor(Color.BLUE);
                    tvcare.setTextColor(Color.BLUE);
                    tvmain.setTextColor(Color.RED);



                break;

        }

    }
}
