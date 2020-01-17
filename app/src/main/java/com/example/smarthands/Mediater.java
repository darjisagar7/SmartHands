package com.example.smarthands;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;

public class Mediater extends AppCompatActivity {

    TextView textView;
    Button mButton;
    String as;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediater);

        Bundle b = getIntent().getExtras();
        as = b.getString("textmessage");
        textView.setText(as);
        String msg = b.getString("emoji");

        mButton= (Button)findViewById(R.id.button4);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(Mediater.this,Output.class);
                intent.putExtra("textmessage",as);
                intent.putExtra("emoji",msg);
                startActivity(intent);
            }
        });

        textView = (TextView)findViewById(R.id.textView2) ;



    }

    public void openEmoji(View view)
    {
        Intent intent = new Intent(this,EmojiAdapter.class);
        startActivity(intent);
    }


}
