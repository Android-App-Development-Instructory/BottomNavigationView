package com.alaminkarno.bottomnavigation.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.alaminkarno.bottomnavigation.R;
import com.alaminkarno.bottomnavigation.fragments.AboutFragment;
import com.alaminkarno.bottomnavigation.fragments.CartFragment;
import com.alaminkarno.bottomnavigation.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        implementBottomNavigation();

        replaceFragment(new HomeFragment());
    }

    private void implementBottomNavigation() {

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        replaceFragment(new HomeFragment());
                        return true;
                    case R.id.nav_cart:
                        replaceFragment(new CartFragment());
                        return true;
                    case R.id.nav_about:
                        replaceFragment(new AboutFragment());
                        return true;
                }
                return false;
            }
        });
    }

    private void replaceFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
    }

    private void init() {

        bottomNavigationView = findViewById(R.id.bottomNavigation);
    }

    @Override
    public void onBackPressed() {

        if(bottomNavigationView.getSelectedItemId() == R.id.nav_about || bottomNavigationView.getSelectedItemId() == R.id.nav_cart){

            replaceFragment(new HomeFragment());

            bottomNavigationView.setSelectedItemId(R.id.nav_home);

        }
        else {

            super.onBackPressed();
        }

    }
}