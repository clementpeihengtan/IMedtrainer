package com.example.imedtrainer;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Register extends AppCompatActivity {

    EditText username;
    EditText password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText)findViewById(R.id.editText4);
        password = (EditText)findViewById(R.id.editText3);
        register = (Button)findViewById(R.id.button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String filename = "account.txt";
                String info = user + "," + pass + "\n";
                FileOutputStream outputStream;
                if (user.matches("") || pass.matches("")) {
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Register.this);

                    dlgAlert.setMessage("Please enter both a username and password.");
                    dlgAlert.setTitle("Error Message");
                    dlgAlert.setPositiveButton("OK", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();

                    dlgAlert.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                } else {
                    if (fileExist(filename)) {
                        Context context = getApplicationContext();
                        try {
                            FileInputStream fis = context.openFileInput(filename);
                            InputStreamReader isr = new InputStreamReader(fis);
                            BufferedReader bufferedReader = new BufferedReader(isr);
                            String line;
                            while ((line = bufferedReader.readLine()) != null) {
                                line = line.replace("\n", "");
                                String[] split = line.split(",");
                                String user_store = split[0];
                                if (user_store == user) {
                                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(Register.this);

                                    dlgAlert.setMessage("Username is already in use.");
                                    dlgAlert.setTitle("Error Message");
                                    dlgAlert.setPositiveButton("OK", null);
                                    dlgAlert.setCancelable(true);
                                    dlgAlert.create().show();

                                    dlgAlert.setPositiveButton("Ok",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.cancel();
                                                }
                                            });
                                    break;
                                }
                            }
                            if (line == null) {
                                try {
                                    outputStream = openFileOutput(filename, Context.MODE_APPEND);
                                    outputStream.write(info.getBytes());
                                    outputStream.close();
                                    Intent intent = new Intent(Register.this, LoginActivity.class);
                                    startActivity(intent);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (FileNotFoundException e) {
                            System.err.println("File not found.");
                        } catch (IOException e) {
                            System.err.println("Unable to read the file.");
                        }
                    } else {
                        try {
                            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                            outputStream.write(info.getBytes());
                            outputStream.close();
                            Intent intent = new Intent(Register.this, LoginActivity.class);
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public boolean fileExist(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }
}
