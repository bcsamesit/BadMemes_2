package whaitua.penman.project.ames.ac.nz.badmemes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.content.Intent;


public class CataAnimeList extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cata_anime_list);

        Intent intent = getIntent();

        //Selected image id
        int position = intent.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);
        imageView = (ImageView) findViewById(R.id.singleView);
        imageView.setImageResource(imageAdapter.animoo[position]);
    }
}
