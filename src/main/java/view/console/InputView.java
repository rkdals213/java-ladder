package view.console;

import domain.ladder.Line;
import domain.ladder.Player;
import domain.ladder.RandomPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static List<Player> names(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner sc = new Scanner(System.in);
        List<Player> players = Arrays.stream(sc.nextLine().split(",")).map(name -> new Player(name)).collect(Collectors.toList());
        return players;
    }

    public static List<Line> ladderCount(List<Player> players){
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        Scanner sc = new Scanner(System.in);
        int ladderCount = sc.nextInt();
        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < ladderCount; i++){
            lines.add(new Line(new RandomPoint().getRandomPoint(players.size())));
        }
        return lines;
    }

    public static List<String> result(){
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        Scanner sc = new Scanner(System.in);
        return Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toList());
    }

    public static String resultPlayer() {
        System.out.println("\n결과를 보고 싶은 사람은?\n");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine();
        return playerName;
    }
}