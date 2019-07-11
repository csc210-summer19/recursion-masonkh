/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Mason Kerns-Harper CSC210 Summer 2019
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (n < k || k < 1) {
			return 0;
		} else if (n == k) {
			return 1;
		} else if (k == 1) {
			return n;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String holder = String.valueOf(n);
		String newString = holder.substring(0, 1);
		if (n < 1000) {
			return String.valueOf(n);
		}
		int count = 0;
		if (holder.length() == 0) {
			return newString;
		} else if (holder.length() - 1 % 3 == 0) {
			newString += ",";
		}
		System.out.println(newString);
		System.out.println(newString);
		return intWithCommas(Integer.valueOf(holder.substring(1)));

	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (index < len) {
			int temp = x[index];
			x[index] = x[len - 1];
			x[len - 1] = temp;
			reverseArray(x, index + 1, len - 1);
		}

	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		if (a.length == 2) {
			return Math.max(a[0], a[1]) - Math.min(a[0], a[1]);
		} else {

		}
		return Integer.MIN_VALUE;
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		int[] copied = null;
		if (nums.length <= 1) {
			return true;
		} else if (nums[0] > nums[1]) {
			return false;
		} else {
			copied = new int[nums.length - 1];
			System.arraycopy(nums, 1, copied, 0, copied.length);
			return isSorted(copied);
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		String[] copied = null;
		if (strs.length > 1) {
			copied = new String[strs.length - 1];
			System.arraycopy(strs, 1, copied, 0, copied.length);

		} else {
			copied = new String[strs.length];
			System.arraycopy(strs, 0, copied, 0, copied.length);
		}
		if (strs[0].equals(search)) {
			return true;
		} else if (strs.length == 1) {
			return false;
		} else {
			return found(search, copied);
		}
	}
}
