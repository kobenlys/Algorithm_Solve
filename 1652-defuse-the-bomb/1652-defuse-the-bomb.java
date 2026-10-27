class Solution {
    public int[] decrypt(int[] code, int k) {

        int[] arr1 = new int[code.length];
        int size = code.length;

        if (k == 0) {
            return arr1;
        }

        for (int i = 0; i < size; i++) {

            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    arr1[i] += code[(i + j) % size];
                }
            } else {
                for (int j = -1; j >= k; j--) {
                    int pos = i + j >= 0 ? i + j : i + j + size;
                    arr1[i] += code[pos];
                }
            }

        }

        return arr1;
    }
}