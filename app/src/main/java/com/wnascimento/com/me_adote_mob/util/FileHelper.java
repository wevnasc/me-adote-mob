package com.wnascimento.com.me_adote_mob.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class FileHelper {

    public static String saveBitmap(Context context, Bitmap imageBitmap) throws IOException {
        FileOutputStream fStream = null;
        File file = new File(Environment.getExternalStorageDirectory().toString(), UUID.randomUUID().toString());
        fStream = new FileOutputStream(file);

        if (imageBitmap != null) {

            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fStream);
            fStream.flush();
            fStream.close();

            MediaStore.Images.Media.insertImage(context.getContentResolver(),
                    file.getAbsolutePath(), file.getName(), file.getName());

        }
        return file.getAbsolutePath();
    }
}
