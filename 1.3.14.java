public class ResizingArrayQueueOfStrings<Item>{
	private Item[] strQueue = (Item[]) new Object[1];
	private int N = 0;
	
	public void enqueue(Item item) {
		if (N == strQueue.length) {
			resize(2 * N);
		}
		strQueue[N++] = item;
	}
	
	public Item dequeue() {
		Item tempItem = strQueue[0];
		
		for (int i = 0; i < N - 1; i++) {
			strQueue[i] = strQueue[i + 1];
		}
		strQueue[N - 1] = null;
		
		N--;
		if (N <= strQueue.length / 4) {
			resize(strQueue.length / 2);
		}

		return tempItem;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return strQueue.length;
	}

	public void showDetail() {
		System.out.print("size=" + size() + " values= ");
		
		for (int i = 0; i < N; i++) {
			System.out.print(strQueue[i] + " ");
		}
		
		System.out.println();
	}
	
	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = strQueue[i];
		}
		strQueue = temp;
	}
}
