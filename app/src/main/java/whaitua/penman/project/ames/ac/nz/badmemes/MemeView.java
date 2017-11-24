package whaitua.penman.project.ames.ac.nz.badmemes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;


public class MemeView extends AppCompatActivity {
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private String category = "";
    private ImageView backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memeview_layout);


        ///////////////////////////////////////////////////////////////////////
        //Extract the data associated with Intent
        category = getIntent().getExtras().getString("Category");


        ///////////////////////////////////////////////////////////////////////
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Send intent to SingleViewActivity
                Intent intent = new Intent(getApplicationContext(), FullViewAMeme.class);
                //Pass image index by putExtra
                intent.putExtra("id", position);
                intent.putExtra("from", "MemeView");
                //StartActivity
                startActivity(intent);

            }
        });


    }
}







