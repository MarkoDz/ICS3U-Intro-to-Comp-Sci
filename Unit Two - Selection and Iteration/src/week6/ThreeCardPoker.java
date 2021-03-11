import java.util.Scanner;

public class ThreeCardPoker {

  private static final int HEARTS = 0;
  private static final int DIAMONDS = 1;
  private static final int CLUBS = 2;
  private static final int SPADES = 3;
  private static final int NUM_SUITS = 4;
  private static final int NUM_FACES = 13;
  private static final int JACK = 11;
  private static final int QUEEN = 12;
  private static final int KING = 13;
  private static final int ACE = 14;
  private static final int STRAIGHT_FLUSH = 40;
  private static final int THREE_OF_A_KIND = 30;
  private static final int STRAIGHT = 6;
  private static final int FLUSH = 3;
  private static final int PAIR = 1;
  private static final int HIGH_CARD = 0;

  private static int getBet(Scanner in, int low,int high, String wageType){
    int wager = 0;
    while(true)
    {
      try{
        System.out.print("Please enter "+ wageType + " Wager(50$ - 100$)");
        wager = Integer.parseInt(in.nextLine());
        
        if(wager >= low && wager <= high)
          return wager;
        else  
          System.out.println("Incorrect " + wageType + " Wager value!");
      }catch(Exception ex){
          System.out.println("Incorrect " + wageType + " Wager value!");
      }
    }
  }
  public static void main(String[] args) {

    String playerHand = "";
    String dealerHand = "";

    Scanner in = new Scanner(System.in);

    int ante = getBet(in,50,100, "ante");
    int pairPlusWager = getBet(in,50,100, "pair plus");

    playerHand = dealCards();
    dealerHand = dealCards();

    System.out.println("Cards are dealt!");
    System.out.println("Player: " + playerHand);

    // Handle Pair-Plus Wager here, since this is independent
    if(pairPlusWager > 0)
    {
      int payout = pairPlusWager * handType(playerHand);
      System.out.println("Player pair plus wager payout:" + payout + "$" );
    }

    // Player places Play Wager or Folds
    int playWager = 0;
    while(true)
    {
      System.out.println("Choose one of two actions:");
      System.out.println("\t1. Play Wager (" + ante + "$)");
      System.out.println("\t2. Fold");
      int action = in.nextInt();
      if(action == 1)
      {
          playWager = ante;
          System.out.println("Player bets: " + playWager + "$");
          break;
      }
      if(action == 2)
      {
          int amountDealerTakes = ante + pairPlusWager;
          System.out.println("Player folds. Dealer takes: " + amountDealerTakes + "$");
          System.exit(0);
      }
      else
        System.out.println("Incorrect action selected! Please try again!");
    }

    System.out.println("Dealer: " + dealerHand);

    // Dealer has Q high or better
    if((handType(dealerHand) > HIGH_CARD ||
      (handType(dealerHand) == HIGH_CARD && getHighestHandFace(dealerHand) >= 13 ))
    )
    {
      // Player hand is better
      if(handType(playerHand) > handType(dealerHand))
      {

        int payout = (ante + playWager) * 2;
        System.out.println("Player wins, 1 to 1 payout: " + payout + "$" );
      }
      else if(handType(playerHand) < handType(dealerHand)) // Dealer hand is better wins
      {
        System.out.println("Player loses ante + playWager: " + (ante + playWager) + "$" );
      }
      else if(handType(playerHand) == handType(dealerHand)) // Tie
      {
        // Apply RULE A if TIE:
        System.out.println("Tie: Play wager returned to player:" + playWager + "$" );
        System.out.println("Tie: Play lost ante:" + ante + "$" );
      }
    }
    else // Dealer has Jack-high or worse
    {
      System.out.println("Play wager returned to player:" + playWager + "$" );
      System.out.println("Play lost ante:" + ante + "$" );
    }
  }


  public static int handType(String playerHand) {
    if (isStraightFlush(playerHand))
      return STRAIGHT_FLUSH;
    else if (isThreeOfAKind(playerHand))
      return THREE_OF_A_KIND;
    else if (isStraight(playerHand))
      return STRAIGHT;
    else if (isFlush(playerHand))
      return FLUSH;
    else if (isPair(playerHand))
      return PAIR;
    else
      return HIGH_CARD;
  }

  public static int getHighestHandFace(String playerHand) {

      String card1 = getCard(1, playerHand);
      String card2 = getCard(2, playerHand);
      String card3 = getCard(3, playerHand);
      String card1Face = card1.substring(0, card1.length() - 1);
      String card2Face = card2.substring(0, card2.length() - 1);
      String card3Face = card3.substring(0, card3.length() - 1);


      // First, determine value of A: 1 or 15
      // A = 1 only when 2 other cards are 2 and 3.
      int aceValue = 15;
      
      if(card1Face.equals("A"))
      {
        int card2Num = card2Face.equals("J") ? 12 :
                        card2Face.equals("Q") ? 13 :
                          card2Face.equals("K") ? 14 : 
                            card2Face.equals("A") ? aceValue :
                              Integer.parseInt(card2Face);

        int card3Num = card3Face.equals("J") ? 12 :
                        card3Face.equals("Q") ? 13 :
                          card3Face.equals("K") ? 14 :
                            card3Face.equals("A") ? aceValue : 
                              Integer.parseInt(card3Face);

        if(card2Num + card3Num == 5)
          aceValue = 1;              

      }
      else if(card2Face.equals("A"))
      {
        int card1Num = card1Face.equals("J") ? 12 :
                        card1Face.equals("Q") ? 13 :
                          card1Face.equals("K") ? 14 : 
                            card1Face.equals("A") ? aceValue :
                              Integer.parseInt(card1Face);

        int card3Num = card3Face.equals("J") ? 12 :
                card3Face.equals("Q") ? 13 :
                  card3Face.equals("K") ? 14 :
                    card3Face.equals("A") ? aceValue : 
                      Integer.parseInt(card3Face);

        if(card1Num + card3Num == 5)
          aceValue = 1;              

      }
      else if(card3Face.equals("A"))
      {
        int card1Num = card1Face.equals("J") ? 12 :
                        card1Face.equals("Q") ? 13 :
                          card1Face.equals("K") ? 14 : 
                            card1Face.equals("A") ? 1 :
                              Integer.parseInt(card1Face);

        int card2Num = card2Face.equals("J") ? 12 :
                        card2Face.equals("Q") ? 13 :
                          card2Face.equals("K") ? 14 : 
                            card2Face.equals("A") ? 1 :
                              Integer.parseInt(card2Face);

        if(card1Num + card2Num == 5)
          aceValue = 1;              

      }   

      int card1Num = card1Face.equals("J") ? 12 :
                        card1Face.equals("Q") ? 13 :
                          card1Face.equals("K") ? 14 : 
                            card1Face.equals("A") ? aceValue :
                              Integer.parseInt(card1Face);
      
      int card2Num = card2Face.equals("J") ? 12 :
                        card2Face.equals("Q") ? 13 :
                          card2Face.equals("K") ? 14 :
                            card2Face.equals("A") ? aceValue : 
                              Integer.parseInt(card2Face);

      int card3Num = card3Face.equals("J") ? 12 :
                        card3Face.equals("Q") ? 13 :
                          card3Face.equals("K") ? 14 : 
                            card3Face.equals("A") ? aceValue :
                              Integer.parseInt(card3Face);

      // Find maximum element 
      return Math.max(card1Num, Math.max(card2Num, card3Num)); 
  }

  private static boolean isPair(String hand) {

    String card1 = getCard(1, hand);
    String card2 = getCard(2, hand);
    String card3 = getCard(3, hand);
    String card1Face = card1.substring(0, card1.length() - 1);
    String card2Face = card2.substring(0, card2.length() - 1);
    String card3Face = card3.substring(0, card3.length() - 1);

    if( card1Face.equals(card2Face) ||
        card2Face.equals(card3Face) ||
        card1Face.equals(card3Face)
      )
      return true;
    else
      return false;
   
  }
  private static boolean isStraight(String hand) {

    String card1 = getCard(1, hand);
    String card2 = getCard(2, hand);
    String card3 = getCard(3, hand);
    String card1Face = card1.substring(0, card1.length() - 1);
    String card2Face = card2.substring(0, card2.length() - 1);
    String card3Face = card3.substring(0, card3.length() - 1);

    boolean hasAce = false;

    if( card1Face.equals("A") ||
        card2Face.equals("A") ||
        card3Face.equals("A")
      )
      hasAce = true;

    if(!hasAce)
    {
      int card1Num = card1Face.equals("J") ? 12 :
                        card1Face.equals("Q") ? 13 :
                          card1Face.equals("K") ? 14 : 
                            Integer.parseInt(card1Face);
      
      int card2Num = card2Face.equals("J") ? 12 :
                        card2Face.equals("Q") ? 13 :
                          card2Face.equals("K") ? 14 : 
                            Integer.parseInt(card2Face);

      int card3Num = card3Face.equals("J") ? 12 :
                        card3Face.equals("Q") ? 13 :
                          card3Face.equals("K") ? 14 : 
                            Integer.parseInt(card3Face);

      // Find maximum element 
      int get_max = Math.max(card1Num, Math.max(card2Num, card3Num)); 

      // Find minimum element 
      int get_min = -Math.max(-card1Num, Math.max(-card2Num, -card3Num)); 

      int get_mid = (card1Num + card2Num + card3Num) 
              - (get_max + get_min); 

      // Every card except J
      if((get_mid - get_min) == 1 && (get_max - get_mid) == 1)
        return true;

      // J as middle card
      if(((get_mid - get_min) == 2 && get_mid == 12) && (get_max - get_mid) == 1)
        return true;

      // J as third card
      if((get_mid - get_min) == 1 && ((get_max - get_mid) == 2 && get_max == 12))
        return true;
    }
    else
    {
      //First case: A is 1

      int card1Num = card1Face.equals("J") ? 12 :
                        card1Face.equals("Q") ? 13 :
                          card1Face.equals("K") ? 14 : 
                            card1Face.equals("A") ? 1 :
                              Integer.parseInt(card1Face);
      
      int card2Num = card2Face.equals("J") ? 12 :
                        card2Face.equals("Q") ? 13 :
                          card2Face.equals("K") ? 14 :
                            card2Face.equals("A") ? 1 : 
                              Integer.parseInt(card2Face);

      int card3Num = card3Face.equals("J") ? 12 :
                        card3Face.equals("Q") ? 13 :
                          card3Face.equals("K") ? 14 : 
                            card3Face.equals("A") ? 1 :
                              Integer.parseInt(card3Face);

      // Find maximum element 
      int get_max = Math.max(card1Num, Math.max(card2Num, card3Num)); 

      // Find minimum element 
      int get_min = -Math.max(-card1Num, Math.max(-card2Num, -card3Num)); 

      int get_mid = (card1Num + card2Num + card3Num) 
              - (get_max + get_min); 

      // Every card except J
      if((get_mid - get_min) == 1 && (get_max - get_mid) == 1)
        return true;

      // J as middle card
      if(((get_mid - get_min) == 2 && get_mid == 12) && (get_max - get_mid) == 1)
        return true;

      // J as third card
      if((get_mid - get_min) == 1 && ((get_max - get_mid) == 2 && get_max == 12))
        return true;

      // Second case: A = 15

      card1Num = card1Face.equals("J") ? 12 :
                  card1Face.equals("Q") ? 13 :
                    card1Face.equals("K") ? 14 : 
                      card1Face.equals("A") ? 15 :
                        Integer.parseInt(card1Face);

      card2Num = card2Face.equals("J") ? 12 :
                  card2Face.equals("Q") ? 13 :
                    card2Face.equals("K") ? 14 :
                      card2Face.equals("A") ? 1 : 
                        Integer.parseInt(card2Face);

      card3Num = card3Face.equals("J") ? 12 :
                  card3Face.equals("Q") ? 13 :
                    card3Face.equals("K") ? 14 : 
                      card3Face.equals("A") ? 15 :
                        Integer.parseInt(card3Face);

      // Find maximum element 
      get_max = Math.max(card1Num, Math.max(card2Num, card3Num)); 

      // Find minimum element 
      get_min = -Math.max(-card1Num, Math.max(-card2Num, -card3Num)); 

      get_mid = (card1Num + card2Num + card3Num) 
              - (get_max + get_min); 

      // Every card except J
      if((get_mid - get_min) == 1 && (get_max - get_mid) == 1)
        return true;

      // J as middle card
      if(((get_mid - get_min) == 2 && get_mid == 12) && (get_max - get_mid) == 1)
        return true;

      // J as third card
      if((get_mid - get_min) == 1 && ((get_max - get_mid) == 2 && get_max == 12))
        return true;


    }
    return false;    
  }

  private static boolean isFlush(String hand) {

    String card1 = getCard(1, hand);
    String card2 = getCard(2, hand);
    String card3 = getCard(3, hand);
    String card1Suit = card1.substring(card1.length() -1, card1.length() );
    String card2Suit = card2.substring(card2.length() -1, card2.length() );
    String card3Suit = card3.substring(card3.length() -1, card3.length() );

    if(card1Suit.equals(card2Suit) && card1Suit.equals(card3Suit))
      return true;
    else
      return false;    


  };
  private static boolean isThreeOfAKind(String hand) {
    String card1 = getCard(1, hand);
    String card2 = getCard(2, hand);
    String card3 = getCard(3, hand);
    String card1Face = card1.substring(0, card1.length() - 1);
    String card2Face = card2.substring(0, card2.length() - 1);
    String card3Face = card3.substring(0, card3.length() - 1);

    if(card1Face.equals(card2Face) && card1Face.equals(card3Face))
      return true;
    else
      return false;

  }
  private static boolean isStraightFlush(String hand) {
      
    return isFlush(hand) && isStraight(hand);
  }

  private static String getCard(int index, String hand) {
    if (index == 1)
      return hand.substring(0, hand.indexOf(" "));
    else {
      String temp = hand.substring(hand.indexOf(" ") + 1);
      if (index == 2)
        return temp.substring(0, temp.indexOf(" "));
      else if (index == 3)
        return temp.substring(temp.indexOf(" ") + 1);
      else {
        throw new IllegalArgumentException("Only have 3 cards!");
      }

    }

  }

  private static String dealCards() {
    String cards = "";

    for (int i = 0; i < 3; i++) {
      Boolean hasCard = false;
      while (!hasCard) {
        String card = getCard();
        if (isUnique(cards, card)) {
          cards += card + " ";
          hasCard = true;
        }
      }
    }
    
    return cards.substring(0, cards.length() - 1);
  }

  private static String getCard() {
    return getFace() + getSuit();
  }

  private static String getSuit() {
    int suit = (int) (Math.random() * NUM_SUITS);
    if (suit == HEARTS)
      return "H";
    else if (suit == DIAMONDS)
      return "D";
    else if (suit == CLUBS)
      return "C";
    else if (suit == SPADES)
      return "S";
    else
      return null;
  }

  private static String getFace() {
    int face = (int) (Math.random() * NUM_FACES + 2);
    if (face >= 2 && face <= 10)
      return "" + face;
    else if (face == JACK)
      return "J";
    else if (face == QUEEN)
      return "Q";
    else if (face == KING)
      return "K";
    else if (face == ACE)
      return "A";
    else
      return null;
  }

  public static boolean isUnique(String playerHand, String card) {
    return playerHand.indexOf(card) == -1;
  }

}