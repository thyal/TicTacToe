package no.thomasfrivold.tictactoe.view.fragments;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import no.thomasfrivold.tictactoe.R;
import no.thomasfrivold.tictactoe.data.HTTP.HTTP_API;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "IMAGEFRAGMENT";
    private ImageView imageView;
    private Button btn_reload;

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
        btn_reload = v.findViewById(R.id.btn_reload_img);

        btn_reload.setOnClickListener(this);

        loadImg();
    }

    public void loadImg() {
        new HTTP_API(this, "https://picsum.photos/300?random");
    }


    public void setImageBitmap(Bitmap imageBitmap) {
        if(imageBitmap == null) {
            Log.d(TAG, "IMAGEBITMAP IS NULL HTTP REQUEST FAILED ");
            return;
        }
        Log.d(TAG, "setImageBitmap: " + imageBitmap.toString());

        this.imageView.setImageBitmap(imageBitmap);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();

        if(viewId == R.id.btn_reload_img) {
            loadImg();
        }
    }
}
