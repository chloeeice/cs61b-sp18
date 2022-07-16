public class Lec11 {
	public List<String> getWords(String inputFileName) {
		List<String> res = new ArrayList<String>();
		In in = new In(inputFileName);
		while(!in.isEmpty()) {
			String item = in.readString();
			res.add(item);
		}
		return res;
	}

	public int countUniqueWords(List<String> words) {
		Set<String> store = new HashSet<String>();
		for (int i = 0; i < words.size(); i++) {
			store.add(words.get(i));
		}
		return store.size();
	}

	
}

