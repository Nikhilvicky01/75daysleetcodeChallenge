class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0; // nums1 pointer
        int j = 0; // nums2 pointer
        int k = 0; // position to fill

        while (i < m && j < n) {

            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                // Shift nums1 elements to the right
                for (int x = m; x > i; x--) {
                    nums1[x] = nums1[x - 1];
                }

                nums1[i] = nums2[j];

                i++;
                j++;
                m++;
            }
        }

        // Copy remaining nums2 elements
        while (j < n) {
            nums1[m] = nums2[j];
            j++;
            m++;
        }
    }
}