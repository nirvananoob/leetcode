package hashmap;

public class hashmapdemo {
	public class ResultType {
		int hash;
		String key;
		Integer value;
		ResultType next;

		ResultType(int hash, String k, Integer v, ResultType a) {
			this.hash = hash;
			this.key = k;
			this.value = v;
			this.next = a;
		}
	}

	private ResultType[] table;
	private int size;
	private static final int defaultcom = 2;
	private static final double defaultloadfactor = 0.75;
	private double loadfactor;

	private int threshold;

	public hashmapdemo() {
		this.table = new ResultType[(int) (defaultcom * defaultloadfactor)];
		this.loadfactor = defaultloadfactor;
		// this.compacity = defaultcom;
		this.size = 0;
		this.threshold = (int) (loadfactor * defaultcom);
	}

	private int hash(String key) {
		int sum = 0;
		for (int i = 0; i < key.length(); i++) {
			sum += sum * 33 + (int) key.charAt(i);
		}
		return sum;

	}

	private int indexfor(int hash, int length) {
		return hash & (length -1);
	}

	public void put(String key, int value) {
		if (key == null) {
			throw new IllegalArgumentException("invalid key");
		}
		int hash = hash(key);
		int index = indexfor(hash, table.length);
		for (ResultType e = table[index]; e != null;) {
			if (e.hash == hash && e.key.equals(key)) {
				e.value = value;
				return;
			}
			e = e.next;
		}
		addEntry(hash, key, value, index);
		return;
	}

	public int get(String key) {
		int hash = hash(key);
		int index = indexfor(hash, table.length);
		for (ResultType e = table[index]; e != null;) {
			if (e.hash == hash && e.key.equals(key)) {
				return e.value;
			}
			e = e.next;
		}
		return -1;

	}

	// public putforNullKey {}
	// public putforNullKey
	public void addEntry(int hash, String k, int value, int index) {
		ResultType e = table[index];
		ResultType entry = new ResultType(hash, k, value, e);
		table[index] = entry;
		size++;
		if (size >= threshold) {
			rehashing();
		}
		return;
	}

	public void rehashing() {
		ResultType[] old = table;
		ResultType[] newarr = new ResultType[old.length * 2];
		for (int i = 0; i < old.length; i++) {
			if (old[i] != null) {
				ResultType e = old[i];
				while (e != null) {
					int index = indexfor(e.hash, old.length * 2);
					ResultType next = e.next;
					e.next = newarr[index];
					newarr[index] = e;
					e = next;
				}
			}
		}
		table = newarr;

		threshold = (int) (table.length * loadfactor);

	}

	public int threshold() {
		return this.threshold;
	}

	public static void main(String[] args) {
		hashmapdemo minihash = new hashmapdemo();
		minihash.put("a", 1);
		minihash.put("b", 2);
		System.out.println(minihash.get("a"));
		System.out.println(minihash.get("b"));
		System.out.println(minihash.threshold);
		minihash.put("a", 3);
		System.out.println(minihash.get("a"));
		minihash.put("c", 4);
		System.out.println(minihash.threshold);
	}
}
