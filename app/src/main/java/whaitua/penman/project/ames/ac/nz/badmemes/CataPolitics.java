package whaitua.penman.project.ames.ac.nz.badmemes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class CataPolitics extends AppCompatActivity {

    private Button homebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cata_politics);

        homebtn = (Button) findViewById(R.id.homeBtn);

        homebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CataPolitics.this, MainActivity.class);
                startActivity(intent);}
        });

    }
}
