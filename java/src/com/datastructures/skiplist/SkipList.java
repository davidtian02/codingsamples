package com.datastructures.skiplist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidtian on 11/5/14.
 */
public class SkipList {
    private static class Node {
        int value;
        Node up;
        Node down;
        Node left;
        Node right;
        public Node(int val) {
            value = val;
        }
//        public boolean promote() {
//            boolean needsToResetHeadAndTail = false;
//            // can't OVER promote someone
//            if (left.value == Integer.MIN_VALUE && left.up == null) {
//                left.up = new Node(Integer.MIN_VALUE);
//                left.up.down = left;
//                left.up.right = new Node(Integer.MAX_VALUE);
//                left.up.right.down = right;
//                right.up = left.up.right;
//                needsToResetHeadAndTail = true;
//            }
//
//            up = new Node(value);
//            up.down = this;
//            // set right
//            Node temp = right;
//            while (temp.up == null) {
//                if (temp.value == Integer.MAX_VALUE) {
//                    break;
//                }
//                temp = temp.right;
//            }
//            up.right = temp.up;
//            temp.up.left = up;
//
//            // set left
//            temp = left;
//            while (temp.up == null) {
//                if (temp.value == Integer.MIN_VALUE) {
//                    break;
//                }
//                temp = temp.left;
//            }
//            up.left = temp.up;
//            temp.up.right = up;
//
//            return needsToResetHeadAndTail;
//        }
    }

    private Node mHead;
    private Node mTail;

    public SkipList() {
        mHead = new Node(Integer.MIN_VALUE);
//        mHead.up = new Node(Integer.MIN_VALUE);
//        mHead.up.down = mHead;
        mTail = new Node(Integer.MAX_VALUE);
//        mTail.up = new Node(Integer.MAX_VALUE);
//        mTail.up.down = mTail;
        mHead.right = mTail;
//        mHead.up.right = mTail.up;
        mTail.left = mHead;
//        mTail.up.left = mHead.up;

//        mHead = mHead.up;
//        mTail = mTail.up;
    }

    public void insert(int value) {
        count = 0;


        Node temp = mHead;
//        while (temp.down != null) {
//            while (temp.right.value > value && temp.down != null) {
//                temp = temp.down;
//            }
//            while (temp.right.value < value) {
//                temp = temp.right;
//            }
//        }

        boolean found = false;
        while (!found) {
            while(temp.right.value < value) {
                temp = temp.right;
            }
            if (temp.down == null) {
                found = true;
            } else {
                temp = temp.down;
            }
        }

        Node newNode = new Node(value);
        newNode.left = temp;
        newNode.right = temp.right;
        newNode.left.right = newNode;
        newNode.right.left = newNode;

        while (shouldPromote()) {
            System.out.println("promoting!");
//            System.out.println("---------------------");

            Node promotionNode = new Node(value);
            newNode.up = promotionNode;
            promotionNode.down = newNode;
            // find closes left node that in 1 level above newNode's level.
            temp = newNode.left;

            boolean shouldBreak = false;

            while(!shouldBreak) {
                if (temp.up != null) {
//                    temp.up.right.left = promotionNode;
//                    promotionNode.right = temp.up.right;
                    temp.up.right = promotionNode;
                    promotionNode.left = temp.up;
                    shouldBreak = true;
                    break;
                } else {
                    if (temp.value == Integer.MIN_VALUE) {
                        Node newTopLeft = new Node(Integer.MIN_VALUE);
                        temp.up = newTopLeft;
                        newTopLeft.down = temp;
                        newTopLeft.right = promotionNode;
                        promotionNode.left = newTopLeft;
                        shouldBreak = true;
                        break;
                    } else {
                        temp = temp.left;
                    }
                }
            }

            temp = newNode.right;
            shouldBreak = false;
            while(!shouldBreak) {
                if (temp.up != null) {
//                    temp.up.left.right = promotionNode;
//                    promotionNode.left = temp.up.left;
                    temp.up.left = promotionNode;
                    promotionNode.right = temp.up;
                    shouldBreak = true;
                    break;
                } else {
                    if (temp.value == Integer.MAX_VALUE) {
                        Node newTopRight = new Node(Integer.MAX_VALUE);
                        temp.up = newTopRight;
                        newTopRight.down = temp;
                        newTopRight.left = promotionNode;
                        promotionNode.right = newTopRight;
                        shouldBreak = true;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }

            newNode = promotionNode;

            if (mHead.up != null) {
                mHead = mHead.up;
            }

            if (mTail.up != null) {
                mTail = mTail.up;
            }
//            System.out.println(this);

//            System.out.println("---------------------");
        }

//        Node oldTempRight = temp.right;
//        Node oldTempLeft = temp;
//
//        Node newNode = new Node(value);
//        oldTempLeft.right = newNode;
//        oldTempRight.left = newNode;
//        newNode.left = oldTempLeft;
//        newNode.right = oldTempRight;
//
//        if(shouldPromote()) {
//            if (newNode.promote()) {
//                Node newTopLeft = new Node(Integer.MIN_VALUE);
//                Node newTopRight = new Node(Integer.MAX_VALUE);
//                newTopLeft.down = mHead;
//                newTopRight.down = mTail;
//                mHead.up = newTopLeft;
//                mTail.up = newTopRight;
//                mHead = newTopLeft;
//                mTail = newTopRight;
//                mHead.right = mTail;
//                mTail.left = mHead;
//            }
//        }
    }

    private static int count = 0;

    private static boolean shouldPromote() {
        return (((int)(Math.random() * 10)) % 2) == 1;
//        return ++count < 3;
    }

    @Override
    public String toString() {
        List<List<String>> matrix = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        Node tempVerticle = mHead;
        int height = 1;
        int width = 0;
        while(tempVerticle.down != null) {
            tempVerticle = tempVerticle.down;
            height++;
        }
        Node tempHorizontal = tempVerticle;
        while(tempHorizontal != null) {
            tempHorizontal = tempHorizontal.right;
            width++;
        }
        tempHorizontal = tempVerticle;
        for (int i=0; i<width; i++) {
            matrix.add(new ArrayList<String>());
        }

        int row = 0;

        while(tempHorizontal != null) {
            tempVerticle = tempHorizontal;
            int col = 0;
            while(col < height) {
                if (tempVerticle != null) {
                    matrix.get(row).add(tempVerticle.value + ", ");
                    tempVerticle = tempVerticle.up;
                } else {
                    matrix.get(row).add("n, ");
                }
                col++;
            }
            tempHorizontal = tempHorizontal.right;
            row++;
        }

        for (int j=height-1; j>=0; j--) {
            for (int i=0; i<width; i++) {
                result.append(matrix.get(i).get(j));
            }
            result.append("\n");
        }

        return result.toString();
    }

}
