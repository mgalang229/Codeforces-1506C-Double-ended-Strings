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
			// remove the excess elements
			int ans = 0;
			for(int i = 0; i + sz <= n; i++) {
				if(a.substring(i, i + sz).equals(largestWord)) {
					ans += (i + (n - (i + sz)));
					break;
				}
			}
			int m = b.length();
			for(int i = 0; i + sz <= m; i++) {
				if(b.substring(i, i + sz).equals(largestWord)) {
					ans += (i + (m - (i + sz)));
					break;
				}
			}
			System.out.println(ans);
		}
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
