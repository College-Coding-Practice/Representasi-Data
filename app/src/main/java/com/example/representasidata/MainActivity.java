package com.example.representasidata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button addButton;
    TextView textView;
    SimpleArrayAdapter adapter;
    ListView listview;
    ArrayList<String> arrayList;
    Runnable run;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //deklarasi objek layout
        addButton = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);editText = (EditText) findViewById(R.id.editText);
        listview = (ListView) findViewById(R.id.listView);
        String[] hewan = new String[]{"Singa", "Macan", "Buaya",
                "Serigala", "Badak", "Kecoa", "Lintah", "Laron", "Berudu",
                "Katak", "Jelangkung", "Tikus", "Ular"};
        arrayList = new ArrayList<String>();
        for (int i = 0; i < hewan.length; ++i) {
            arrayList.add(hewan[i]);
        }
        adapter = new SimpleArrayAdapter(this,
                android.R.layout.simple_list_item_1, arrayList);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new
                                                AdapterView.OnItemClickListener() {
                                                    @Override
                                                    public void onItemClick(AdapterView<?> parent,
                                                                            final View view, int position, long id) {
                                                        final String item =
                                                                (String) parent.getItemAtPosition(position);
                                                        textView.setText("Yang dipilih: " + item);
                                                    }
                                                });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                tambahDaftar();
            }
        });
    }
    private boolean tambahDaftar() {
        adapter.add(editText.getText().toString());
        arrayList.add(editText.getText().toString());
        editText.setText("");
        adapter.notifyDataSetChanged();
        listview.smoothScrollToPosition(adapter.getCount() - 1);
        return true;
    }
}