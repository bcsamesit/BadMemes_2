package whaitua.penman.project.ames.ac.nz.badmemes;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;

import java.io.FileNotFoundException;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.net.URI;


public class FullViewAMeme extends AppCompatActivity {
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private int position = 0;
    private String fromStr = "MemeView";
    private String category = "Game";

    private ImageView imageView;
    private ImageView backBtn;
    private ImageView saveMeme;
    private SharedPreferences savedMemes;
    public static final String SAVED_MEMES = "SavedMemes";

    //public Uri imagePath;
    String imagePathStr = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullview_ameme_layout);


        saveMeme = (ImageView) findViewById(R.id.starBtn);
        savedMemes = getSharedPreferences(SAVED_MEMES, 0);

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        Intent beep = getIntent();

        //Selected image id
        position = beep.getExtras().getInt("id");
        //Extract the "from" info
        fromStr = beep.getExtras().getString("from").toString();

        ImageAdapter imageAdapter = new ImageAdapter(this);
        imageView = (ImageView) findViewById(R.id.singleView);

        //imagePath = Uri.parse("android.resource://whaitua.penman.project.ames.ac.nz.badmemes/" + R.drawable.sample_1);
        imagePathStr = "android.resource://whaitua.penman.project.ames.ac.nz.badmemes/";

        if (fromStr.contains("MemeView")) {
            //
            if (ImageAdapter.category.contains("Game")) {
                imageView.setImageResource(imageAdapter.gameo[position]);
                imagePathStr = imagePathStr + imageAdapter.gameo[position];
            } else if (ImageAdapter.category.contains("Animation")) {
                imageView.setImageResource(imageAdapter.animoo[position]);
                imagePathStr = imagePathStr + imageAdapter.animoo[position];
            } else if (ImageAdapter.category.contains("Politics")) {
                imageView.setImageResource(imageAdapter.politico[position]);
                imagePathStr = imagePathStr + imageAdapter.politico[position];
            } else if (ImageAdapter.category.contains("Sports")) {
                imageView.setImageResource(imageAdapter.sporto[position]);
                imagePathStr = imagePathStr + imageAdapter.sporto[position];
            }
        } else {
            category = beep.getExtras().getString("category").toString();
            if (category.contains("Game")) {
                imageView.setImageResource(imageAdapter.gameo[position]);
                imagePathStr = imagePathStr + imageAdapter.gameo[position];
            } else if (category.contains("Animation")) {
                imageView.setImageResource(imageAdapter.animoo[position]);
                imagePathStr = imagePathStr + imageAdapter.animoo[position];
            } else if (category.contains("Politics")) {
                imageView.setImageResource(imageAdapter.politico[position]);
                imagePathStr = imagePathStr + imageAdapter.politico[position];
            } else if (category.contains("Sports")) {
                imageView.setImageResource(imageAdapter.sporto[position]);
                imagePathStr = imagePathStr + imageAdapter.sporto[position];
            }

        }


        ////////////////////////////////////////////////////////////////////////////////////////////
        saveMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Save the meme information: category and array index
                String memeInfo = ImageAdapter.category + "," + position + "|";

                SharedPreferences.Editor memeEdit = savedMemes.edit();


                //Come back to ask dan
                String allMemes = savedMemes.getString("faveMeme", "");


                if (allMemes.length() > 0) {
                    String appendValue = allMemes + memeInfo;
                    memeEdit.putString("faveMeme", appendValue);
                    memeEdit.commit();
                } else {
                    memeEdit.putString("faveMeme", memeInfo);
                    memeEdit.commit();
                }
                finish();
            }
        });

        ////////////////////////////////////////////////////////////////////////////////////////////
        ImageView shareBtn = (ImageView) findViewById(R.id.shareBtn);
        shareBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //image uri
                //imagePath = Uri.parse("android.resource://whaitua.penman.project.ames.ac.nz.badmemes/" + R.drawable.sample_1);

                Uri imagePath = Uri.parse(imagePathStr);
                // share image
                shareImage(imagePath);
            }
        });

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    private void shareImage(Uri imagePath) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        sharingIntent.setType("image/*");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, imagePath);
        startActivity(Intent.createChooser(sharingIntent, "Share Image Using"));
    }


}




