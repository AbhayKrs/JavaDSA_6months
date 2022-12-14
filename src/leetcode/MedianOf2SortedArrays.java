package leetcode;

public class MedianOf2SortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length; // m = 2, n= 2;
        int l = (m + n + 1) / 2; // l = 2;
        int r = (m + n + 2) / 2; // r = 3;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1]; // if start of array A is greater than its length, return last of B
        if (bStart > B.length - 1) return A[aStart + k - 1]; // if start of array B is greater than its length, return last of A
        if (k == 1) return Math.min(A[aStart], B[bStart]); //

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart, k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aStart, B, bStart + k/2, k - k/2);// Check: bRight + aLeft}
    }
}
