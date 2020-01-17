package com.example.smarthands;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class EmojiActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;

    private int images[] =
            {
                    R.drawable.happyemoji,R.drawable.smileemoji,R.drawable.sademoji,
                    R.drawable.loveemoji,R.drawable.tiredemoji,R.drawable.sleepyemoji,
                    R.drawable.disgustedemoji,R.drawable.crazyemoji,R.drawable.mademoji,
                    R.drawable.shoutingemoji,R.drawable.wonderingemoji,R.drawable.proudemoji,
                    R.drawable.regretfulemoji,R.drawable.pooremoji,R.drawable.afraidemoji,
                    R.drawable.shockedemoji,R.drawable.sufferingemoji,R.drawable.trustedemoji,
                    R.drawable.depressedemoji
            };

    private String names[] =
            {
                    "Happy","Smile","Sad","Love","Tired","Sleepy","Disgusted","Crazy","Mad","Shouting",
                    "Wondering","Proud","Regretful","Poor","Afraid","Shocked","Suffering","Trusted","Depressed"
            };

   /* private int color[] =
            {
                    R.color.Red,R.color.DarkGreen,R.color.Green,R.color.grey,R.color.darkblue
            };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(EmojiActivity.this,3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        EmojiAdapter emojiAdapter = new EmojiAdapter(EmojiActivity.this,images,names);
        recyclerView.setAdapter(emojiAdapter);
    }

}
