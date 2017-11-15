package com.landsoft.dialogandalertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockApplication;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnDialog, btnAlertDialog;
    Dialog dialog;
    AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDialog = findViewById(R.id.btn_dialog);
        btnAlertDialog = findViewById(R.id.btn_alert_dialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowDialog();
            }
        });
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAlertDialog();
            }
        });

    }

    private void ShowAlertDialog() {
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("landsoft.com");
        alertDialogBuilder.setMessage("Ban co muon dong alertDialog");
        alertDialogBuilder.setPositiveButton("Dong y", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this," ban da thoat", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Khong thoat",Toast.LENGTH_SHORT).show();
                dialogInterface.cancel();
            }
        });

        alertDialogBuilder.setNeutralButton("Khong biet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Khong biet",Toast.LENGTH_SHORT).show();

            }
        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void ShowDialog() {
        dialog = new Dialog(MainActivity.this);
        dialog.setCancelable(false);
        dialog.setTitle("landsoft.com");
        dialog.setContentView(R.layout.layout_dialog);
        Button agree = dialog.findViewById(R.id.btn_agree);
        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, " Ban da thoat thanh cong",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        Button notAgree = dialog.findViewById(R.id.btn_not_agree);
        notAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
