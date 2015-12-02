package com.igortyulkanov.previewslider.example.ui.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.igortyulkanov.previewslider.R;
import com.igortyulkanov.previewslider.example.models.PhotoInfo;
import com.igortyulkanov.previewslider.example.models.PhotoInfosProvider;
import com.igortyulkanov.previewslider.example.ui.OnSyncPageChangeListener;
import com.igortyulkanov.previewslider.example.ui.adapters.PhotoPreviewAdapter;
import com.igortyulkanov.previewslider.example.ui.adapters.PhotoViewAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.photoPreviewPager)
    ViewPager photoPreviewPager;

    @Bind(R.id.photoViewPager)
    ViewPager photoViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final List<PhotoInfo> photoInfos = PhotoInfosProvider.generate();

        final PhotoPreviewAdapter photoPreviewAdapter = new PhotoPreviewAdapter(getSupportFragmentManager(), photoInfos);
        final PhotoViewAdapter photoViewAdapter = new PhotoViewAdapter(getSupportFragmentManager(), photoInfos);

        photoPreviewPager.setAdapter(photoPreviewAdapter);
        photoPreviewPager.addOnPageChangeListener(new OnSyncPageChangeListener(photoViewPager, photoPreviewPager));

        photoViewPager.setAdapter(photoViewAdapter);
        photoViewPager.setOffscreenPageLimit(photoPreviewAdapter.getSidePreviewCount() * 2 + 1);
        photoViewPager.addOnPageChangeListener(new OnSyncPageChangeListener(photoPreviewPager, photoViewPager));
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
