package com.fjsg.sensitivewordfiltering;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    /**
     * 是否最后一个字符
     */
    private boolean isLeaf;

    /**
     * 子节点
     */
    private Map<Character, TrieNode> subNodeMap = new HashMap<Character, TrieNode>();

    /**
     * 新增node节点
     *
     * @param c
     * @param node
     */
    public void addNode(Character c, TrieNode node) {
        subNodeMap.put(c, node);
    }

    /**
     * 获取子节点
     *
     * @param c
     * @return
     */
    public TrieNode getSubNode(Character c) {
        return subNodeMap.get(c);
    }

    /**
     * 设置是否最后一个字符
     *
     * @param leaf
     */
    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    /**
     *
     * @return
     */
    public boolean isLeaf() {
        return isLeaf;
    }

}
