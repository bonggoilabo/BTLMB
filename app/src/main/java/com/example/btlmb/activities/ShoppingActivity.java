package com.example.btlmb.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.example.btlmb.R;
import com.example.btlmb.databinding.ActivityShoppingBinding;
import com.example.btlmb.fragments.shopping.CartFragment;
import com.example.btlmb.fragments.shopping.HomeFragment;
import com.example.btlmb.fragments.shopping.ProfileFragment;
import com.example.btlmb.fragments.shopping.SearchFragment;
public class ShoppingActivity extends AppCompatActivity {
    ActivityShoppingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShoppingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.homeFragment){
                replaceFragment(new HomeFragment());
            }
            if(item.getItemId() == R.id.searchFragment){
                replaceFragment(new SearchFragment());
            }
            if(item.getItemId() == R.id.cartFragment){
                replaceFragment(new CartFragment());
            }
            if(item.getItemId() == R.id.profileFragment){
                replaceFragment(new ProfileFragment());
            }
            return true;
            }
        );
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.host_fragment,fragment);
        fragmentTransaction.commit();
    }
}