package com.mostaskquestions.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jitendra Kumar : 27/8/18
 */
public class LRUCache {
    private final int cacheSize;
    private DoublyLinkedList pageList;
    private Map<Integer, Node1> pageMap;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        pageList = new DoublyLinkedList(cacheSize);
        pageMap = new HashMap<Integer, Node1>();
    }

    public static void main(String[] args) {
        int cacheSize = 4;
        LRUCache cache = new LRUCache(cacheSize);
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(2);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(1);
        cache.printCacheState();
        cache.accessPage(4);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
        cache.accessPage(7);
        cache.printCacheState();
        cache.accessPage(8);
        cache.printCacheState();
        cache.accessPage(3);
        cache.printCacheState();
    }

    public void accessPage(int pageNumber) {
        Node1 pageNode = null;
        if (pageMap.containsKey(pageNumber)) {
// If page is present in the cache, move the page to the start of list
            pageNode = pageMap.get(pageNumber);
            pageList.movePageToHead(pageNode);
        } else {
// If the page is not present in the cache, add the page to the cache
            if (pageList.getCurrSize() == pageList.getSize()) {
// If cache is full, we will remove the tail from the cache pageList
// Remove it from map too
                pageMap.remove(pageList.getTail().getPageNumber());
            }
            pageNode = pageList.addPageToList(pageNumber);
            pageMap.put(pageNumber, pageNode);
        }
    }

    public void printCacheState() {
        pageList.printList();
        System.out.println();
    }
}

class DoublyLinkedList {
    private final int size;
    private int currSize;
    private Node1 head;
    private Node1 tail;

    public DoublyLinkedList(int size) {
        this.size = size;
        currSize = 0;
    }

    public Node1 getTail() {
        return tail;
    }

    public void printList() {
        if (head == null) {
            return;
        }
        Node1 tmp = head;
        while (tmp != null) {
            System.out.print(tmp);
            tmp = tmp.getNext();
        }
    }

    public Node1 addPageToList(int pageNumber) {
        Node1 pageNode = new Node1(pageNumber);
        if (head == null) {
            head = pageNode;
            tail = pageNode;
            currSize = 1;
            return pageNode;
        } else if (currSize < size) {
            currSize++;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
        return pageNode;
    }

    public void movePageToHead(Node1 pageNode) {
        if (pageNode == null || pageNode == head) {
            return;
        }
        if (pageNode == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        Node1 prev = pageNode.getPrev();
        Node1 next = pageNode.getNext();
        prev.setNext(next);
        if (next != null) {
            next.setPrev(prev);
        }
        pageNode.setPrev(null);
        pageNode.setNext(head);
        head.setPrev(pageNode);
        head = pageNode;
    }

    public int getCurrSize() {
        return currSize;
    }

    public void setCurrSize(int currSize) {
        this.currSize = currSize;
    }

    public Node1 getHead() {
        return head;
    }

    public void setHead(Node1 head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }
}

class Node1 {
    private int pageNumber;
    private Node1 prev;
    private Node1 next;

    public Node1(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int data) {
        this.pageNumber = data;
    }

    public Node1 getPrev() {
        return prev;
    }

    public void setPrev(Node1 prev) {
        this.prev = prev;
    }

    public Node1 getNext() {
        return next;
    }

    public void setNext(Node1 next) {
        this.next = next;
    }

    public String toString() {
        return pageNumber + "  ";
    }
}
