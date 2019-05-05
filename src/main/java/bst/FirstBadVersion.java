package bst;


public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while(start<end) {
            // using "(end-start)/2 + start" instead of "(start+end)/2" to
            // prevent stackoverflow
            int mid = (end-start)/2 + start;

            if(isBadVersion(mid)) {
                //Because we want to find the first bad version, that's why it
                // is "end=mid" instead of "end = mid-1"
                end = mid;
            } else {
                start = mid+1;
            }

        }
        // Eventually start and end will meet, therefore either start or end will do
        return end;
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
