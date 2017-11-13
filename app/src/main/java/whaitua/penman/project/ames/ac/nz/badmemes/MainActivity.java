package whaitua.penman.project.ames.ac.nz.badmemes;


import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView listBtn;
    private ImageView mainBtn;
    private ImageView starBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listBtn = (ImageView) findViewById(R.id.listBtn);
        mainBtn = (ImageView) findViewById(R.id.mainBtn);
        starBtn = (ImageView) findViewById(R.id.starBtn);

        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Catagories.class);
                startActivity(intent);
            }
        });
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Topmemes.class);
                startActivity(intent);
            }
        });

        starBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Mymemes.class);
                startActivity(intent);
            }
        });


    }


}





