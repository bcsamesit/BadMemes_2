package whaitua.penman.project.ames.ac.nz.badmemes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Catagories extends AppCompatActivity {

    private ImageView listBtn;
    private ImageView homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagories);

        homeBtn = (ImageView)findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Catagories.this, MainActivity.class);
                startActivity(intent);}
        });
    }
}
