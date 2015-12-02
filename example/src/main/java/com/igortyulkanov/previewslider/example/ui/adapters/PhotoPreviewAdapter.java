package com.igortyulkanov.previewslider.example.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.igortyulkanov.previewslider.example.models.PhotoInfo;
import com.igortyulkanov.previewslider.example.ui.fragments.DummyPreviewFragment;
import com.igortyulkanov.previewslider.example.ui.fragments.PhotoPreviewFragment;

import java.util.List;

public class PhotoPreviewAdapter extends FragmentPagerAdapter {

    private static final int DEFAULT_SIDE_PREVIEW_COUNT = 3;

    private final int sidePreviewCount;

    private final List<PhotoInfo> photoInfos;

    public PhotoPreviewAdapter(FragmentManager fm, List<PhotoInfo> photoInfos) {
        this(fm, DEFAULT_SIDE_PREVIEW_COUNT, photoInfos);
    }

    public PhotoPreviewAdapter(FragmentManager fm, int sidePreviewCount, List<PhotoInfo> photoInfos) {
        super(fm);
        this.sidePreviewCount = sidePreviewCount;
        this.photoInfos = photoInfos;
    }

    public int getSidePreviewCount() {
        return sidePreviewCount;
    }

    @Override
    public Fragment getItem(int position) {
        if (isDummy(position)) {
            return DummyPreviewFragment.newInstance();
        } else {
            return PhotoPreviewFragment.newInstance(photoInfos.get(getRealPosition(position)));
        }
    }

    private boolean isDummy(int position) {
        return position < sidePreviewCount || position > photoInfos.size() - 1 + sidePreviewCount;
    }

    private int getRealPosition(int position) {
        return position - sidePreviewCount;
    }

    @Override
    public int getCount() {
        return photoInfos.size() + (sidePreviewCount * 2);
    }

    @Override
    public float getPageWidth(int position) {
        return 1.0f / getElementsPerPage();
    }

    private int getElementsPerPage() {
        return (sidePreviewCount * 2) + 1;
    }
}