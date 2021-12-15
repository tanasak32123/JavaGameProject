package logic;

import Player.Tank;
import character.MonsterData;
import entity.Monster;
import entity.Player;
import javafx.animation.AnimationTimer;

public class GameLogic {

    public static boolean loser = false;
    public static boolean winner = false;
    public static boolean endStage = false;
    public static boolean playerAttack = false;
    public static boolean playerSkill = false;
    public static boolean isselectemonster = false ;

    public GameLogic() {

    }

    public static void actionInTurnPhase() {
         playerAttack = false;
         playerSkill = false;
//         (new AnimationTimer() {
//              public void handle(final long now) {
//                    if (playerDoActionTurn()) this.stop(); 
//                }
//         }).start();
            if (MonsterData.isAllMonsterInFieldDead()) {

                endStage = true;
            }
    }
    public static void actionmons() {
    	for (Monster monster : MonsterData.allMonsterInField) {
            try {
                monster.attackRandom();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (GamePlay.isAllCharacterDead()) {

                endStage = true;
            }
        }
    }
    

    public static boolean playerDoActionTurn() {
        return playerAttack || playerSkill ;
    }

    public static void isLoser() {
        if (loser) {
            // show restart menu;

            //
            GameStage.restartToNewBegin();
        }
    }

    public static void isWinner() {
        if (winner) {
            // show image congratulation and return to menu

            //
        }
    }

}