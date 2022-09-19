package sample;

import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;




public class Game2 {

    public static Piece currentPiece;
    public static String currentPlayer;
    public static ChessBoard2 cb;
    private boolean game2;

    public Game2(GridPane chessBoard, String theme) {
        cb = new ChessBoard2(chessBoard, theme);
        currentPiece = null;
        currentPlayer = "white";
        this.game2 = true;
        addEventHandlers(cb.chessBoard);
    }

    private void addEventHandlers(GridPane chessBoard) {
        chessBoard.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                EventTarget target = event.getTarget();

                // Clicked on square
                if (target.toString().equals("Square")) {
                    Square square = (Square) target;
                    if (square.occupied) {
                        Piece newPiece = (Piece) square.getChildren().get(0);
                        // Selecting a new piece
                        if (currentPiece == null) {
                            currentPiece = newPiece;
//                            currentPiece.getAllPossibleMoves();
                            if (!currentPiece.getColor().equals(currentPlayer)) {
                                currentPiece = null;
                                return;
                            }
                            selectPiece(game2);
                        }
                        // Selecting other piece of same color || Killing a piece
                        else {
                            if (currentPiece.color.equals(newPiece.color)) {
                                deselectPiece(false);
                                currentPiece = newPiece;
//                                currentPiece.getAllPossibleMoves();
                                selectPiece(game2);
                            } else {
                                killPiece(square);
                            }
                        }

                    }
                    // Dropping a piece on blank square
                    else {
                        dropPiece(square);
                    }
                }
                // Clicked on piece
                else {
                    Piece newPiece = (Piece) target;
                    Square square = (Square) newPiece.getParent();
                    // Selecting a new piece
                    if (currentPiece == null) {
                        currentPiece = newPiece;
                        if (!currentPiece.getColor().equals(currentPlayer)) {
                            currentPiece = null;
                            return;
                        }
                        selectPiece(game2);
                    }
                    // Selecting other piece of same color || Killing a piece
                    else {
                        if (currentPiece.color.equals(newPiece.color)) {
                            deselectPiece(false);
                            currentPiece = newPiece;
                            selectPiece(game2);
                        } else {
                            killPiece(square);
                        }
                    }

                }
            }
        });
    }

    private void selectPiece(boolean game2) {
        if (!game2) {
            currentPiece = null;
            return;
        }

        DropShadow borderGlow = new DropShadow();
        borderGlow.setColor(Color.BLACK);
        borderGlow.setOffsetX(0f);
        borderGlow.setOffsetY(0f);
        currentPiece.setEffect(borderGlow);
        currentPiece.getAllPossibleMoves();
        currentPiece.showAllPossibleMoves(true);
    }

    private void deselectPiece(boolean changePlayer) {
        currentPiece.setEffect(null);
        currentPiece.showAllPossibleMoves(false);
        currentPiece = null;
        if (changePlayer) currentPlayer = currentPlayer.equals("white") ? "black" : "white";
    }

    private void dropPiece(Square square) {
        if (!currentPiece.possibleMoves.contains(square.name)) return;

        Square initialSquare = (Square) currentPiece.getParent();
        square.getChildren().add(currentPiece);
        square.occupied = true;
        initialSquare.getChildren().removeAll();
        initialSquare.occupied = false;
        currentPiece.posX = square.x;
        currentPiece.posY = square.y;
        deselectPiece(true);
    }

    private void killPiece(Square square) {
        if (!currentPiece.possibleMoves.contains(square.name)) return;

        Piece killedPiece = (Piece) square.getChildren().get(0);
        if (killedPiece.type.equals("King")) {
            this.game2 = false;
            popup();
        }

        Square initialSquare = (Square) currentPiece.getParent();
        square.getChildren().remove(0);
        square.getChildren().add(currentPiece);
        square.occupied = true;
        initialSquare.getChildren().removeAll();
        initialSquare.occupied = false;
        currentPiece.posX = square.x;
        currentPiece.posY = square.y;
        deselectPiece(true);
    }


    public void popup() {
        System.out.println("in popup");
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);

        VBox vbox = new VBox(new Text("End of Game"));
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(100));

        dialogStage.setScene(new Scene(vbox));
        dialogStage.show();

    }
}

