package conditionals;

public class Conditionals {
    public static boolean chimpTrouble(boolean aSmile, boolean bSmile){

        /**
         * Checks whether you're in trouble.
         * @param aSmile Is the first monkey smiling?
         * @param bSmile Is the second monkey smiling?
         * @return Boolean that states whether the function's user is in trouble.
         */

        return aSmile == bSmile;
    }

    public static boolean negPos(int val1, int val2, boolean negative){

        /**
         * Function that states whether the values are of opposite sign (default), or if they are both negative (negative = true).
         * @param val1 First value to be compared.
         * @param val2 Second value to be compared.
         * @param negative Determines the checking condition. If true, the function checks whether both numbers are negative.
         * @return Boolean that states whether the phone should be picked up or not.
         */

        if(!negative){
            return val1 * val2 < 0;
        } else {
            return val1 < 0 && val2 < 0;
        }
    }

    public static boolean pickUpPhone(boolean isMorning, boolean isMom, boolean isAsleep){

        /**
         * Should I pick up the phone?
         * @param isMorning Boolean that indicates if it's morning.
         * @param isMom Boolean signifying whether the caller is Mom.
         * @param isAsleep Boolean signifying whether the call recipient (you) is asleep.
         * @return Boolean that states whether the phone should be picked up or not.
         */

        boolean pickUp;

        //8 cases:

        if(isAsleep) { // covers 4 isAsleep==true cases.
            pickUp = false;
        } else if(isMom) { // covers 2 isMom==true && isAsleep==false cases, for both states of isMorning
            pickUp = true;
        } else if(isMorning) { //isAsleep==false, isMom==false, isMorning==true.
            pickUp = false;
        } else { //isAsleep==false, isMom==false, isMorning==false -> control condition; true.
            pickUp = true;
        }

        return pickUp;
    }

    public static String setAlarm(int day, boolean onVacation){
        /**
         * Sets an alarm.
         * @param day The day of the week. 0 -> Sunday, and so on. Maximum value is 6.
         * @param onVacation Boolean signifying whether the alarm-user is on vacation or not.
         * @return What time the alarm should be set to. Returns a String in the format "XX:XX" or the String "off".
         */

        boolean weekday = 1 <= day && day <= 5;
        if(onVacation){
            if(weekday){
                return "10:00";
            } else {
                return "off";
            }
        } else {
            if(weekday) {
                return "7:00";
            } else {
                return "10:00";
            }
        }
    }

    public static boolean onesDigitSame(int a, int b, int c){
        /**
         * Determines of 2 or more of 3 given non-negative integers share the same ones digit.
         * @param a The first integer to be compared.
         * @param b The second integer to be compared.
         * @param c The third integer to be compared.
         * @return Boolean: do at least two of the integers have the same ones digit?
         */

        int aOne = a % 10;
        int bOne = b % 10;
        int cOne = c % 10;

        if (aOne == bOne || bOne == cOne || aOne == cOne ){
            return true;
        } else {
            return false;
        }

    }

    public static int blackjack(int total1, int total2){

        /**
         * Determines the winner of two blackjack players, given the simulated values of their hands (both positive integers).
         * @param total1 The value of the first hand.
         * @param total2 The value of th second hand.
         * @return The value of the winning hand, 0 if both hands are a bust.
         */

        int close1 = 21 - total1;
        int close2 = 21 - total2;

        if(close1 < 0 && close2 < 0){
            return 0;
        } else if (close1 < 0) {
            return total2;
        } else if (close2 < 0) {
            return total1;
        } else {
            return Math.max(total1, total2);
        }

    }

    public static void main(String[] args){

        //Test cases for 6 functions above.

        System.out.println( chimpTrouble (true, true));  // true
        System.out.println( chimpTrouble (false, false)); // true
        System.out.println( chimpTrouble (true, false)); // false
        System.out.println( chimpTrouble (false, true)); // false

        System.out.println("");

        System.out.println( negPos (1, -1, false)); // true
        System.out.println( negPos (-1, 1, false)); // true
        System.out.println( negPos (1, 1, false)); // false
        System.out.println( negPos (-1, -1, false)); // false
        System.out.println( negPos (-4, -5, true)); // true
        System.out.println( negPos (-4, 5, true)); // false
        System.out.println( negPos (4, 5, true)); // false
        System.out.println( negPos (4, -5, true)); // false

        System.out.println("");

        System.out.println( pickUpPhone (false, false, true)); // false
        System.out.println( pickUpPhone (true, true, true)); // false
        System.out.println( pickUpPhone (true, true, false)); // true
        System.out.println( pickUpPhone (false, true, false)); // true
        System.out.println( pickUpPhone (true, false, false)); // false
        System.out.println( pickUpPhone (false, false, false)); // true

        System.out.println("");

        System.out.println( setAlarm (1, false)); // "7:00"
        System.out.println( setAlarm (5, false)); // "7:00"
        System.out.println( setAlarm (0, false)); // "10:00"
        System.out.println( setAlarm (2, true)); // "10:00"
        System.out.println( setAlarm (4, true)); // "10:00"
        System.out.println( setAlarm (6, true)); // "off"

        System.out.println("");

        System.out.println( onesDigitSame (23, 19, 13)); // true
        System.out.println( onesDigitSame (23, 19, 12)); // false
        System.out.println( onesDigitSame (23, 19, 3)); // true
        System.out.println( onesDigitSame (423, 13, 3)); // true
        System.out.println( onesDigitSame (23, 29, 25)); // false

        System.out.println("");

        System.out.println( blackjack (19, 21)); // 21
        System.out.println( blackjack (21, 19)); // 21
        System.out.println( blackjack (19, 22)); // 19
        System.out.println( blackjack (8, 8)); // 8
        System.out.println( blackjack (25, 24)); // 0

    }
}
