package com.leetcode.solution;


/**
 * @Author : fanc
 * @Date : 2020/6/12 6:21 下午
 */
public class Trie {
    class TrieNode {
        TrieNode[] links;

        private final int N = 26;

        Boolean isEnd = false;

        TrieNode() {
            links = new TrieNode[N];
        }

        void putNode(char word, TrieNode newNode) {
            links[word - 'a'] = newNode;
        }

        void setEnd() {
            isEnd = true;
        }

        Boolean getIsEnd() {
            return isEnd;
        }

        TrieNode getNext(char word) {
            return links[word - 'a'];
        }

        Boolean containsWord(char word) {
            return links[word - 'a'] != null;
        }


    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsWord(c)) {
                node.putNode(c, new TrieNode());
            }
            node = node.getNext(c);
        }
        node.setEnd();
    }

    /**
     * 需要返回这个Node
     * @param word
     * @return
     */

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsWord(c)) {
                return null;
            }
            node = node.getNext(c);
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return searchPrefix(word) == null ? false : searchPrefix(word).getIsEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

}
