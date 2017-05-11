package com.wnascimento.com.me_adote_mob.util;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import com.wnascimento.com.me_adote_mob.R;


public class PermissionHelper {

    public static final int PERMISSIONS_REQUEST_TAKE_PICTURE = 0;

    public static void checkTakePicturePermissionDenied(Activity activity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA) ||
                ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(R.string.permission_take_picture_title)
                    .setMessage(R.string.permission_take_picture_message)
                    .setPositiveButton(R.string.permission_take_picture_action, (dialog, which) -> requestPermissionTakePicture(activity))
                    .show();

        } else {
            requestPermissionTakePicture(activity);
        }
    }

    private static void requestPermissionTakePicture(Activity activity) {
        ActivityCompat.requestPermissions(activity,
                new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                PERMISSIONS_REQUEST_TAKE_PICTURE);
    }

    public static boolean hasPermissionTakePicture(Context context) {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                        PackageManager.PERMISSION_GRANTED;
    }

}
