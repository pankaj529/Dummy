package com.android.dummy;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements UpdateHelper.onUpdateCheckListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UpdateHelper.with(this)
                .onUpdateCheck((UpdateHelper.onUpdateCheckListener) this)
                .check();




    }



    @Override
    public void onUpdateCheckListener(final String urlApp) {

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("New Version Avillable")
                .setMessage("please update")




                .setPositiveButton("update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {

                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlApp)));

                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + urlApp)));

                        }


                        finish();

                    }
                }).create();


               alertDialog.show();




    }


}
