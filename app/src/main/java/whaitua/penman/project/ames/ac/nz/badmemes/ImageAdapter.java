package whaitua.penman.project.ames.ac.nz.badmemes;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private Context myContext;
    public static String category = "Game";

    //ARRAY OF IMAGE
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

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //CONSTRUCTER
    public ImageAdapter(Context context) {
        myContext = context;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(myContext);
            imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
        } else {
            imageView = (ImageView) convertView;
        }

        if (category.contains("Animation")) {
            imageView.setImageResource(animoo[position]);

        } else if (category.contains("Game")) {
            imageView.setImageResource(gameo[position]);
        } else if(category.contains("Politics")) {
            imageView.setImageResource(politico[position]);
            }


        return imageView;

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public int getCount() {
        //
        int imageNumber = 0;
        //
        if (category.contains("Animation")) {
            imageNumber = animoo.length;
        } else if (category.contains("Game")) {
            imageNumber = gameo.length;
        } else if(category.contains("Politics")) {
            imageNumber = politico.length;
        }
        //
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
