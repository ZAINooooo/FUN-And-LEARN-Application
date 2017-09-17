package com.example.synerzip.quiz;

/**
 * Created by Minhasoft on 3/3/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

import static android.R.id.message;
import static com.example.synerzip.quiz.R.string.subject;
import static com.example.synerzip.quiz.R.string.to;

public class SendEmailActivity extends Activity {

//    Button buttonSend;
//    EditText textTo;
//    EditText textSubject;
//    EditText textMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.mail_send);
//
//        buttonSend = (Button) findViewById(R.id.buttonSend);
//        textTo = (EditText) findViewById(R.id.editTextTo);
//        textSubject = (EditText) findViewById(R.id.editTextSubject);
//        textMessage = (EditText) findViewById(R.id.editTextMessage);


//        textTo.setBackgroundColor(Color.WHITE);
//        textSubject.setBackgroundColor(Color.WHITE);
//        textMessage.setBackgroundColor(Color.WHITE);


//        buttonSend.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                String to = textTo.getText().toString();
//                String subject = textSubject.getText().toString();
//                String message = textMessage.getText().toString();




        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {""});
        intent.putExtra(Intent.EXTRA_CC, new String[]{""});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));





//        File root = Environment.getExternalStorageDirectory();
//        File file = new File(root, xmlFilename);
//        if (!file.exists() || !file.canRead()) {
//            Toast.makeText(this, "Attachment Error", Toast.LENGTH_SHORT).show();
//            finish();
//            return;
//        }
//        Uri uri = Uri.parse("file://" + file);
//        intent.putExtra(Intent.EXTRA_STREAM, uri);
//        startActivity(Intent.createChooser(intent, "Send email..."));




                /*Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{String.valueOf(to)});
                email.putExtra(Intent.EXTRA_CC, new String[]{String.valueOf(to)});
                //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));*/

            }
        }