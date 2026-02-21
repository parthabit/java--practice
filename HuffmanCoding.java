import java.util.*;

class HuffmanNode {
    int freq;
    char ch;
    HuffmanNode left, right;
}

class HuffmanCoding {
    
    static class MyComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode x, HuffmanNode y) {
            return x.freq - y.freq;
        }
    }

    // Print Huffman codes
    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.ch)) {
            System.out.println(root.ch + ": " + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        String text = "huffman coding in java";
        Map<Character, Integer> freqMap = new HashMap<>();

        // Count frequency
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Priority queue
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(freqMap.size(), new MyComparator());

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            HuffmanNode node = new HuffmanNode();
            node.ch = entry.getKey();
            node.freq = entry.getValue();
            node.left = null;
            node.right = null;
            q.add(node);
        }

        // Build Huffman tree
        while (q.size() > 1) {
            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();

            HuffmanNode f = new HuffmanNode();
            f.freq = x.freq + y.freq;
            f.ch = '-';
            f.left = x;
            f.right = y;
            q.add(f);
        }

        // Print codes
        printCode(q.peek(), "");
    }
}
