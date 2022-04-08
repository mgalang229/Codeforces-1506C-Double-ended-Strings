import java.io.*;
import java.util.*;

public class Main {
	
	private static FastReader in;
	
	public static void main(String[] args) {
		in = new FastReader();
		int tc = 1;
		tc = in.nextInt();
		for(int t = 0; t < tc; t++) {
			new Solver();
		}
	}
	
	static class Solver { 
		Solver() {
			String a = in.next();
			String b = in.next();
			int n = a.length();
			int sz = 0;
			String largestWord = "";
			for(int i = 0; i < n; i++) {
				// get the prefix of every word in every i-th iteration as the starting character
				for(int j = i; j < n; j++) {
					String word = "";
					for(int k = i; k <= j; k++) {
						word += a.charAt(k);
					}
					if(b.contains(word) && word.length() > sz) {
						largestWord = word;
						sz = largestWord.length();
					}
				}
			}
			// remove the excess elements in both of the strings
			int ans = countRemovedExcess(a, largestWord, n, sz);
			ans += countRemovedExcess(b, largestWord, b.length(), sz);
			System.out.println(ans);
		}
	}
	
	/***
	 * Removes the excess characters and retains the largest common substring
	 * @param s
	 * @param largestWord
	 * @param n
	 * @param sz
	 * @return
	 */
	static int countRemovedExcess(String s, String largestWord, int n, int sz) {
		int res = 0;
		for(int i = 0; i + sz <= n; i++) {
			if(s.substring(i, i + sz).equals(largestWord)) {
				res += (i + (n - (i + sz)));
				break;
			}
		}
		return res;
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
