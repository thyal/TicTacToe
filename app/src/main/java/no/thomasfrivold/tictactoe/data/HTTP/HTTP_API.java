package no.thomasfrivold.tictactoe.data.HTTP;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import no.thomasfrivold.tictactoe.view.fragments.ImageFragment;

public class HTTP_API {


    private final String mUrl;
    private ImageFragment imageFragment;


    public HTTP_API(ImageFragment imageFragment, String url) {
        this.imageFragment = imageFragment;
        this.mUrl = url;
        new SetImageAsync().execute(this.mUrl);
    }


    /**
     * Http get call on async thread to url to find a bitmap to set in the correct fragment
     */
    private class SetImageAsync extends AsyncTask<String, Void, Bitmap> {

        Bitmap img;

        @Override
        protected Bitmap doInBackground(String... imgUrl) {

            if (imgUrl.length <= 0) throw new IllegalArgumentException();


            return getImage(imgUrl[0]);
        }

        private Bitmap getImage(String imageUrl) {

            //  https://stackoverflow.com/questions/11950042/android-how-to-make-a-http-request-to-get-image-link-for-imageview

            try {

                img = BitmapFactory.decodeStream((InputStream) new URL(imageUrl).getContent());

                return img;

            } catch (IOException e) {

                e.printStackTrace();

            }


            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

            if (imageFragment !=null) {
                imageFragment.setImageBitmap(img);
            }
        }
    }
}