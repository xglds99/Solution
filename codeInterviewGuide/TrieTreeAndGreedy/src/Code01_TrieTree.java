

class Code01_TrieTree_1 {

	/**
	 * ǰ׺�����Ժܷ����ҵ��� ��xx����ͷ���ַ����м���
	 */
    public static class TrieNode {
        public int path;  //�ڼ�ǰ׺����ʱ��������ﵽ�����ٴΣ�Ҳ�����ж��ٸ��ַ�����������
        public int end;  //�������Ƿ���һ���ַ����Ľ�β��㣬����ǵĻ����Ƕ��ٸ��ַ����Ľ�β���
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



		//word����ַ�����ǰ׺���г��ֹ�����
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

		//ǰ׺���ֵĴ���
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
