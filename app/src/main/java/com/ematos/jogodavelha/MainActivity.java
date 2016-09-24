package com.ematos.jogodavelha;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    protected int nextMove = R.drawable.tic_tac_toe_x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMove(View view) {

        ImageView image = (ImageView) view;
        image.setImageResource(nextMove);

        if (nextMove == R.drawable.tic_tac_toe_x) {
            nextMove = R.drawable.tic_tac_toe_o;
        } else {
            nextMove = R.drawable.tic_tac_toe_x;
        }

        ((ImageView) findViewById(R.id.nextMove)).setImageResource(nextMove);

    }
}
