package com.ematos.jogodavelha;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    protected HashMap<Integer, Integer> positionMapping = new HashMap<>();
    protected HashMap<TicTacToe.Moves, Integer> moveImageMapping = new HashMap<>();
    protected TicTacToe ticTatToe = new TicTacToe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        positionMapping.put(R.id.topLeft, 0);
        positionMapping.put(R.id.topMiddle, 1);
        positionMapping.put(R.id.topRight, 2);
        positionMapping.put(R.id.centerLeft, 3);
        positionMapping.put(R.id.centerMiddle, 4);
        positionMapping.put(R.id.centerRight, 5);
        positionMapping.put(R.id.bottomLeft, 6);
        positionMapping.put(R.id.bottomMiddle, 7);
        positionMapping.put(R.id.centerRight, 8);

        moveImageMapping.put(TicTacToe.Moves.X, R.drawable.tic_tac_toe_x);
        moveImageMapping.put(TicTacToe.Moves.O, R.drawable.tic_tac_toe_o);
    }

    public void doMove(View view) {
        if(ticTatToe.hasFinished()) {
            return;
        }

        TicTacToe.Moves nextMove = ticTatToe.getNextMove();

        ImageView image = (ImageView) view;
        image.setImageResource(moveImageMapping.get(nextMove));

        try {
            ticTatToe.move(image.getId());
        } catch (SamePositionMoveException e) {
            Toast.makeText(getApplicationContext(), "Trying to play on same position", Toast.LENGTH_SHORT).show();;
        } catch (PositionBeyondBoundariesException e) {
            Toast.makeText(getApplicationContext(), "Trying to play beyond boundaries. How did ou manage to get here???", Toast.LENGTH_SHORT).show();
        }

        if(ticTatToe.hasFinished()) {
            Toast.makeText(getApplicationContext(), "Game finished!", Toast.LENGTH_LONG).show();
        } else {
            ((ImageView) findViewById(R.id.nextMove)).setImageResource(moveImageMapping.get(nextMove));
        }
    }
}
