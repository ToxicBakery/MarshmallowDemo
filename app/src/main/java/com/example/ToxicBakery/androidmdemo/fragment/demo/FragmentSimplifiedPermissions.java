package com.example.ToxicBakery.androidmdemo.fragment.demo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ToxicBakery.androidmdemo.R;

public class FragmentSimplifiedPermissions extends Fragment implements View.OnClickListener {

    private static final int REQUEST_CONTACT = 1;
    private static final String[] PERMISSIONS = {
            Manifest.permission.READ_CONTACTS
    };

    private View permissionGranted;
    private View requestPermission;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_request_permission, container, false);

        permissionGranted = view.findViewById(R.id.permission_granted);

        requestPermission = view.findViewById(R.id.request_permission);
        requestPermission.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.request_permission:
                getActivity().requestPermissions(
                        PERMISSIONS
                        , REQUEST_CONTACT
                );
                checkPermissions();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        checkPermissions();
    }

    private void checkPermissions() {
        boolean hasAllPermissions = true;
        for (String permission : PERMISSIONS) {
            final int result = getActivity().checkSelfPermission(permission);
            if (result != PackageManager.PERMISSION_GRANTED) {
                hasAllPermissions = false;
                break;
            }
        }

        permissionGranted.setVisibility(hasAllPermissions ? View.VISIBLE : View.GONE);
        requestPermission.setVisibility(hasAllPermissions ? View.GONE : View.VISIBLE);
    }

}
