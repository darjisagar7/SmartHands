package com.example.smarthands;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.MyHolder> {
    private Context context;
    private int images[];
    private String names[];

    public EmojiAdapter(Context context, int[] images, String[] names) {
        this.context = context;
        this.images = images;
        this.names = names;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View Layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.emoji_gridview,null);
        MyHolder myHolder = new MyHolder(Layout);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.img.setImageResource(images[i]);
        myHolder.txt.setText(names[i]);

        myHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Interpreter.class);
                intent.putExtra("emoji",names[i]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public static class MyHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView txt;
        RelativeLayout relativeLayout;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgview);
            txt = itemView.findViewById(R.id.txtview);
            relativeLayout = itemView.findViewById(R.id.list);
        }
    }
}
