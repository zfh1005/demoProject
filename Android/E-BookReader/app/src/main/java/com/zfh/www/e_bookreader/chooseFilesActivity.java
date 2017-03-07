package com.zfh.www.e_bookreader;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zfh.www.e_bookreader.chooseFile.FileDialog;
import com.zfh.www.e_bookreader.chooseFile.FileDialogView;

import java.io.File;
import java.util.ArrayList;

public class chooseFilesActivity extends AppCompatActivity {

    private FileDialogView pickerView;
    private Button cancelButton;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosefile);

        setTitle("选择文件");
        Intent intent = getIntent();
        if (intent != null
                && Intent.ACTION_GET_CONTENT.equals(intent.getAction())) {
            pickerView = (FileDialogView) findViewById(R.id.picker);
            pickerView.setFileMode(FileDialog.FILE_MODE_OPEN_FILE_SINGLE);
            pickerView.setInitialPath(Environment.getExternalStorageDirectory()
                    .getAbsolutePath());
            pickerView.openFolder();
            cancelButton = (Button) pickerView
                    .findViewById(com.zfh.www.e_bookreader.R.id.button_dialog_file_cancel);
            okButton = (Button) pickerView
                    .findViewById(com.zfh.www.e_bookreader.R.id.button_dialog_file_ok);
            cancelButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    setResult(RESULT_CANCELED);
                    finish();
                }
            });
            okButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    ArrayList<File> files = pickerView.getSelectedFiles();
                    if (files != null && files.size() > 0) {
                        File file = files.get(0);
                        Intent intent = new Intent();
                        Uri uri = Uri.fromFile(file);
                        intent.setData(uri);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }
            });
        }

    }

}
