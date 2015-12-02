package com.igortyulkanov.previewslider.example.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.igortyulkanov.previewslider.example.models.PhotoInfo;
import com.igortyulkanov.previewslider.example.ui.fragments.PhotoViewFragment;

import java.util.List;

public class PhotoViewAdapter extends FragmentPagerAdapter {

    private final List<PhotoInfo> photoInfos;

    public PhotoViewAdapter(FragmentManager fm, List<PhotoInfo> photoInfos) {
        super(fm);
        this.photoInfos = photoInfos;
    }

    @Override
    public Fragment getItem(int position) {
        return PhotoViewFragment.newInstance(photoInfos.get(position));
    }

    @Override
    public int getCount() {
        return photoInfos.size();
    }
}