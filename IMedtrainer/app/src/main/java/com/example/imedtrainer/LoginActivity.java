package com.example.imedtrainer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;


public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    TextView register;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button);
        register = (TextView)findViewById(R.id.textView3);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String line = null;
                String filename = "account.txt";
                Context context = getApplicationContext();
                if (fileExist(filename)) {
                    try {
                        // InputStream is = getAssets().open("account.txt");
                        FileInputStream fis = context.openFileInput(filename);
                        InputStreamReader freader = new InputStreamReader(fis);
                        BufferedReader reader = new BufferedReader(freader);
                        while ((line = reader.readLine()) != null) {
                            line = line.replace("\n", "");
                            String[] split = line.split(",");
                            String user = split[0];
                            String pass = split[1];
                            if (username.getText().toString().equals(user) && password.getText().toString().equals(pass)) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("profile", username.getText().toString());
                                startActivity(intent);
                                break;
                            }
                        }
                        if (line == null) {
                            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(LoginActivity.this);

                            dlgAlert.setMessage("Invalid password or username.");
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
                        }
                    } catch (FileNotFoundException e) {
                        System.err.println("File not found.");
                    } catch (IOException e) {
                        System.err.println("Unable to read the file.");
                    }
                } else {
                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(LoginActivity.this);

                    dlgAlert.setMessage("No accounts present. Please register.");
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
                }
            }
        });
    }

    public void onClick(View v) {
        Intent intent = new Intent(LoginActivity.this, Register.class);
        startActivity(intent);
        finish();
    }

    public boolean fileExist(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }
}
