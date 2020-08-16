import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
class PokerHands{
      public static void main(String args[])throws IOException{
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
          String inp=br.readLine();
          String parts[];
          //String black[];
          //String white[];
          parts=inp.split("\\s");

          List<Card> deck_black=new ArrayList<>();
          List<Card> deck_white=new ArrayList<>();
          for(int i=0;i<5;i++)
            deck_black.add(new Card(parts[i]));
          for(int i=5;i<10;i++)
            deck_white.add(new Card(parts[i]));

            Collections.sort(deck_black);
            Collections.sort(deck_white);

            for(int i=0;i<5;i++){
              deck_black.get(i).print();
            }


          determineWinner(deck_black,deck_white);

      }


      public static void determineWinner(List<Card>deck_black,List<Card>deck_white){
          //0-4=Black, 5 -9=White
          boolean sFB=isStraightFlush(deck_black),sFW=isStraightFlush(deck_white);
          if(sfB !=sFW ){//No tie...
              System.out.println(sFB?"Black wins.":"White wins.");
          }
          if(fourOfAKind(deck_black)!=fourOfAKind(deck_white)){
            if(fourOfAKind(deck_black))
          }



      }


      public static boolean isStraightFlush(List<Card> deck){
            boolean flush=true;
            char suit=deck.get(0).suit;
            for(int i=1;i<5;i++){
              flush=deck.get(i).suit==suit;
              if(!flush)
                return false;
            }
            return true;
      }
}

class Card implements Comparable<Card>{
  int value;
  char suit;

  Card(String s){
      suit=s.charAt(1);
      value=getValue(s.charAt(0));
  }

  private int getValue(char ch){
      if(ch=='A')
        return 13;
      if(ch=='K')
        return 12;
      if(ch=='Q')
        return 11;
      if(ch=='J')
        return 10;
      return Integer.parseInt(""+ch);
  }

  public int compareTo(Card c2){
      if(this.value>c2.value)//this is greater hence no swapping
          return -1;
      if(this.value==c2.value)
        return 0;
      else
        return 1;
  }

  public void print(){
    System.out.println(value+""+suit);
  }
}


/*
High Card: Hands which do not fit any higher category are ranked by the value of
their highest card. If the highest cards have the same value, the hands are ranked
by the next highest, and so on.

Pair: Two of the five cards in the hand have the same value. Hands which both contain
a pair are ranked by the value of the cards forming the pair. If these values are
the same, the hands are ranked by the values of the cards not forming the pair,
in decreasing order.

Two Pairs: The hand contains two different pairs. Hands which both contain two pairs
are ranked by the value of their highest pair. Hands with the same highest pair
are ranked by the value of their other pair. If these values are the same the hands
are ranked by the value of the remaining card.

Three of a Kind: Three of the cards in the hand have the same value. Hands which
both contain three of a kind are ranked by the value of the three cards.

Straight: Hand contains five cards with consecutive values. Hands which both contain
a straight are ranked by their highest card.

Flush: Hand contains five cards of the same suit. Hands which are both flushes are
ranked using the rules for High Card.

Full House: Three cards of the same value, with the remaining two cards forming a
pair. Ranked by the value of the three cards.

Four of a Kind: Four cards with the same value. Ranked by the value of the four
cards.
Straight Flush: Five cards of the same suit with consecutive values. Ranked by the
highest card in the hand.
*/
