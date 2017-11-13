package whaitua.penman.project.ames.ac.nz.badmemes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Mymemes extends AppCompatActivity {

    private ImageView listBtn;
    private ImageView homeBtn;
    private ImageView starBtn;
    private Button mymemesBtn;
    private Button myfaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymemes);

        listBtn = (ImageView) findViewById(R.id.listBtn);
        homeBtn = (ImageView) findViewById(R.id.homeBtn);
        starBtn = (ImageView) findViewById(R.id.starBtn);
        mymemesBtn = (Button) findViewById(R.id.mymemesBtn);
        myfaveBtn = (Button) findViewById(R.id.myfaveBtn);

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mymemes.this, Catagories.class);
                startActivity(intent);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mymemes.this, MainActivity.class);
                startActivity(intent);}
        });

        starBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mymemes.this, Topmemes.class);
                startActivity(intent);
            }
        });

        mymemesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mymemes.this, Uploads.class);
                startActivity(intent);
            }
        });

        myfaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mymemes.this, Favorites.class);
                startActivity(intent);
            }
        });

    }
}
