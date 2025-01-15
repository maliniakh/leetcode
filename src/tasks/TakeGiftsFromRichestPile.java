package tasks;

public class TakeGiftsFromRichestPile {
    static public long pickGifts(int[] gifts, int k) {
        for(;k>0;k--) {
            int max = 0;
            int maxIdx = 0;
            for(int i = 0; i < gifts.length; i++) {
                if(gifts[i] > max) {
                    max = gifts[i];
                    maxIdx = i;
                }
            }

            gifts[maxIdx] = (int) Math.sqrt(gifts[maxIdx]);
        }

        long sum = 0;
        for (int gift : gifts) {
            sum += gift;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] gifts = {25,64,9,4,100};
        System.out.println(pickGifts(gifts, 4));
    }
}
