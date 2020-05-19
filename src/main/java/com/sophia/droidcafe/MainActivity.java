package com.sophia.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String mOrderMessage;
    public static final String EXTRA_ORDER_KEY = "MY KEY FOR ORDER MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //implement an explicit intent for opening the order activity
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY,mOrderMessage);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
            //return true;
       // }
        // create a switch case block to handle the clicks on the menu items
        switch (item.getItemId()){
            case R.id.action_order:
                //open order activity
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY,mOrderMessage);
                startActivity(intent);
                return true;
            case R.id.action_call:
                //implement an implicit intent that calls your cafe number
                Uri myUri = Uri.parse("tel:0709876543");
                Intent myIntent = new Intent(Intent.ACTION_DIAL,myUri);
                startActivity(myIntent);
                return true;
                //ADD THE CASE FOR THE OTHER OPTIONS
                //ENSURE THE ITEM ABOUT US OPENS IN WEB PAGE AND LOCATE US ITEMS OPENS A GOOGLE MAP SHOWING YOUR LATITUDE AND LONGITUDE
            //ABOUT US
            case R.id.action_about_us:
            Uri webPage = Uri.parse("https://codelabs.developers.google.com/");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);
            startActivity(webIntent);
            return true;
            //LOCATE US
            case R.id.location:
                Uri myLocation = Uri.parse("geo:-1.305510,36.835330");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, myLocation);
                startActivity(mapIntent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //a method for displaying toast messages
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }


    public void showIceCreamMessage(View view) {
        //define what will done when user clicks on image
        //eg showing a toast adding an item tp shopping cart
      //displayToast(getString(R.string.ice_cream_order));
        mOrderMessage = getString(R.string.ice_cream_order);
        displayToast(mOrderMessage);
    }

    public void showDonutOrderMessage(View view) {
        //displayToast(getString(R.string.donut_order));
        mOrderMessage = getString(R.string.donut_order);
        displayToast(mOrderMessage);
    }

    public void showFroyoOrderMessage(View view) {
        //displayToast(getString(R.string.froyo_order));
        mOrderMessage = getString(R.string.froyo_order);
        displayToast(mOrderMessage);
    }
}
