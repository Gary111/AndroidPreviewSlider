package com.igortyulkanov.previewslider.example.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.igortyulkanov.previewslider.R;
import com.igortyulkanov.previewslider.example.models.PhotoInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PhotoPreviewFragment extends Fragment {

    private static final String EXTRA_KEY_PHOTO_INFO = "extra_key_photo_info";

    private static final DateFormat FORMAT_TITLE = new SimpleDateFormat("MMM", Locale.US);
    private static final DateFormat FORMAT_DESCRIPTION = new SimpleDateFormat("d, yyyy", Locale.US);

    @Bind(R.id.textPreviewTitle)
    TextView textPreviewTitle;

    @Bind(R.id.textPreviewDescription)
    TextView textPreviewDescription;

    private PhotoInfo photoInfo;

    public static PhotoPreviewFragment newInstance(@NonNull PhotoInfo photoInfo) {
        final PhotoPreviewFragment fragment = new PhotoPreviewFragment();

        final Bundle args = new Bundle();
        args.putSerializable(EXTRA_KEY_PHOTO_INFO, photoInfo);
        fragment.setArguments(args);

        return fragment;
    }

    public PhotoPreviewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        photoInfo = (PhotoInfo) getArguments().getSerializable(EXTRA_KEY_PHOTO_INFO);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_photo_preview, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textPreviewTitle.setText(FORMAT_TITLE.format(photoInfo.getDate()));
        textPreviewDescription.setText(FORMAT_DESCRIPTION.format(photoInfo.getDate()));
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }
}
