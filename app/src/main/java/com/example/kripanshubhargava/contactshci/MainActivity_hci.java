package com.example.kripanshubhargava.contactshci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity_hci extends AppCompatActivity {
    static ArrayList<String> first_name=new ArrayList<String>();
    static ArrayList<String> last_name=new ArrayList<String>();
    static ArrayList<String> phone=new ArrayList<String>();
    static ArrayList<String> email=new ArrayList<String>();
    static ArrayList<String> birthdate=new ArrayList<String>();
    private ArrayList<String> input=new ArrayList<String>();
    static  ArrayList<String> name=new ArrayList<String>();
    ListView l;
    String myfilename="contact_info";
    int linecount=0;
    StringBuilder buf=new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hci);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cleardata();
        l = (ListView) findViewById(R.id.list1);


        try {
            readFile();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),
                    "Problems: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        add_data();



        MyAdapter adapter = new MyAdapter(this, name, phone);
        l.setAdapter(adapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent add_details= new Intent(getBaseContext(),Contact_details.class);
                startActivity(add_details);

// do pass the parameters in the intent

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_hci, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.add_details)
        {
            Intent add_details= new Intent(getBaseContext(),Add_Contacts.class);
            startActivity(add_details);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
    public  void readFile ()throws IOException {
       try{
        FileInputStream fileIn = openFileInput(myfilename);
        InputStreamReader InputRead = new InputStreamReader(fileIn);

        BufferedReader reader=new BufferedReader(InputRead);

        String str;



        while ((str = reader.readLine()) != null) {

            buf.append(str+"\n");
            linecount++;
            input.add(buf.toString());
        }
        InputRead.close();
        Toast.makeText(getBaseContext(), buf, Toast.LENGTH_SHORT).show();
        System.out.println("read:");
        System.out.println(buf.toString());
    }catch (Exception e) {
        e.printStackTrace();
    }


    }
    public void add_data()
    {
        for (int k = 0; k < linecount; k++) {
            String[] data = new String[linecount];
            for (int i = 0; i < linecount; i++) {
                data = input.get(k).split("\t");

            }
            System.out.print("The array is : ");
            System.out.println(Arrays.toString(data));
           first_name.add(data[0]);
            last_name.add(data[1]);
            phone.add(data[2]);
            email.add(data[3]);
            birthdate.add(data[4]);


        name.add(first_name.get(k)+" "+ last_name.get(k));



        }
        System.out.println("The name is : "+ name.toString());
    }

    void cleardata()
    {
        first_name.clear();
        last_name.clear();
        phone.clear();
        email.clear();
        birthdate.clear();


    }

}
