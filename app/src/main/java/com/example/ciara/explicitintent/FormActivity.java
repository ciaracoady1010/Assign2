package com.example.ciara.explicitintent;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;

public class FormActivity extends Activity implements OnClickListener {
    Button button;
    EditText name;
    EditText age;
    EditText message;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        //Get the ids of view objects
        findAllViewsId();

        button.setOnClickListener(this);
    }

    //assigning variables to the views

    private void findAllViewsId() {
        button = (Button) findViewById(R.id.submit);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        message = (EditText) findViewById(R.id.message);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
        //Create a bundle object
        Bundle b = new Bundle();

        //Inserts a String value into the mapping of this Bundle
        b.putString("name", name.getText().toString());
        b.putString("age", age.getText().toString());
        b.putString("age", message.getText().toString());

        //Add the bundle to the intent.
        intent.putExtras(b);

        //start the DisplayActivity
        startActivity(intent);
    }
}