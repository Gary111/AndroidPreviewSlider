package com.igortyulkanov.previewslider.example.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.igortyulkanov.previewslider.R;
import com.igortyulkanov.previewslider.example.models.PhotoInfo;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PhotoViewFragment extends Fragment {

    private static final String EXTRA_KEY_PHOTO_INFO = "extra_key_photo_info";

    @Bind(R.id.photoView)
    ImageView photoView;

    private PhotoInfo photoInfo;

    public static PhotoViewFragment newInstance(@NonNull PhotoInfo photoInfo) {
        final PhotoViewFragment fragment = new PhotoViewFragment();

        final Bundle args = new Bundle();
        args.putSerializable(EXTRA_KEY_PHOTO_INFO, photoInfo);
        fragment.setArguments(args);

        return fragment;
    }

    public PhotoViewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        photoInfo = (PhotoInfo) getArguments().getSerializable(EXTRA_KEY_PHOTO_INFO);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_photo_view, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Picasso.with(getContext())
                .load(photoInfo.getUrl())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .into(photoView);
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }
}
