package com.pdg.WhatsApp.fragments;

import android.content.Intent;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pdg.WhatsApp.R;

public class CamaraFragment extends Fragment {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    Camera camera;
    public CamaraFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        safeCameraOpen(1);
        View view = inflater.inflate(R.layout.fragment_camara, container, false);
        return view;
    }

    private void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private boolean safeCameraOpen(int id) {
        boolean qOpened = false;

        try {
            releaseCameraAndPreview();
            camera = Camera.open(id);
            qOpened = (camera != null);
        } catch (Exception e) {
            Log.e(getString(R.string.app_name), "failed to open Camera");
            e.printStackTrace();
        }

        return qOpened;
    }

    private void releaseCameraAndPreview() {
        MediaRecorder preview = null;
        preview.setCamera(null);
        if (camera != null) {
            camera.release();
            camera = null;
        }
    }


}