package com.techies.firegram;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import UIFragments.CameraFragment;
import UIFragments.HomeFragment;
import UIFragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch(tabId){
                    case R.id.tab_home:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.contentContainer, new HomeFragment())
                                .commit();
                        break;
                    case R.id.tab_camera:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.contentContainer, new CameraFragment())
                                .commit();
                        break;
                    case R.id.tab_profile:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.contentContainer, new ProfileFragment())
                                .commit();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "None Selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
