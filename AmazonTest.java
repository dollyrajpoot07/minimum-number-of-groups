// Amazon Prime video is a subscription video on-demand over-the-top streaming and rental service. 
//The team at Prime Video is developing a method to divide movies into groups based on the number theyy have won. 
//A group can consist of any number of movies, but the difference in the number of awards won by any two movies in the group must not exceed k.
// The movies can be grouped together irrespective of their initial order. Determine the minimum number of groups that can be formed 
//such that each movie is in exactly one group. Example: The numbers of awards per movie are awards = [1, 5, 4, 6, 8, 9, 2], 
// and the maximum allowed difference is k = 3. One way to divide the movies into the minimum number of groups is:
// 1. The 1st group can contain [2, 1]. the maximum difference between awards of any two movies is 1 which does not exceed k.
// 2. The 2nd group can contain [5, 4, 6]. The maximum difference between awards of any two movies is 2 which does not exceed k.
// 3. The 3rd group can contain [8, 9]. The maximum difference between awards of any two movies is 1 which does not exceed k.
// the movies can be divided into minimum of 3 groups.

import java.util.*;

public class AmazonTest {
    
    public static int minGroups(List<Integer> awards, int k) {
        
        Collections.sort(awards);
        int len = awards.size();
        if(len == 0) {
            return 0;
        }
        int grpCount = 1;
        int grpStart = awards.get(0);
        
        for(int i=1; i<len; i++) {
            if((awards.get(i)- grpStart) > k) {
                grpCount++;
                grpStart = awards.get(i);
            }
        }
        return grpCount;
        
    }
	public static void main(String[] args) {
		int k = 3;
		List<Integer> awards = new ArrayList<Integer>(); 
		awards.add(1);
		awards.add(5);
		awards.add(4);
		awards.add(6);
		awards.add(8);
		awards.add(9);
		awards.add(2);
		int res = minGroups(awards, k);
		System.out.println(res);
	}
}
