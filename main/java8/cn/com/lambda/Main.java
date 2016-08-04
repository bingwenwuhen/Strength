package cn.com.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Main {

    public static void main(String[] args) {
        String[] apt = {
                "Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"
        };
        List<String> players = Arrays.asList(apt);
        //��ǰ��ѭ����ʽ
        for (String player: players) {
            System.out.println(player + ",");
        }
        System.out.println();
        //ʹ��lambda���ʽ�Լ���������
        players.forEach(
                (player) -> System.out.println(player + ",")
        );
        System.out.println();
        //��java8��ʹ��˫ð�Ų�����
        players.forEach(System.out :: println);
    }

}
