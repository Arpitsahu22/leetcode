class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1];

        for(int i = 0; i < n1; i++){
            res[i] = -1; 
            int index = 0;
            for(int j = 0; j < n2; j++){
                if(nums2[j] == nums1[i]){
                    index = j;
                    break;
                }
            }
            for(int j = index + 1; j < n2; j++){
                if(nums2[j] > nums1[i]){
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}
