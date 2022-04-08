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
			int n = a.length(), m = b.length();
			int ans = 0;
			// find the largest common substring between Strings a and b
			for(int len = 1; len <= Math.min(n, m); len++) {
				for(int i = 0; i + len <= n; i++) {
					for(int j = 0; j + len <= m; j++) {
						if(a.substring(i, i + len).equals(b.substring(j, j + len))) {
							ans = Math.max(ans, len);
						}
					}
				}
			}
			// calculate the total number of removed characters
			// let n, m, and ans be the length of Strings a, b, and
			// their common substring respectively
			// = (n - ans) + (m - ans)
			// = n - ans + m - ans
			// = n + m - ans - ans
			// = n + m - 2ans
			System.out.println(n + m - (2 * ans));
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
