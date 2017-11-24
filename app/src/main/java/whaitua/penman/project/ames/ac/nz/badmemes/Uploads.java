package whaitua.penman.project.ames.ac.nz.badmemes;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/*
Function: Select one image and display it
Step 1: Open up the gallery to select an image
Step 2: Retrieve the  above image path (image uri) & fetch the image and display on ImageView
Step 3: Write the image uri into Shared Preferences ==> save the image for displaying later

Function: Display all the selected images from Gallery
+ Read all the image paths stored inside Shared preferences and display the corresponding image
*/


public class Uploads extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;

    private Button selectBtn, loadBtn;
    private ImageView selectedImage;
    public static final String SAVED_IMAGE = "SavedImage";
    //
    private InputStream imageStream;
    private Uri imageUri;
    private SharedPreferences saveImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploads);

        //

        selectedImage = (ImageView) findViewById(R.id.selectedImage);
        saveImg = getSharedPreferences(SAVED_IMAGE, 0);


       /* //Step 1: Open up Gallery and pick up an image
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);


                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

                startActivityForResult(chooserIntent, PICK_IMAGE);

            }
        });*/


        //Step 4: Display all selected images in Shared preferences


    }


    ///////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                Toast.makeText(getApplicationContext(), "No image", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                //Step 2: Display the selected image on ImageView
                imageUri = data.getData();
                //
                try {
                    imageStream = getContentResolver().openInputStream(imageUri);
                } catch (Exception e) {
                }
                Bitmap image = BitmapFactory.decodeStream(imageStream);
                selectedImage.setImageBitmap(image);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
            }

            //Step 3: Save the image to Shared Preferences



            //Write the "imageUri" into Shared Preferences




        }
    }


}
