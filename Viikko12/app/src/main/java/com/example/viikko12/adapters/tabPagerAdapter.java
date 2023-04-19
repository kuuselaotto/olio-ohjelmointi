package com.example.viikko12.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viikko12.fragments.fragmentAdd;
import com.example.viikko12.fragments.fragmentFrontPage;
import com.example.viikko12.fragments.fragmentList;

public class tabPagerAdapter extends FragmentStateAdapter {
    public tabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new fragmentFrontPage();
            case 1:
                return new fragmentAdd();
            case 2:
                return new fragmentList();
            default:
                return new fragmentFrontPage();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
