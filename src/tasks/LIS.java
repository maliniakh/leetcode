package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {
    public int lis(int[] arr) {
        int[] seq = new int[arr.length];
        Arrays.fill(seq, 1);

        for(int i = arr.length - 1; i >= 0; i--) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    seq[i] = Integer.max(seq[i], seq[j] + 1);
                }
            }
        }

        return Arrays.stream(seq).max().getAsInt();
    }

    public List<Integer> lisValues(int[] arr) {
        List<List<Integer>> seq = new ArrayList<>(arr.length);
        for(int i = 0; i < arr.length; i++) {
            seq.add(List.of(arr[i]));
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] < arr[j]) {
                    if(seq.get(i).size() < seq.get(j).size() + 1) {
                        ArrayList<Integer> newSeq = new ArrayList<>();
                        newSeq.addAll(seq.get(i));
                        newSeq.addAll(seq.get(j));

                        seq.set(i, newSeq);
                    }
                }
            }
        }

        return seq.stream().max((l1, l2) -> l1.size() - l2.size()).get().stream().sorted().toList();
    }

    public static void main(String[] args) {
        int lis = new LIS().lis(new int[]{1, 2, 4, 3, -1, 5, 6});
        System.out.println("lis " + lis);

        List<Integer> listVals = new LIS().lisValues(new int[]{2, -2, 1, -2, 2, 4, 3, -1, 5, 6});
        System.out.println("lis " + listVals);
    }
}


