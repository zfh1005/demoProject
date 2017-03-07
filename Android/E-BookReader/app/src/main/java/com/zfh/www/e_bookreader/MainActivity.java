package com.zfh.www.e_bookreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zfh.www.e_bookreader.chooseFile.FileDialogView;

public class MainActivity extends Activity {
    private static final String _TAG = "MainActivity";
    private Button chooseBookButton;

    private FileDialogView fileDialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chooseBookButton = (Button)findViewById(R.id.choose_Button);
        chooseBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open the file manage for choose a file.
                Intent i = new Intent();
                i.setClass(MainActivity.this, chooseFilesActivity.class);
                startActivity(i);
            }
        });
    }


}
