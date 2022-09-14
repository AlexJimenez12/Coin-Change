import java.util.HashMap;

public class CoinChangeMachine {

  // The int Array coins[] reassembles what coins are available to give back for the change.
  // int amount is how much change needs to be returned


  private static int smallestCoin(int coins[], int amount, HashMap temp) {
    // The number of diffrent coins you have is shown through difC
    int difC = coins.length;

    // Base case
    if (amount == 0)
      return 0;

    int result = Integer.MAX_VALUE;

    // You want to try out every coin that has a smaller value then amount
    for (int i = 0; i < difC; i++) {
      if (coins[i] <= amount) {
        int tempResult = smallestCoin(coins, amount - coins[i], temp);

        // Will check if result can be more simplified as well as making sure to
        // avoid any type of overflowing
        if (tempResult != Integer.MAX_VALUE && tempResult + 1 < result) {
          result = tempResult + 1;
          int newResult = coins[i] + 1;
          temp.replace(coins[i], newResult);
        }

      }
    }
    // returns the minimum amount of coins that are returned.
    return result;
  }


  public static void main(String args[]) {
    HashMap<Integer, Integer> temp = new HashMap<>();
    int coins[] = {1, 5, 10, 25};
    int V = 37;
    System.out
        .println("smallest amount of coins needed is " + smallestCoin(coins, V, temp));
  }
}
