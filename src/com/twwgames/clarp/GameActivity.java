package com.twwgames.clarp;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class GameActivity extends ActionBarActivity {

    private static final String LOG_TAG = "GameActivity";

    private ListView messageListView;
    private ArrayList<Message> messageList;
    private ArrayAdapter<Message> arrayAdapter;
    private Message myMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
            .add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        //        myMessage = new Message("hello friend", "http://people.ucsc.edu/~bkwest/Alchemy/charmander.png");
        //        new DownloadImageTask((ImageView) findViewById(R.id.image))
        //        .execute(myMessage.getImage());
    }

    public void sendMessage(View v) {
        Log.d(LOG_TAG, "The button has been pressed");
        EditText messageEditText = (EditText) findViewById(R.id.message_edit_text);
        String messageText = messageEditText.getText().toString();
        Message newMessage = new Message();
        newMessage.setText(messageText);
        //newMessage.setImage(myMessage.getImage());
        messageList.add(newMessage);
        Log.d(LOG_TAG, "The length of the list now is " + messageList.size());
        arrayAdapter.notifyDataSetChanged();

        // Clears the entry text.
        messageEditText.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_game, container,
                    false);
            return rootView;
        }
    }


    //    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    //        ImageView bmImage;
    //
    //        public DownloadImageTask(ImageView bmImage) {
    //            this.bmImage = bmImage;
    //        }
    //
    //        @Override
    //        protected Bitmap doInBackground(String... urls) {
    //            String urldisplay = urls[0];
    //            Bitmap mIcon11 = null;
    //            try {
    //                InputStream in = new java.net.URL(urldisplay).openStream();
    //                mIcon11 = BitmapFactory.decodeStream(in);
    //            } catch (Exception e) {
    //                Log.e("Error", e.getMessage());
    //                e.printStackTrace();
    //            }
    //            return mIcon11;
    //        }
    //
    //        @Override
    //        protected void onPostExecute(Bitmap result) {
    //            bmImage.setImageBitmap(result);
    //        }
    //    }
}
