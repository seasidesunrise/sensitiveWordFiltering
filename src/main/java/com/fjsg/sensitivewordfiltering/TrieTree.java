package com.fjsg.sensitivewordfiltering;

import org.apache.commons.lang3.StringUtils;

public class TrieTree {

    /**
     * 根节点
     */
    private TrieNode rootNode = new TrieNode();

    /**
     * 往trie树中添加新词
     *
     * @param lineText
     */
    public void addWord(String lineText) {
        TrieNode tempNode = rootNode;

        for (int i = 0; i < lineText.length(); i++) {
            Character word = lineText.charAt(i);
            TrieNode node = tempNode.getSubNode(word);

            if (node == null) {
                node = new TrieNode();
                tempNode.addNode(word, node);
            }
            tempNode = node;
            if (i == lineText.length() - 1) {
                tempNode.setLeaf(true);
            }
        }
    }

    /**
     * 判断是否包含屏蔽关键词
     *
     * @param text
     * @return true false
     */
    public boolean check(String text) {
        if (StringUtils.isEmpty(text)) {
            return false;
        }

        TrieNode tempNode = rootNode;
        int begin = 0, position = 0;
        while (position < text.length()) {
            char word = text.charAt(position);
            tempNode = tempNode.getSubNode(word);
            if (tempNode == null) {
                position = begin + 1;
                begin = position;

                // 重新从rootNode开始
                tempNode = rootNode;
            } else if (tempNode.isLeaf()) {
                return true;
            } else {
                position++;
            }
        }

        return false;
    }

}
