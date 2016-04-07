package edu.umd.cs.sodorfriends;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity {

    private static SodorDB mDatabase;
    private ArrayList<Train> mTrains;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDatabase = new SodorDB(getApplicationContext());
        mTrains = mDatabase.getTrains();
        configureCards();


    }

    private void configureCards() {

        TextView name1 = (TextView)findViewById(R.id.name1);
        TextView num1 = (TextView)findViewById(R.id.num1);
        TextView name2 = (TextView)findViewById(R.id.name2);
        TextView num2 = (TextView)findViewById(R.id.num2);
        TextView name3 = (TextView)findViewById(R.id.name3);
        TextView num3 = (TextView)findViewById(R.id.num3);
        name1.setText(mTrains.get(0).getName());
        num1.setText("Train #" + Integer.toString(mTrains.get(0).getNumber()));
        name2.setText(mTrains.get(1).getName());
        num2.setText("Train #" + Integer.toString(mTrains.get(1).getNumber()));
        name3.setText(mTrains.get(2).getName());
        num3.setText("Train #" + Integer.toString(mTrains.get(2).getNumber()));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
