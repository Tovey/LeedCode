package xtu.cie.ldj;

public class GasStation {
	public int canCompleteCircuit_2(int[] gas, int[] cost) {
		int s = 0, sum = 0, tank = 0;
		for (int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];
			if(tank < 0){
				s = i + 1;
				sum += tank;
				tank = 0;
			}
		}
		return (sum + tank) < 0 ? -1 : s;
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int total = 0;
		int index = -1;

		for (int i = 0, sum = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				index = i;
				sum = 0;
			}
		}

		return total >= 0 ? index + 1 : -1;
	}
}
