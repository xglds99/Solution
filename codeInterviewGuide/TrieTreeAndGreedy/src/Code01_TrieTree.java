

class Code01_TrieTree_1 {

	/**
	 * 前缀树可以很方便找到以 “xx”开头的字符串有几个
	 */
    public static class TrieNode {
        public int path;  //在加前缀树的时候这个结点达到过多少次，也就是有多少个字符串有这个结点
        public int end;  //这个结点是否是一个字符串的结尾结点，如果是的话他是多少个字符串的结尾结点
        public TrieNode[] nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }



        public void insert(String word){
        	if (word == null)
        		return;
			char[] chars = word.toCharArray();
			TrieNode node = root;
			node.path++;
			int index = 0;
			for (char ch : chars) {
				index = ch - 'a';
				if (node.nexts[index] == null){
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.path++;
			}
			node.end++;
		}


        public void delete(String word){
        	if (word == null)
        		return;
			char[] chars = word.toCharArray();
			TrieNode node = root;
			node.path--;
			int index = 0;
			for (char ch : chars) {
				index = ch - 'a';
				if (--node.nexts[index].path == 0){
					node.nexts[index] = null;
					return;
				}
				node = node.nexts[index];
			}
			node.end--;
		}



		//word这个字符串在前缀树中出现过几次
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (char ch : chs) {
                index = ch - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

		//前缀出现的次数
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (char ch : chs) {
                index = ch - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
		System.out.println("************************");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.prefixNumber("zuo"));

    }

}
