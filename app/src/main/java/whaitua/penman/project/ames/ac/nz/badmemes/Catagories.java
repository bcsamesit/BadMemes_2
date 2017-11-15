package whaitua.penman.project.ames.ac.nz.badmemes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Catagories extends AppCompatActivity {

    private ImageView listBtn;
    private ImageView homeBtn;
    private Button CataGames;
    private Button Catapolitics;
    private Button cataedgy;
    private Button CataAnime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagories);

        homeBtn = (ImageView)findViewById(R.id.homeBtn);
        CataGames = (Button) findViewById(R.id.CataGame);
        Catapolitics = (Button) findViewById(R.id.CataPolitics);
        cataedgy = (Button) findViewById(R.id.CataEdgy);
        CataAnime = (Button) findViewById(R.id.CataAnime);

        homeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Catagories.this, MainActivity.class);
                startActivity(intent);}
        });

        CataGames.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Catagories.this, CataGames.class);
                startActivity(intent);
            }
        });

        CataAnime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Catagories.this, CataAnime.class);
                startActivity(intent);
            }
        });

        Catapolitics.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Catagories.this, CataPolitics.class);
                startActivity(intent);}
        });

        cataedgy.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                Intent intent = new Intent(Catagories.this, CataEdgy.class);
                startActivity(intent);}
        });

    }
}
