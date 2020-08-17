package mainIdea.offer;

import java.util.*;

/**
 * @author yoyo
 * @mail yoyo185644@163.com
 * @date 2020/8/16 4:47 下午
 */
/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子
矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class hasPath {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        map.put("s",2);
        map.put("t",3);
        map.put("r",1);
        priorityQueue.offer("s");
        priorityQueue.offer("t");
        priorityQueue.offer("r");
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

    }
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        int mlen = matrix.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, List<Integer>> errorNodeList = new HashMap<>();

        for (int i = 0; i < mlen - 1; i++) {
            if (matrix[i] == str[0]) {
                stack.push(i);
                while (stack.size() >= 1 && stack.size() < str.length) {
                    Integer idx = stack.peek();
                    int sSize = stack.size();
                    List<Integer> eList = errorNodeList.getOrDefault(sSize, new ArrayList<Integer>());
                    if (idx - cols >= 0 && matrix[idx - cols] == str[stack.size()]) {
                        if (!eList.contains(idx - cols)) {
                            stack.push(idx - cols);
                            continue;
                        }
                    }
                    if ((idx + cols) <= mlen - 1 && matrix[idx + cols] == str[stack.size()]) {
                        if (!eList.contains(idx + cols)) {
                            stack.push(idx + cols);
                            continue;
                        }
                    }
                    if ((idx + 1 % cols) != 0 && idx + 1 <= mlen - 1 && matrix[idx + 1] == str[stack.size()]) {
                        if (!eList.contains(idx + 1)) {
                            stack.push(idx + 1);
                            continue;
                        }
                    }
                    if ((idx % cols) != 0 && idx - 1 >= 0 && matrix[idx - 1] == str[stack.size()]) {
                        if (!eList.contains(idx - 1)) {
                            stack.push(idx - 1);
                            continue;
                        }
                    }
                    eList.add(stack.pop());
                    errorNodeList.put(sSize, eList);
                }
                if (stack.size() == str.length) {
                    return true;
                }
            }
        }
        return false;

    }



}
