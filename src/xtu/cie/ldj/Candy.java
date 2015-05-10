package xtu.cie.ldj;

public class Candy {
	public int candy_2(int[] ratings){
		int[] num = new int[ratings.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = 1;
		}
		for (int i = 1; i < num.length; i++) {
			if(ratings[i] > ratings[i - 1])
				num[i] = num[i - 1] + 1;
		}
		int sum = num[num.length - 1];
		for (int i = num.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && num[i] <= num[i + 1]) {
				num[i] = num[i+1] + 1;
			}
			sum += num[i];
		}
		return sum;
	}
	
	
	//StackOverflowError
	public int candy(int[] ratings) {
		int[] num = new int[ratings.length];
		int sum = 0;
		for (int i = 0; i < ratings.length; i++) {
			sum += solve(ratings,num,i);
		}
		return sum;
	}

	private int solve(final int[] ratings, int[] num, int i) {
		if (num[i] == 0) {
			num[i] = 1;
			if (i > 0 && ratings[i] > ratings[i - 1]) {
				num[i] = Math.max(num[i], solve(ratings, num, i - 1) + 1);
			}
			if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
				num[i] = Math.max(num[i], solve(ratings, num, i + 1) + 1);
			}
		}
		return num[i];
	}
}
