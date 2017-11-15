package whaitua.penman.project.ames.ac.nz.badmemes;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context myContext;
    //ARRAY OF IMAGE
    public int[] animoo = {
            R.drawable.anime1, R.drawable.anime2, R.drawable.anime3, R.drawable.anime4,
            R.drawable.anime5, R.drawable.anime6, R.drawable.anime7, R.drawable.anime8, R.drawable.anime9,
            R.drawable.anime10
    };
    //CONSTRUCTER
    public ImageAdapter(Context context){
        myContext = context;
    }

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
        imageView.setImageResource(animoo[position]);
        return imageView;
    }
    @Override
    public int getCount(){
        return animoo.length;
    }
    @Override
    public Object getItem(int position){
        return null;
    }
    @Override
    public long getItemId(int position){
        return 0;
    }
}
