import java.util.*;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
             //write your code here
              int index=0;
        Coordinate[] c=new Coordinate[starts.length+ends.length+points.length]; //will store all points in sorted order
        //store all the points in Coordinates along with their type character
        for(int start:starts)
            c[index++]=new Coordinate(start,'l');
        for(int end:ends)
            c[index++]=new Coordinate(end,'r');
        for(int point:points)
            c[index++]=new Coordinate(point,'p');
        //will use this map to find index of points to be stored in cnt Array.
        //value is List because there may be repeated points on different indexes
        Map<Integer, List<Integer>> mapPointsToIndex = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            if(! mapPointsToIndex.containsKey(points[i]))
                mapPointsToIndex.put(points[i], new ArrayList<>());
            mapPointsToIndex.get(points[i]).add(i);
        }
        // Sort all Coordinates by values
        Arrays.sort(c, new Comparator<Coordinate>(){
            @Override
            public int compare(Coordinate p1, Coordinate p2) {
                // BZ: what if p == l == r?
                // sort by l->p->r, i.e. segment still contains p.
                // It is indeed fortunate that the letters 'l', 'p',
                // and 'r' are in the correct lexicographical order.
                return p1.value == p2.value ? p1.mark - p2.mark :    //if values are equal sort lexicographically else by values
                    p1.value - p2.value;
            }
        });
                // Count # of segments containing each point
        int count = 0;
        for (Coordinate cor : c) {
            if (cor.mark == 'l') count++;              //starting segment before point means include it.
            if (cor.mark == 'r') count--;              //ending segment before point means exclude the above included point.
            if (cor.mark == 'p') {                     //the actual point, store the count for that point at correct position in cnt array.
                // BZ: duplicate points? -> have same counts,
                // but fill in all indices with point p
                for (int i : mapPointsToIndex.get(cor.value))  //HashMap is used here to get all indexes of a repeated point 
                    cnt[i] = count;
            }
        }

        return cnt;
    }
    private static class Coordinate {
        int value;
        char mark;
        public Coordinate (int v, char m) {
            value = v;
            mark  = m;
        }
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

