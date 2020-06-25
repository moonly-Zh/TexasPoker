package TexasPoker;

import java.io.*;

//德州扑克比较牌值具体实现
//17030130021
//张维越
//2020.06.24

public class TexasPoker {

    //入参为十位的数组，比较双方手牌大小，黑胜返回1，平局返回0，白胜返回-1
    public static int Judge(String[] twoManHand){
        Poker[] black = new Poker[5];
        Poker[] white = new Poker[5];

        for(int i=0;i<5;i++){
            black[i]=new Poker(twoManHand[i+0]);
            white[i]=new Poker(twoManHand[i+5]);
        }
        int b=getScore(black);
        int w=getScore(white);
        if(b>w)
            return 1;
        else if(b==w)
            return 0;
        else
            return -1;
    }

    //参数为五位的数组，按照德州扑克的规则计算牌面得分并返回
    public static int getScore(Poker[] hand){
        if(hand.length!=5)
            throw new IllegalArgumentException();
        //定义cardFace的13位数组，储存从2~A每个点数的张数
        int[] cardFace = new int[13];
        //定义flush记录是否花色相同，相同则为0~3之一，不同则为-1
        int flush = hand[0].suit;
        for(Poker poker:hand){
            cardFace[poker.figure]++;
            if(poker.suit!=flush)
                flush=-1;
        }
        //定义5位数组，记录同点数牌的组数，比如两个对，五个单
        int[] countsOfSameFigure=new int[5];
        for(int i=0;i<13;i++)
            countsOfSameFigure[cardFace[i]]++;
        //顺子中最大的一位（如果是A~5则最大为5）
        int sfh=straight(cardFace);
        //除顺子外其他情况用作比较的最高位点数
        int hc=getHighest(cardFace,countsOfSameFigure);

        //按简易版通用规则对牌面进行评分，一共有九个等级，若遇到相同等级用作比较的牌值也不超过12，故将等级赋值100，比较位赋原值
        //同花顺
        if(sfh!=-1&&flush!=-1)
            return 800+sfh;
        //四条
        else if(countsOfSameFigure[4]==1)
            return 700+hc;
        //葫芦（3+2）
        else if(countsOfSameFigure[3]==1&&countsOfSameFigure[2]==1)
            return 600+hc;
        //同花
        else if(flush!=-1)
            return 500+hc;
        //顺子
        else if(sfh!=-1)
            return 400+sfh;
        //三条
        else if(countsOfSameFigure[3]==1)
            return 300+hc;
        //两对
        else if(countsOfSameFigure[2]==2)
            return 200+hc;
        //一对
        else if(countsOfSameFigure[2]==1)
            return 100+hc;
        //散牌
        else
            return hc;
    }

    //顺子情况的最高位
    public static int straight(int[] cardFace){
        wow:
        for(int i=cardFace.length-1;i>2;i--){
            for(int j=0;j<5;j++){
                if(cardFace[(i-j+13)%13]==0)
                    continue wow;
            }
            return i;
        }
        return -1;
    }

    //其他情况的最高位，比如3+2时，比较的应该是三条的牌面
    public static int getHighest(int[] cardFace,int[] counts) {
        int temp = 0;
        for(int i=4;i>=0;i--){
            if(counts[i]!=0){
                temp=i;
                break;
            }
        }
        for(int j=12;j>=0;j--){
            if(cardFace[j]==temp)
                return j;
        }

        return -1;
    }


    static void readFile(String fileName){
        File fl =new File(fileName);
        FileReader reader=null;
        try {
            reader = new FileReader(fl);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(reader);
        String line="";
        try {
            while((line=br.readLine())!=null){
                String[] twoManCard = line.split(" ");
                if(Judge(twoManCard)==1) System.out.println("black wins");
                else if(Judge(twoManCard)==-1) System.out.println("white wins");
                else System.out.println("tie");
            }
        } catch (IOException e) {
            System.out.println("no file");
        }
    }

    public static void main(String[] args){
        String fileName="src//poker.txt";
        readFile(fileName);
    }

}

//定义扑克牌的点数figure和花色suit，将其换为从0开始的数组，例如2->0，D->0
class Poker {
    public final int suit;
    public final int figure;

    public Poker(int figure, int suit) {
        if (figure < 0 || figure >= 13 || suit < 0 || suit >= 4)
            throw new IllegalAccessError();
        this.figure = figure;
        this.suit = suit;
    }

    public Poker(String str) {
        this("23456789TJQKA".indexOf(str.charAt(0)), "DSHC".indexOf(str.charAt(1)));
    }
}

