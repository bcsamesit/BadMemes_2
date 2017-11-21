package whaitua.penman.project.ames.ac.nz.badmemes;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class FullViewAMeme extends AppCompatActivity {
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private int position = 0;
    private String fromStr = "MemeView";
    private String category = "Game";
    //
    private ImageView removeBtn;
    public int[] savedMemeArray;
    private String[] savedmeme;

    private ImageView imageView;
    private ImageView saveMeme;
    private SharedPreferences savedMemes;
    public static final String SAVED_MEMES = "SavedMemes";

    //public Uri imagePath;
    String imagePathStr = "";


    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullview_ameme_layout);

        ////////////////////////////////////////////////////////////////////////////////////////////
        ImageView shareBtn = (ImageView) findViewById(R.id.shareBtn);
        removeBtn = (ImageView) findViewById(R.id.removeBtn);
        saveMeme = (ImageView) findViewById(R.id.starBtn);


        ////////////////////////////////////////////////////////////////////////////////////////////
        savedMemes = getSharedPreferences(SAVED_MEMES, 0);
        savedmeme = savedMemes.getString("faveMeme", "").split("\\|");

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
        shareBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Drawable mDrawable = imageView.getDrawable();
                Bitmap mBitmap = ((BitmapDrawable) mDrawable).getBitmap();

                Uri uri = Uri.parse("http://www.google.com");
                String path = MediaStore.Images.Media.insertImage(getContentResolver(), mBitmap, "Image I want to share", null);

                if (path != null) {
                    uri = Uri.parse(path);
                }

                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                shareIntent.setType("image/*");
                startActivity(Intent.createChooser(shareIntent, "Share Image"));

                /*
                //image uri
                //imagePath = Uri.parse("android.resource://whaitua.penman.project.ames.ac.nz.badmemes/" + R.drawable.sample_1);

                Uri imagePath = Uri.parse(imagePathStr);
                // share image
                shareImage(imagePath);
                */
            }
        });


        //If the meme image is in the favorite list, hide the "add" button
        if (fromStr.contains("MemeView")) {
            //Hide the "remove" button, set visible the "add" button
            removeBtn.setVisibility(View.INVISIBLE);
            saveMeme.setVisibility(View.VISIBLE);
        } else {
            //Hide the "add" button, visible "remove" button
            removeBtn.setVisibility(View.VISIBLE);
            saveMeme.setVisibility(View.INVISIBLE);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        //Click "remove fav" button
        removeBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Remove the fave meme
                /////////////////////////////////////////////////////////////////////////////////////////
                final SharedPreferences memeList = getSharedPreferences(SAVED_MEMES, 0);
                //Read all the memes in the fav list and split into a String array
                String[] memeArray = memeList.getString("faveMeme", "").split("\\|");

                /////
                final StringBuilder memeBuild = new StringBuilder("");
                for (String meme : memeArray) {
                    String categoryRemove = meme.split(",")[0].toString();
                    String arrayIndexStr = meme.split(",")[1].toString();
                    int arrayIndex = Integer.parseInt(arrayIndexStr);

                    if (category.contains(categoryRemove) && (position == arrayIndex)) {
                        //Do nothing ==> don't append it to the list of fave
                        Toast.makeText(getApplicationContext(), "Remove Favorite meme: " + meme, Toast.LENGTH_SHORT).show();
                    } else {
                        memeBuild.append(meme + "|");
                    }

                }

                Toast.makeText(getApplicationContext(), "The new fave list: " + memeBuild, Toast.LENGTH_SHORT).show();

                //Rewrite the new list of fave into Shared Preferences
                SharedPreferences.Editor memeEdit = savedMemes.edit();
                memeEdit.putString("faveMeme", memeBuild.toString());
                memeEdit.commit();
                finish();


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




