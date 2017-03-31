package com.example.kripanshubhargava.contactshci;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Add_Contacts extends AppCompatActivity{

  static  String addfirst_name;
   static String addlast_name;
   static String addContact;
   static String addemail;
    static String addbirthdate;
    EditText ed1,ed2,ed3,ed4,ed5;
    static String set;
    String status;
    String myfilename="contact_info";





    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contactsview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar1);
        setSupportActionBar(toolbar);


        ed1 = (EditText) findViewById(R.id.last_nameedit);

        ed2 = (EditText) findViewById(R.id.phone_edit);

        ed3 = (EditText) findViewById(R.id.email_edit);

        ed4 = (EditText) findViewById(R.id.birth_dateedit);

        ed5 = (EditText) findViewById(R.id.first_nameedit);


        File file = new File(getFilesDir(), myfilename);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addcontact, menu);




        return true;

// Create a new output file stream


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement

        if(id == R.id.save_details)
        {
            try {
                saveFile();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(),
                        "Problems: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void saveFile() throws IOException {
        addfirst_name = ed5.getText().toString();
        addlast_name = ed1.getText().toString();
        addContact = ed2.getText().toString();
        addemail = ed3.getText().toString();
        addbirthdate = ed4.getText().toString();


        set = addfirst_name + "\t" + addlast_name + "\t" + addContact + "\t" + addemail + "\t" + addbirthdate;

        System.out.println(set);


        try {
            FileOutputStream fileout = openFileOutput(myfilename, MODE_APPEND);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            outputWriter.append(set.toString());
            outputWriter.append("\n\r");
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();
            System.out.println("data stored");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


}
