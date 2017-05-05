package com.microsoft.projectoxford.emotionsample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class feedback extends ActionBarActivity {

    EditText firstname;
    EditText lastname;
    EditText comment;
    String mymessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        firstname= (EditText) findViewById(R.id.firstname);
        lastname= (EditText) findViewById(R.id.lastname);
        comment= (EditText) findViewById(R.id.comment);


    }

    public void submit(View view) {
        mymessage=firstname.getText().toString()+" "+lastname.getText().toString()+" said:\n"+comment.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "waqar_900@hotmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "Moody Feedback");
        intent.putExtra(Intent.EXTRA_TEXT, mymessage);
        startActivity(Intent.createChooser(intent, "Send Email"));
    }
}
