package com.igortyulkanov.previewslider.example.ui;

import android.support.v4.view.ViewPager;

public class OnSyncPageChangeListener implements ViewPager.OnPageChangeListener {

    private int scrollState = ViewPager.SCROLL_STATE_IDLE;

    private final ViewPager syncToViewPager;
    private final ViewPager syncWithViewPager;

    public OnSyncPageChangeListener(ViewPager syncToViewPager, ViewPager syncWithViewPager) {
        this.syncToViewPager = syncToViewPager;
        this.syncWithViewPager = syncWithViewPager;
    }

    @Override
    public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
        if (scrollState != ViewPager.SCROLL_STATE_IDLE) {
            final float ratio = calculateRatioForPosition(position);
            final float scrollX = syncWithViewPager.getScrollX();
            final float scrollY = syncWithViewPager.getScrollY();
            syncToViewPager.scrollTo((int) (scrollX * ratio), (int) scrollY);
        }
    }

    private float calculateRatioForPosition(int position) {
        final float syncToViewPagerWidth = syncToViewPager.getWidth();
        final float syncWithViewPagerWidth = syncWithViewPager.getWidth();

        final float syncToViewPagerElementWeight = syncToViewPager.getAdapter().getPageWidth(position);
        final float syncWithViewPagerElementWeight = syncWithViewPager.getAdapter().getPageWidth(position);

        final float syncToViewPagerElementsCount = (1.0f / syncToViewPagerElementWeight);
        final float syncWithViewPagerElementsCount = (1.0f / syncWithViewPagerElementWeight);

        final float syncToViewPagerElementWidth = syncToViewPagerWidth / syncToViewPagerElementsCount;
        final float syncWithViewPagerElementWidth = syncWithViewPagerWidth / syncWithViewPagerElementsCount;

        return syncToViewPagerElementWidth / syncWithViewPagerElementWidth;
    }

    @Override
    public void onPageSelected(final int position) {

    }

    @Override
    public void onPageScrollStateChanged(final int state) {
        scrollState = state;
        if (state == ViewPager.SCROLL_STATE_IDLE) {
            syncToViewPager.setCurrentItem(syncWithViewPager.getCurrentItem(), false);
        }
    }
}