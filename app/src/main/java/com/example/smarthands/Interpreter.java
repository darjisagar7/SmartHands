package com.example.smarthands;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Interpreter extends AppCompatActivity {

    private EditText mEdt;
    String text = "";
    SmsManager sms = SmsManager.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpreter);

        mEdt = (EditText) findViewById(R.id.editText2);
    }

    public void sendLanguage(View view){
        SmsManager sms = SmsManager.getDefault();
        Spinner mySpinner = findViewById(R.id.spinner);
        String text = mySpinner.getSelectedItem().toString();
        switch(text){
            case "Hindi" :
                sms.sendTextMessage("9699667895",null,"1",null,null);
                break;
            case "Marathi":
                sms.sendTextMessage("9699667895",null,"2",null,null);
                break;
            case "Gujarati":
                sms.sendTextMessage("9699667895",null,"3",null,null);
                break;
            case "Urdu":
                sms.sendTextMessage("9699667895",null,"4",null,null);
                break;
            case "Malayalam":
                sms.sendTextMessage("9699667895",null,"5",null,null);
                break;
            case "Telugu":
                sms.sendTextMessage("9699667895",null,"6",null,null);
                break;
            case "Tamil":
                sms.sendTextMessage("9699667895",null,"7",null,null);
                break;
            case "Kannada":
                sms.sendTextMessage("8850959970",null,"8",null,null);
                break;
            case "Punjabi":
                sms.sendTextMessage("8850959970",null,"9",null,null);
                break;
            case "Bengali" :
                sms.sendTextMessage("8850959970",null,"10",null,null);
                break;
        }
    }

    public void sendMessage(View view){
        SmsManager sms = SmsManager.getDefault();
        TextView textView = (TextView) findViewById(R.id.editText);
        String text = textView.getText().toString();
        sms.sendTextMessage("8850959970",null,text,null,null);
    }

    public void nextAction(View view){
        text = mEdt.getText().toString();
        Log.d("edit",mEdt.getText().toString());
        Intent intent = new Intent(this,Output.class);
        intent.putExtra("textmessage",mEdt.getText().toString());
        startActivity(intent);
    }

    public void openEmoji(View view){
        Intent emojiIntent = new Intent(Interpreter.this,EmojiActivity.class);
        startActivity(emojiIntent);
    }

}
