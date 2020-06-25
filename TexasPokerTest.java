package TexasPoker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TexasPokerTest {

    @Test
    //顺子
    void getScoreStraight() {
        TexasPoker tp=new TexasPoker();
        Poker[] hand=new Poker[5];
        String input="2C 3H 4S 5C 6H";
        String[] p=input.split(" ");
        for(int i=0;i<5;i++)
            hand[i]=new Poker(p[i]);
        Integer result=tp.getScore(hand);
        Assertions.assertEquals(404,result);
    }

    @Test
    //同花顺
    void getScoreStraightFlush() {
        TexasPoker tp=new TexasPoker();
        Poker[] hand=new Poker[5];
        String input="7H 3H 4H 5H 6H";
        String[] p=input.split(" ");
        for(int i=0;i<5;i++)
            hand[i]=new Poker(p[i]);
        Integer result=tp.getScore(hand);
        Assertions.assertEquals(805,result);
    }

    @Test
    //同花
    void getScoreFlush() {
        TexasPoker tp=new TexasPoker();
        Poker[] hand=new Poker[5];
        String input="7H AH 4H 8H 6H";
        String[] p=input.split(" ");
        for(int i=0;i<5;i++)
            hand[i]=new Poker(p[i]);
        Integer result=tp.getScore(hand);
        Assertions.assertEquals(512,result);
    }

    @Test
    //两对
    void towPairs() {
        TexasPoker tp=new TexasPoker();
        Poker[] hand=new Poker[5];
        String input="TH TC 4H 4S 6H";
        String[] p=input.split(" ");
        for(int i=0;i<5;i++)
            hand[i]=new Poker(p[i]);
        Integer result=tp.getScore(hand);
        Assertions.assertEquals(208,result);
    }


    @Test
    //三条
    void threeOfAKind() {
        TexasPoker tp=new TexasPoker();
        Poker[] hand=new Poker[5];
        String input="QH QC QS 4S 6H";
        String[] p=input.split(" ");
        for(int i=0;i<5;i++)
            hand[i]=new Poker(p[i]);
        Integer result=tp.getScore(hand);
        Assertions.assertEquals(310,result);
    }

    @Test
    //与上一个作对比，来一个错误示范，看看测试是否正常
    void threeOfAKindError() {
        TexasPoker tp=new TexasPoker();
        Poker[] hand=new Poker[5];
        String input="QH QC QS 4S 6H";
        String[] p=input.split(" ");
        for(int i=0;i<5;i++)
            hand[i]=new Poker(p[i]);
        Integer result=tp.getScore(hand);
        Assertions.assertEquals(308,result);
    }

}