package sample;

import java.util.ArrayList;

public class Knight2 extends Piece{
    public Knight2(String color, int posX, int posY) {
        super(color, posX, posY);
        this.type = "Knight";
        setImage();
    }

    @Override
    public void getAllPossibleMoves() {
        int x = this.posX;
        int y = this.posY;
        ArrayList<String> moves = new ArrayList<>();
        this.possibleMoves = new ArrayList<>();

        moves.add("Square" + (x+2) + (y+1));
        moves.add("Square" + (x+2) + (y-1));
        moves.add("Square" + (x+1) + (y+2));
        moves.add("Square" + (x-1) + (y+2));
        moves.add("Square" + (x-2) + (y+1));
        moves.add("Square" + (x-2) + (y-1));
        moves.add("Square" + (x+1) + (y-2));
        moves.add("Square" + (x-1) + (y-2));


        for(String move : moves){
            if(getSquareByName(move) != null){
                if(getSquareByName(move).occupied && getPieceByName(move).getColor().equals(Game2.currentPlayer)) continue;

                possibleMoves.add(move);

            }
        }


    }

}
