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
    public static int[] animoo = {
            R.drawable.anime1, R.drawable.anime2, R.drawable.anime3, R.drawable.anime4,
            R.drawable.anime5, R.drawable.anime6, R.drawable.anime7, R.drawable.anime8, R.drawable.anime9,
            R.drawable.anime10, R.drawable.anime11, R.drawable.anime12, R.drawable.anime13, R.drawable.anime14,
            R.drawable.anime15, R.drawable.anime16, R.drawable.anime17, R.drawable.anime18, R.drawable.anime19,
            R.drawable.anime20,  R.drawable.anime21, R.drawable.anime22, R.drawable.anime23, R.drawable.anime24,
            R.drawable.anime25};

    public static int[] gameo = {
            R.drawable.game1, R.drawable.game2, R.drawable.game3, R.drawable.game4,
            R.drawable.game5, R.drawable.game6, R.drawable.game7, R.drawable.game8, R.drawable.game9,
            R.drawable.game10, R.drawable.game11, R.drawable.game12, R.drawable.game13, R.drawable.game14,
            R.drawable.game15, R.drawable.game16, R.drawable.game17, R.drawable.game18, R.drawable.game19,
            R.drawable.game20, R.drawable.game21, R.drawable.game22, R.drawable.game23, R.drawable.game24,
            R.drawable.game25};

    public static int[] politico = {
            R.drawable.poli1, R.drawable.poli2, R.drawable.poli3, R.drawable.poli4,
            R.drawable.poli5, R.drawable.poli6, R.drawable.poli7, R.drawable.poli8, R.drawable.poli9,
            R.drawable.poli10,  R.drawable.poli11, R.drawable.poli12, R.drawable.poli13, R.drawable.poli14,
            R.drawable.poli15, R.drawable.poli16, R.drawable.poli17, R.drawable.poli18, R.drawable.poli19,
            R.drawable.poli20, R.drawable.poli21, R.drawable.poli22, R.drawable.poli23, R.drawable.poli24,
            R.drawable.poli25};

    public static int[] sporto = {
            R.drawable.s1, R.drawable.s2, R.drawable.s3, R.drawable.s4,
            R.drawable.s5, R.drawable.s6, R.drawable.s7, R.drawable.s8, R.drawable.s9,
            R.drawable.s10,  R.drawable.s11, R.drawable.s12, R.drawable.s13, R.drawable.s14,
            R.drawable.s15, R.drawable.s16, R.drawable.s17, R.drawable.s18, R.drawable.s19,
            R.drawable.s20, R.drawable.s21, R.drawable.s22, R.drawable.s23, R.drawable.s24,
            R.drawable.s25};

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
            } else if(category.contains("Sports")) {
            imageView.setImageResource(sporto[position]);
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
        } else if(category.contains("Sports")) {
            imageNumber = sporto.length;
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
