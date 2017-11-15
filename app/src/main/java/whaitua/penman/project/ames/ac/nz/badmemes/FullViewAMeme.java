package whaitua.penman.project.ames.ac.nz.badmemes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;


public class FullViewAMeme extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullview_ameme_layout);

        Intent intent = getIntent();

        //Selected image id
        int position = intent.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);
        imageView = (ImageView) findViewById(R.id.singleView);

        //
        if (ImageAdapter.category.contains("Game")) {
            imageView.setImageResource(imageAdapter.gameo[position]);
        } else if (ImageAdapter.category.contains("Animation")) {
            imageView.setImageResource(imageAdapter.animoo[position]);
        } else if(ImageAdapter.category.contains("Politics")) {
            imageView.setImageResource(imageAdapter.politico[position]);
        }


    }
}
