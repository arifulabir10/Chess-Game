package sample;

import java.util.ArrayList;

public class Kangaroo extends Piece{
    public Kangaroo(String color, int posX, int posY) {
        super(color, posX, posY);
        this.type = "Kangaroo";
        setImage();
    }

    @Override
    public void getAllPossibleMoves() {
        int x = this.posX;
        int y = this.posY;
        ArrayList<String> moves = new ArrayList<>();
        this.possibleMoves = new ArrayList<>();

        moves.add("Square" + (x+2) + (y+2));
        moves.add("Square" + (x+2) + (y-2));
        moves.add("Square" + (x+2) + (y+2));
        moves.add("Square" + (x-2) + (y+2));
        moves.add("Square" + (x-2) + (y+2));
        moves.add("Square" + (x-2) + (y-2));
        moves.add("Square" + (x+2) + (y-2));
        moves.add("Square" + (x-2) + (y-2));


        for(String move : moves){
            if(getSquareByName(move) != null){
                if(getSquareByName(move).occupied && getPieceByName(move).getColor().equals(Game.currentPlayer)) continue;

                possibleMoves.add(move);

            }
        }


    }

}
