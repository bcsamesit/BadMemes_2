package whaitua.penman.project.ames.ac.nz.badmemes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Favorites extends AppCompatActivity {


    private GridView memeGrid;
    //
    private int numberOfFave = 1;
    private String[] savedmeme;

    public int[] savedMemeArray;
    private String selectedCategory;
    private int arrayIndex;


    private SharedPreferences savedMemes;

    //////////////////////////////////////////////////////////////////////////
    /*
     FINAL TASKS;

    FACEBOOK SDK

    SHARED PREFERENCE FOR UPLOAD
     */
    //////////////////////////////////////////////////////////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);


        /////////////////////////////////////////////////////////////////////////////////////////
        savedMemes = getSharedPreferences(FullViewAMeme.SAVED_MEMES, 0);

        savedmeme = savedMemes.getString("faveMeme", "").split("\\|");


        //How many save memes
        numberOfFave = savedmeme.length;


        ////////////////////////////////////////////////////////////////////////////////////////////
        savedMemeArray = new int[savedmeme.length];
        //Loop through all the elements in the "savedmeme" array of string
        int index = 0;
        for (String meme : savedmeme) {

            if (meme.split(",").length < 2) {

            } else {
                String category = meme.split(",")[0].toString();
                String arrayIndexStr = meme.split(",")[1].toString();
                int arrayIndex = Integer.parseInt(arrayIndexStr);

                //Build the array of saved meme
                if (category.contains("Animation")) {
                    savedMemeArray[index] = ImageAdapter.animoo[arrayIndex];
                    index++;
                } else if (category.contains("Game")) {
                    savedMemeArray[index] = ImageAdapter.gameo[arrayIndex];
                    index++;
                } else if (category.contains("Politics")) {
                    savedMemeArray[index] = ImageAdapter.politico[arrayIndex];
                    index++;
                } else if (category.contains("Sports")) {
                    savedMemeArray[index] = ImageAdapter.sporto[arrayIndex];
                    index++;
                }
            }
        }


        memeGrid = (GridView) findViewById(R.id.gridviewFave);
        memeGrid.setAdapter(new FaveAdapter(this));

        ////////////////////////////////////////////////////////////////////////////////////////////
        memeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //
                String clickedMeme = savedmeme[position];
                String category = clickedMeme.split(",")[0].toString();
                String arrayIndexStr = clickedMeme.split(",")[1].toString();
                int arrayIndex = Integer.parseInt(arrayIndexStr);


                //Send intent to FullViewAMeme Activity
                Intent intent = new Intent(getApplicationContext(), FullViewAMeme.class);
                //Pass image index by putExtra
                intent.putExtra("id", arrayIndex);
                intent.putExtra("category", category);
                intent.putExtra("from", "Favorites");
                //StartActivity
                startActivity(intent);

            }
        });
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public class FaveAdapter extends BaseAdapter {
        //ARRAY OF IMAGE
        /*
        public int[] animoo = {
                R.drawable.anime1, R.drawable.anime2, R.drawable.anime3, R.drawable.anime4,
                R.drawable.anime5, R.drawable.anime6, R.drawable.anime7, R.drawable.anime8, R.drawable.anime9,
                R.drawable.anime10};

        public int[] gameo = {
                R.drawable.game1, R.drawable.game2, R.drawable.game3, R.drawable.game4,
                R.drawable.game5, R.drawable.game6, R.drawable.game7, R.drawable.game8, R.drawable.game9,
                R.drawable.game10};

        public int[] politico = {
                R.drawable.poli1, R.drawable.poli2, R.drawable.poli3, R.drawable.poli4,
                R.drawable.poli5, R.drawable.poli6, R.drawable.poli7, R.drawable.poli8, R.drawable.poli9,
                R.drawable.poli10};
                */

        //public int[] savedMemeArray;


        ////////////////////////////////////////////////////////////////////////////////////////////////
        //CONSTRUCTER
        public FaveAdapter(Context context) {
            context = getApplicationContext();
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView;
            //
            if (convertView == null) {
                imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(0, 0, 0, 0);
            } else {
                imageView = (ImageView) convertView;
            }
            //////////////////////////////////////////////////////////////////////////////
            imageView.setImageResource(savedMemeArray[position]);

            return imageView;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////
        @Override
        public int getCount() {
            //
            int imageNumber = 0;
            imageNumber = numberOfFave;
            return imageNumber;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////
        @Override
        public Object getItem(int position) {
            return null;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////
        @Override
        public long getItemId(int position) {
            return 0;
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onStart() {
        super.onStart();

        savedmeme = savedMemes.getString("faveMeme", "").split("\\|");

        //
        //How many save memes
        numberOfFave = savedmeme.length;


        ////////////////////////////////////////////////////////////////////////////////////////////

        savedMemeArray = new int[savedmeme.length];
        //Loop through all the elements in the "savedmeme" array of string
        int index = 0;
        for (String meme : savedmeme) {
            String category = meme.split(",")[0].toString();

            if (meme.split(",").length < 2) {

            } else {
                String arrayIndexStr = meme.split(",")[1].toString();
                int arrayIndex = Integer.parseInt(arrayIndexStr);

                //Build the array of saved meme

                if (category.contains("Animation")) {
                    savedMemeArray[index] = ImageAdapter.animoo[arrayIndex];
                    index++;
                } else if (category.contains("Game")) {
                    savedMemeArray[index] = ImageAdapter.gameo[arrayIndex];
                    index++;
                } else if (category.contains("Politics")) {
                    savedMemeArray[index] = ImageAdapter.politico[arrayIndex];
                    index++;
                } else if (category.contains("Sports")) {
                    savedMemeArray[index] = ImageAdapter.sporto[arrayIndex];
                    index++;
                }
            }


        }

        memeGrid = (GridView) findViewById(R.id.gridviewFave);
        memeGrid.setAdapter(new FaveAdapter(this));
    }
}
