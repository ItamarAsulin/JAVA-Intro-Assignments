package ex3;

import javax.swing.*;
import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3 {
    public static boolean mySplit(int[] nums) {
        if (!checkIfSumIsEven(nums)) {
            return false;
        }
        return mySplitStepForRecursion(nums);


    }

    public static boolean checkIfSumIsEven(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

        }
        return sum % 2 == 0;

    }

    public static boolean mySplitStepForRecursion(int[] nums) {
        List<Integer> origin = new ArrayList<>();
        List<Integer> groupA = new ArrayList<>();
        List<Integer> groupB = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            origin.add(nums[i]);
        }
        List<Integer> reducedOrigin = new ArrayList<>();
        reducedOrigin.addAll(origin);
        for (int i = 0; i < origin.size(); i++) {
            if (origin.get(i) % 5 == 0) {
                groupA.add(origin.get(i));
                reducedOrigin.remove(origin.get(i));
                continue;
            }
            if (origin.get(i) % 3 == 0 && origin.get(i) % 5 != 0) {
                groupB.add(origin.get(i));
                reducedOrigin.remove(origin.get(i));
            }

        }
        return recursionMySplit(reducedOrigin, groupA, groupB);
    }

    public static boolean recursionMySplit(List<Integer> origin, List<Integer> listA, List<Integer> listB) {
        if (origin.size() == 0) {
            return isEqual(listA, listB);
        } else {
            List<Integer> newListA = new ArrayList<>(listA);
            List<Integer> newListB = new ArrayList<>(listB);
            Integer temp = origin.get(origin.size() - 1);
            newListA.add(temp);
            origin.remove(temp);
            if (recursionMySplit(new ArrayList<Integer>(origin), new ArrayList<>(newListA), new ArrayList<Integer>(listB))) {
                return true;
            } else {
                newListA.remove(temp);
                newListB.add(temp);
                return recursionMySplit(new ArrayList<Integer>(origin), new ArrayList<>(listA), new ArrayList<Integer>(newListB));
            }

        }


    }

    public static boolean isEqual(List<Integer> a, List<Integer> b) {
        int sumA = 0;
        int sumB = 0;
        for (Integer integer : a) {
            sumA += integer;
        }
        for (Integer integer : b) {
            sumB += integer;

        }
        return sumA == sumB;
    }
}
