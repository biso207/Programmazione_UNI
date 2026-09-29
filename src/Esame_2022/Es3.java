public class Es3 {
	public static void main (String[] args) {
		int[] array = {0, 2, 7, 5, 99, 13};
		int somma = calcolaSommaArray(array);
		System.out.println("Risultato: " + somma);
	}
	
	public static int calcolaSommaArray(int[] array) {
		return calcolaSommaArray(array, 0);
	}
	
	
	public static int calcolaSommaArray(int[] array, int i) {
		if (i==array.length) return 0;
		
		
		if (array[i]%2!=0) return array[i]^2 + calcolaSommaArray(array, i+1);
		else return calcolaSommaArray(array, i+1);
	}
}