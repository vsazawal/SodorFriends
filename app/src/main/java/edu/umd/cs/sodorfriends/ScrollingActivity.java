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
import android.widget.Toast;

public class ScrollingActivity extends AppCompatActivity {

    private Cursor mCursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mCursor = contactDatabase(this);
        int name_index = mCursor.getColumnIndex(DBHelper.TB_COL1);
        int num_index = mCursor.getColumnIndex(DBHelper.TB_COL2);
        for (int i=0; i < mCursor.getCount(); i++) {
            String name = mCursor.getString(name_index);
            int num = mCursor.getInt(num_index);
            CharSequence text = name + ", engine #" + Integer.toString(num);
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
            mCursor.moveToNext();
        }

    }

    private Cursor contactDatabase(AppCompatActivity activity) {

        DBHelper dbhelper = new DBHelper(activity.getApplicationContext());
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        String[] projection = { DBHelper.TB_COL1, DBHelper.TB_COL2};
        // get everything
        Cursor c = db.query(DBHelper.TB_NAME, projection, null, null, null, null, null, null);
        return c;
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
