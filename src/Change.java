
public class Change {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(change(25));
		System.out.println(change(100));

	}
	
	public static int change(int cents){
		return changeHelper(cents, "Q");
	}
	
	/**
	 * @param integer number of cents, String- largest denomination allowed- either "Q", "D", "N" or "P"
	 */
	public static int changeHelper(int cents, String largest) {
		int count = 0;
		// first determine number of Q, then D, N, P
		int numQ= cents/25;
		int numD = cents/10;
		int numN = cents/5;
		
		if (largest.equals("Q")){ //number of ways using quarters as largest denom allowed
			for (int i = 1; i <= numQ; i++) {
				count += changeHelper(cents - i*25, "D");
			}
			for (int i = 1; i <= numD; i++) {
				count +=  changeHelper(cents - i*10, "N");
			}
			for (int i = 1; i <= numN; i++) {
				count += changeHelper(cents - i*5, "P");
			}
			
		} else if (largest.equals("D")){ //number of ways using dimes as largest

			for (int i = 1; i <= numD; i++) {
				count += changeHelper(cents - i*10, "N");
			}
			for (int i = 1; i <= numN; i++) {
				count += changeHelper(cents - i*5, "P");
			}
			
		} else if (largest.equals("N")){ //using nickels and pennies
			for (int i = 1; i <= numN; i++) {
				count += changeHelper(cents - i*5, "P");
			}			
		} 
		count++; //using pennies for the rest
		return count;

	}

}
