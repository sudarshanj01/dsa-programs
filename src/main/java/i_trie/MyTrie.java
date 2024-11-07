package i_trie;

import java.util.ArrayList;
import java.util.List;

//1.Trie = Tree where each NODE has [26 children array + isEndOfWord flag]
// 2. INSERT: Start@root → for each char → index=char-'a' → create/follow node → mark last as end
//3. SEARCH: Start@root → for each char → index=char-'a' → follow nodes → check if last is end
//4. DELETE: Find word → unmark end → remove unused nodes (if no children & not end of other word)
//5. AUTOCOMPLETE: Find prefix end → DFS from there → collect all words with that prefix
//6. Time: O(word_length) for insert/search/delete, O(prefix + results) for autocomplete
//7. Space: Each node = 26 pointers + 1 boolean → O(ALPHABET_SIZE × total_chars)
//8. Node[0] means 'a', Node[1] means 'b' ... Node[25] means 'z' (char - 'a')
//9. Example: "cat" = root→c[2]→a[0]→t[19]→markEnd
//10. Used for: Dictionary/Autocomplete/Spell-Check/Phone-Directory

public class MyTrie {
    private TrieNode root;

    public MyTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toLowerCase().toCharArray()) {
            int index = ch - 'a';
            if (current.getChildren()[index] == null) {
                current.getChildren()[index] = new TrieNode();
            }
            current = current.getChildren()[index];
        }
        current.setEndOfWord(true);

    }

    public void remove(String word) {
        removeHelper(root, word.toLowerCase(), 0);
    }

    private boolean removeHelper(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return isEmpty(current);
        }

        int charIndex = word.charAt(index) - 'a';
        TrieNode node = current.getChildren()[charIndex];

        if (node == null) {
            return false;
        }

        boolean shouldDeleteCurrentNode = removeHelper(node, word, index + 1);

        if (shouldDeleteCurrentNode) {
            current.getChildren()[charIndex] = null;
            return isEmpty(current);
        }

        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.getChildren()) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word.toLowerCase());
        return node != null && node.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix.toLowerCase()) != null;
    }

    private TrieNode searchNode(String str) {
        TrieNode current = root;

        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (current.getChildren()[index] == null) {
                return null;
            }
            current = current.getChildren()[index];
        }
        return current;
    }

    public List<String> autocomplete(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode node = searchNode(prefix.toLowerCase());

        if (node != null) {
            dfs(node, prefix, result);
        }

        return result;
    }

    private void dfs(TrieNode node, String prefix, List<String> result) {
        if (node.isEndOfWord()) {
            result.add(prefix);
        }

        for (int i = 0; i < 26; i++) {
            if (node.getChildren()[i] != null) {
                dfs(node.getChildren()[i], prefix + (char) ('a' + i), result);
            }
        }
    }

}

