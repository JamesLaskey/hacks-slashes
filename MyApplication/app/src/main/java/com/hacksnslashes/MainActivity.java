package com.hacksnslashes;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.AdapterView.*;
import android.widget.AdapterView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

import com.hacksnslashes.R;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ListView spellList;
    ArrayAdapter<String> spellListAdapter;
    ArrayList<String> mageSpellArray= new ArrayList<String>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mageSpellArray.add("test");
        spellList = (ListView) findViewById(R.id.spellList);
        spellListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mageSpellArray);
        spellList.setAdapter(spellListAdapter);
        spellList.setOnItemClickListener(spellListClickedHandler);
    }


    // Handles Spell Click Events
    private OnItemClickListener spellListClickedHandler = new OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            Intent castSpell = new Intent(MainActivity.this, SpellCast.class);
            castSpell.putExtra("spellDataPath", mageSpellArray.get(position));
            startActivity(castSpell);
        }
    };



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
}
