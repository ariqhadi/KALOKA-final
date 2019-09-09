package com.example.testflask;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int PICK_IMAGE = 1;
    private static final int PERMISSION_REQUEST_STORAGE = 2;

    private static final String TYPE_1 = "multipart";
    private static final String TYPE_2 = "base64";
    private static final int PICK_CAMERA = 2 ;

    private ImageView imgThumb;

    private Button btnChoose;
    private Button btnUpload1;
    private Button btnUpload2;
    private Button btnGallery;

    private TextView teks;
    private TextView teksDetail;

    private String getImageUrl = " ";
    private UploadService uploadService;
    private Uri uri;
    private String hasil = " ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSONObject json = new JSONObject();
        imgThumb = (ImageView) findViewById(R.id.img_thumb);
        btnChoose = (Button) findViewById(R.id.btn_choose);
        btnUpload1 = (Button) findViewById(R.id.btn_upload_1);
        btnUpload2 = (Button) findViewById(R.id.btn_upload_2);
        btnGallery = (Button) findViewById(R.id.btn_gallery);

        teks = (TextView) findViewById(R.id.textView);
        teksDetail = (TextView)findViewById(R.id.textView4);

        btnChoose.setOnClickListener(this);
        btnUpload1.setVisibility(View.GONE);;
        btnUpload2.setOnClickListener(this);
        btnGallery.setOnClickListener(this);

    }

    private void choosePhoto() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_STORAGE);

        }else{
            openGallery();
        }
    }

    public void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE);
    }

    public void openCamera(){
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//Start intent with Action_Image_Capture
        uri = CameraUtils.getOutputMediaFileUri(this);//get fileUri from CameraUtils
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);//Send fileUri with intent
        startActivityForResult(intent, PICK_CAMERA);
    }

    @Override
    public void onClick(View view) {
        if(view == btnChoose) {
            choosePhoto();
        }else if(view ==btnGallery){
            openCamera();
        }else if(view == btnUpload1) {
            if(uri != null) {
                File file = FileUtils.getFile(this, uri);
                uploadMultipart(file);
            }else{
                Toast.makeText(this, "You must choose the image", Toast.LENGTH_SHORT).show();
            }
        }else if(view == btnUpload2) {
            if(uri != null) {
                Bitmap bitmap = null;
                teks.setText("TUNGGU BENTAR maks 2 menit");
                teksDetail.setText("Kalo nunggu nya lama banget berati server nya mati");
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String encoded = ImageUtils.bitmapToBase64String(bitmap, 100);
                uploadBase64(encoded);
            }else{
                Toast.makeText(this, "You must choose the image", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void uploadMultipart(File file) {
        RequestBody photoBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part photoPart = MultipartBody.Part.createFormData("photo",
                file.getName(), photoBody);

        RequestBody action = RequestBody.create(MediaType.parse("text/plain"), TYPE_1);

        uploadService = new UploadService();
        uploadService.uploadPhotoMultipart(action, photoPart, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                BaseResponse baseResponse = (BaseResponse) response.body();

                if(baseResponse != null) {
                    Toast.makeText(MainActivity.this, baseResponse.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void uploadBase64(String imgBase64) {
        uploadService = new UploadService();
        uploadService.uploadPhotoBase64(TYPE_2, imgBase64, new Callback<pojo>() {
            @Override
            public void onResponse(Call <pojo> call, Response <pojo> response) {
                if(response.isSuccessful()) {
                    response.body();
                    String nama = response.body().getNama();
                    String detail = response.body().getDeskripsi();
                    teks.setText(nama);
                    teksDetail.setText(detail);
                }else{
                    Toast.makeText(MainActivity.this,response.errorBody().toString(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if(data != null) {
                uri = data.getData();
                imgThumb.setImageURI(uri);
            }
        }else if(requestCode == PICK_CAMERA && resultCode == Activity.RESULT_OK){
            try {
                //When image is captured successfully
                if (resultCode == RESULT_OK) {

                        //else we will get path directly
                        getImageUrl = uri.getPath();


                    //After image capture show captured image over image view
                    showCapturedImage();
                } else
                    Toast.makeText(this, "TIDAK BERHASIL", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showCapturedImage() {
        imgThumb.setImageBitmap(CameraUtils.convertImagePathToBitmap(getImageUrl, false));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    openGallery();
                }

                return;
            }
        }
    }

}
