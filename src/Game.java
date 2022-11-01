import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    int AnzahlSpieler;
    String PlayerName;
    ArrayList<Player> PlayerList = new ArrayList<Player>();
    public void PlayGame(){
        SetNumberOfPlayers();
        InstantiatePlayers();
        PrintPlayerList();



 ;
    }

    private void PrintPlayerList() {
        for(Player player:PlayerList) {
            System.out.println(player.name);
        }
    }

    private void InstantiatePlayers() {
        for (int i = 0; i<AnzahlSpieler; i++){
        PlayerName = GetPlayerName();
            Player player = new Player(PlayerName);
            PlayerList.add(player);
        }
    }

    private String GetPlayerName() {

        System.out.println("Wie heisst du?");
        return scanner.nextLine();
    }

    private void SetNumberOfPlayers() {
        System.out.println("Wieviele Spieler sollen spielen?");
        AnzahlSpieler = scanner.nextInt();
        scanner.nextLine();
    }


}
