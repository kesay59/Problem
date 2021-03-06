import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//EA 10580 전봇대
public class EA10580 {
	
	
	static class Line implements Comparable<Line>{
		int from, to;
		Line(int from, int to) {
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(Line o) {
			return this.from - o.from;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Line[] lines;
		int test_case = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= test_case; tc++) {
			int len = Integer.parseInt(br.readLine());
			lines = new Line[len];
			for(int i = 0; i < len; i++) {
				st = new StringTokenizer(br.readLine());
				lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(lines);
			
			int cnt = 0;
			for(int i = 1; i < len; i++) 
				for(int j = i-1; j >= 0; j--) 
					if(lines[i].to < lines[j].to) cnt++;
			System.out.println("#" + tc + " " + cnt);
		}
	}
}