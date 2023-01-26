package com.pdg.WhatsApp.adapters;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.pdg.WhatsApp.fragments.CamaraFragment;
import com.pdg.WhatsApp.fragments.ChatFragment;
import com.pdg.WhatsApp.fragments.EstadoFragment;
import com.pdg.WhatsApp.fragments.LlamadaFragment;

import java.util.ArrayList;

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Fragment> fragmentArray;
    private int numberOfTabs;

    public MyViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numberOfTabs = behavior;
        fragmentArray = new ArrayList<>();
        fragmentArray.add(new CamaraFragment());
        fragmentArray.add(new ChatFragment());
        fragmentArray.add(new EstadoFragment());
        fragmentArray.add(new LlamadaFragment());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragmentArray.get(position);
    }

    @Override
    public int getCount() {
        return this.numberOfTabs;
    }
}