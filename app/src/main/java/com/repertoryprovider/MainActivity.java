package com.repertoryprovider;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String URL = "content://com.repertoryprovider.Repertory/friends";
    private Uri friends = Uri.parse(URL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void deleteAllRepertory (View view) {
// delete all the records and the table of the database provider
        int count = getContentResolver().delete(friends, null, null);
        String countNum = "Repertory App: "+ count +" records are deleted.";
        Toast.makeText(getBaseContext(),
                countNum, Toast.LENGTH_LONG).show();

    }
    public void addRepertory(View view) {
// Add a new repertory record
        ContentValues values = new ContentValues();
        String nameTxt = ((EditText)findViewById(R.id.name)).getText().toString();
        values.put("name", nameTxt);
        values.put("number",
                ((EditText)findViewById(R.id.number)).getText().toString());
        Uri uri = getContentResolver().insert(friends, values);
        Toast.makeText(getBaseContext(),
                "Contact : " + nameTxt + " inserted!", Toast.
                        LENGTH_LONG).show();

        ((EditText)findViewById(R.id.name)).setText("");
        ((EditText)findViewById(R.id.number)).setText("");
    }
}
