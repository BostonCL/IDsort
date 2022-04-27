import java.util.Scanner;
import java.util.ArrayList;

public class UserIDSorting {

    // middle pivot, compare the values using two index variables l and h (low and high),
    // initialized to the left and right sides of the current elements being sorted,
    // and determine if a swap is necessary
    public static int partition(ArrayList<String> userIDs, int i, int k) {
        String pivot = userIDs.get(k);
        int left = (i - 1);
        for (int right = i; right < k; right++) {
            if (userIDs.get(right).compareTo(pivot) < 0) {
                left++;
                String temp = userIDs.get(left);
                userIDs.set(left, userIDs.get(right));
                userIDs.set(right, temp);
            }
        }
        String temp = userIDs.get(left + 1);
        userIDs.set(left + 1, userIDs.get(k));
        userIDs.set(k, temp);
        return left + 1;
    }

    //quicksort algorithm

    public static void quicksort(ArrayList<String> userIDs, int i, int k) {
        if (i < k) {
            int pi = partition(userIDs, i, k);
            quicksort(userIDs, i, pi - 1);
            quicksort(userIDs, pi + 1, k);
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        ArrayList<String> userIDList = new ArrayList<String>();

        String userID;

        userID = scnr.next();
        while (!userID.equals("-1")) {
            userIDList.add(userID);
            userID = scnr.next();
        }

        // Initial call to quicksort
        quicksort(userIDList, 0, userIDList.size() - 1);
        for (int i = 0; i < userIDList.size(); ++i) {
            System.out.println(userIDList.get(i));
        }
    }
}
