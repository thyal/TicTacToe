package no.thomasfrivold.tictactoe.view;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.InputStream;

import no.thomasfrivold.tictactoe.R;
import no.thomasfrivold.tictactoe.data.HTTP_API;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {

    private static final String TAG = "IMAGEFRAGMENT";
    private ImageView imageView;

    public ImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_image, container, false);
        initWidgets(v);
        return v;
    }

    private void initWidgets(View v) {
        imageView = v.findViewById(R.id.imageView);
        new HTTP_API(this, "https://picsum.photos/200?random");
    }


    public void setImageBitmap(Bitmap imageBitmap) {
        if(imageBitmap == null) {
            Log.d(TAG, "IMAGEBITMAP IS NULL HTTP REQUEST FAILED ");
            return;
        }
        Log.d(TAG, "setImageBitmap: " + imageBitmap.toString());

        this.imageView.setImageBitmap(imageBitmap);
    }
}
