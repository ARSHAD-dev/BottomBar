package com.example.bottomnavbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private MusicFragment musicFragment;
    private CartFragment cartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottombar);
        homeFragment=new HomeFragment();
        musicFragment=new MusicFragment();
        cartFragment=new CartFragment();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        bottomNavigationView.setItemBackgroundResource(R.color.home);
                        setOurFragment(homeFragment);
                        return  true;
                    case R.id.music:
                        bottomNavigationView.setItemBackgroundResource(R.color.music);
                        setOurFragment(musicFragment);
                        return true;
                    case R.id.cart:
                        bottomNavigationView.setItemBackgroundResource(R.color.cart);
                        setOurFragment(cartFragment);
                        return true;
                     default:
                    return false;
                }

            }
        });
    }
    public void setOurFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,fragment);
        fragmentTransaction.commit();

    }
}