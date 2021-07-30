package com.androiddev.contextmenuexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img_bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linking the views
        img_bg = findViewById(R.id.img_bg);
        //after pressing for few seconds the context menu will be appearing
        registerForContextMenu(img_bg);

    }
    //inflating the menu in the Activity
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    //event
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        //fetching the menu option ID's
        int itemId= item.getItemId();

        if(itemId == R.id.op_download){
            Toast.makeText(MainActivity.this, "download started.", Toast.LENGTH_SHORT).show();
        }
        if(itemId == R.id.op_copyLink){
            Toast.makeText(MainActivity.this, "link copied.", Toast.LENGTH_SHORT).show();
        }
        if(itemId == R.id.op_delete){
            Toast.makeText(MainActivity.this, "Image deleted.", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}