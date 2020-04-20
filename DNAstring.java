package topcoder_DNAstring;

import java.util.Scanner;

public class DNAstring {

	public static void main(String[] args) {
		
		String M, dna;
		
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextLine();
		dna = sc.nextLine();
		
		int m = Integer.parseInt(M);
		char[] chs = dna.toCharArray();
		
		ACGTclass cls = new ACGTclass();
		int ans = cls.countManyChar(chs, m);
		for(int i = m - 1; i > 0; i--) {
			int cn2 = cls.countManyChar(chs, i);
			
			if(cn2 < ans) {
				ans = cn2;
			}
		}
		
		System.out.println(ans);
		
	}

}

class ACGTclass {
	
	public int countManyChar(char[] chs, int m) {
		int res = 0, id = 0;
		
		//주기 m (예: 3이면 0, 1, 2)까지만 반복시킴
		while(id < m) {
			int j = id;
			int ac = 0, cc = 0, gc = 0, tc = 0;
			for(;j < chs.length; j = j + m) {
				switch (chs[j]) {
				case 'A':
					ac++;
					break;
					
				case 'C':
					cc++;
					break;
					
				case 'G':
					gc++;
					break;
					
				case 'T':
					tc++;
					break;
		
				default:
					break;
				}
			}
			int mxc1 = (ac > cc) ? ac : cc;
			int mxc2 = (gc > tc) ? gc : tc;
			int maxC = (mxc1 > mxc2) ? mxc1 : mxc2;
			res += ((ac + cc + gc + tc) - maxC);
			
			id++;
		}
		return res;
	}
}