package com.twwgames.clarp;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StartActivity extends ActionBarActivity {

    private ListView gamesListView;
    private ArrayList<Game> gamesList;
    private ArrayAdapter<Game> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
            .add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        gamesListView = (ListView) findViewById(R.id.games_list_view);
        gamesListView.setEmptyView(findViewById(R.id.empty_games_view));

        gamesListView.setOnItemClickListener(new OnItemClickListener() {

            // user clicks to go to a select screen where they can choose
            // to view any list
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                Intent intent = new Intent(StartActivity.this,
                        GameActivity.class);
                Game game = gamesList.get((int) id);
                intent.putExtra("game_id", game.getId());
                startActivity(intent);

            }
        });

        Game myGame = new Game("MyGame", 0, null, null);

        gamesList = new ArrayList<Game>();
        gamesList.add(0, myGame);

        arrayAdapter = new ArrayAdapter<Game>(this,
                android.R.layout.simple_list_item_1, gamesList);
        gamesListView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_main, container,
                    false);
            return rootView;
        }
    }

}
