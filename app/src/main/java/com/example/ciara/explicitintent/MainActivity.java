package com.example.ciara.explicitintent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    //Explicit Intent to Send Homepage to the New Activity - Send Mail

    public void sendMessage(View view){

        Intent startNewActivity = new Intent(this, FormActivity.class);
        startActivity(startNewActivity);

    }

    //Implicit Intent allowing homepage button to link to the phone's gallery

    public void sendGallery(View view){

        Intent startNewGallery = new Intent(this, MainActivity_Two.class);
        startActivity(startNewGallery);

    }

    Button btnpic;
    ImageView imgTakenPic;
    String mCurrentPhotoPath;
    private static final int CAM_REQUEST=1313;

    //Allowing the user take the picture, triggered by pressing button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        btnpic = (Button) findViewById(R.id.bttn1);
        imgTakenPic = (ImageView)findViewById(R.id.imageView);
        btnpic.setOnClickListener(new btnTakePhotoClicker());
    }

    //Detailing what to do with the image, this is where I tried to stop the iage defaulting to main activity but did not work

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAM_REQUEST){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgTakenPic.setImageBitmap(bitmap);
        }
    }

    class btnTakePhotoClicker implements  Button.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,CAM_REQUEST);
        }
    }

//    Tried to implment the below to save picture but did not work
//
//    private void galleryAddPic() {
//        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//        File f = new File(mCurrentPhotoPath);
//        Uri contentUri = Uri.fromFile(f);
//        mediaScanIntent.setData(contentUri);
//        this.sendBroadcast(mediaScanIntent);
//    }


}