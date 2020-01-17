package com.example.smarthands;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Arrays;

public class Output extends AppCompatActivity {

    VideoView videoView;
    TextView tv, tv2;

    int rawId, i = 0,j=0;
    String[] railway = {"train", "railway", "irctc", "pnr", "monorail", "metro"};
    String[] aeroplane = {"plane", "airliner", "propeller", "jet", "aeroplane", "aircraft", "flight", "airport", "fly", "airline"};
    String[] boat = {"boat", "ship", "cruise", "sail", "canoe", "yacht", "submarine"};
    String[] shop = {"shop", "boutique", "store", "bazaar", "mall"};
    char[] letter;
    String dat;
    String[] data ;
    MediaController mediaController = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        Bundle b = getIntent().getExtras();
        dat = b.getString("textmessage");
        data = dat.split(" ");
        System.out.println("Sagar"+data);

        videoView = (VideoView) findViewById(R.id.videoView);
        mediaController = new MediaController(this);
        tv = findViewById(R.id.tv);
        tv2 = findViewById(R.id.tv2);
        tv2.setText(dat);
        mediaController.setAnchorView(videoView);
        check();
    }

    //    public static String[] ngrams(String s, int len) {
//        String[] parts = s.split(" ");
//        String[] result = new String[parts.length - len + 1];
//        for(int i = 0; i < parts.length - len + 1; i++) {
//            StringBuilder sb = new StringBuilder();
//            for(int k = 0; k < len; k++) {
//                if(k > 0) sb.append(' ');
//                sb.append(parts[i+k]);
//            }
//            result[i] = sb.toString();
//        }
//        return result;
//    }

    public void check() {

        if (i < data.length) {
            if (Arrays.asList(railway).contains(data[i])) {
                rawId = getResources().getIdentifier("railway", "raw", getPackageName());
                video();
            } else if (Arrays.asList(aeroplane).contains(data[i])) {
                rawId = getResources().getIdentifier("aeroplane", "raw", getPackageName());
                video();
            } else if (Arrays.asList(boat).contains(data[i])) {
                rawId = getResources().getIdentifier("boat", "raw", getPackageName());
                video();
            } else if (Arrays.asList(shop).contains(data[i])) {
                rawId = getResources().getIdentifier("shop", "raw", getPackageName());
                video();
            } else {
                rawId = getResources().getIdentifier(data[i], "raw", getPackageName());
                video();
            }
            if(rawId==0) {
                letter = data[i].toCharArray();
                j=0;
                let();
//
            }

        }
    }

    public void let(){
        if(j<letter.length) {
            rawId = getResources().getIdentifier(Character.toString(letter[j]), "raw", getPackageName());
            video1(Character.toString(letter[j]));
        }else{
            i++;
            check();
        }

    }
    public void video(){
        String path = "android.resource://" + getPackageName() + "/" + rawId;
        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(mediaController);
        videoView.requestFocus();
        videoView.start();
        tv.setText(data[i]);
        mediaController.hide();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(final MediaPlayer mp) {
                i++;
                System.out.println("Hey" + i);
                check();
            }
        });
    }

    public void video1(String letter){
        String path = "android.resource://" + getPackageName() + "/" + rawId;
        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(mediaController);
        videoView.requestFocus();
        videoView.start();
        tv.setText(letter);
        mediaController.hide();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(final MediaPlayer mp) {
                j++;
                System.out.println("Hey" + i);
                let();

            }
        });
    }



}
