package com.example.ciara.explicitintent;

        import android.app.Activity;
        import android.os.Bundle;
        import android.widget.TextView;

public class DisplayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display); //linking to the display xml

        //declare the intent and assign view to appropiate text view in display.xml

        Bundle b = getIntent().getExtras();
        TextView name = (TextView) findViewById(R.id.nameValue);
        TextView age = (TextView) findViewById(R.id.ageValue);
        //TextView message = (TextView) findViewById(R.id.messageValue);

        //defining user input

        name.setText(b.getCharSequence("name"));
        age.setText(b.getCharSequence("age"));
        //message.setText(b.getCharSequence("message"));
    }
}