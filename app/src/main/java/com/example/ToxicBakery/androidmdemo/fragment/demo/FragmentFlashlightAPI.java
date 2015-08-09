package com.example.ToxicBakery.androidmdemo.fragment.demo;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ToxicBakery.androidmdemo.R;

public class FragmentFlashlightAPI extends Fragment implements View.OnClickListener {

    private static final String TAG = "FragmentFlashlight";

    private static final String KEY_TORCH_REQUEST = "KEY_TORCH_REQUEST";

    private boolean torchRequest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            torchRequest = savedInstanceState.getBoolean(KEY_TORCH_REQUEST, false);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flashlight, container, false);

        view.findViewById(R.id.button_torch)
                .setOnClickListener(this);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean(KEY_TORCH_REQUEST, torchRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_torch:
                CameraManager cameraManager = (CameraManager) getActivity().getSystemService(Context.CAMERA_SERVICE);
                torchRequest = !torchRequest;
                try {
                    for (String id : cameraManager.getCameraIdList()) {
                        cameraManager.setTorchMode(id, torchRequest);
                    }
                } catch (CameraAccessException e) {
                    Log.e(TAG, "Failed to interact with camera.", e);
                    Toast.makeText(getActivity(), "Torch Failed: " + e.getMessage(), Toast.LENGTH_SHORT)
                            .show();
                }
                break;
        }
    }

}
