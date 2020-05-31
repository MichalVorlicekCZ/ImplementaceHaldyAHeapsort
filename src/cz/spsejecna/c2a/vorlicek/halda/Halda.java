package cz.spsejecna.c2a.vorlicek.halda;

import java.util.ArrayList;

public class Halda {
	ArrayList<Integer> heapArray = new ArrayList<>();

	public int getParent(int i) {
		int parent = 0;

		if (i % 2 == 1) {
			parent = i / 2;
		} else if (i % 2 == 0) {
			parent = (i - 1) / 2;
		}

		return parent;
	}

	public void insert(int value) {
		heapArray.add(value);
		int i = heapArray.size() - 1;

		while (heapArray.get(getParent(i)) > value) {
			int temp = heapArray.get(getParent(i));
			heapArray.set(getParent(i), value);
			heapArray.set(i, temp);
			i = getParent(i);
		}
	}

	public int min() {
		if (heapArray.get(0) != null) {
			return heapArray.get(0);
		} else {
			return (Integer) null;
		}
	}

	public int getLeftChild(int i) {
		int leftChild = 2 * i + 1;
		return leftChild;
	}

	public int getRightChild(int i) {
		int rightChild = 2 * i + 2;
		return rightChild;
	}

	public int extractMin() {
		int smallestElement = heapArray.get(0);
		heapArray.set(0, heapArray.get(heapArray.size() - 1));
//		heapArray.set(heapArray.size() - 1, null);
		heapArray.remove(heapArray.size() - 1);
		int i = 0;

		if (heapArray.size() <= 1) {

		} else if (heapArray.size() == 2) {
			if (heapArray.get(i) > heapArray.get(getLeftChild(i))) {
				int smallerChild;

				if (heapArray.get(getLeftChild(i)) < heapArray.get(getRightChild(i))) {
					smallerChild = getLeftChild(i);
				} else {
					smallerChild = getRightChild(i);
				}

				int temp = heapArray.get(smallerChild);
				heapArray.set(smallerChild, heapArray.get(i));
				heapArray.set(i, temp);
				i = smallerChild;
			}
			
		} else if (heapArray.size() >= 2) {
			while (heapArray.get(i) > heapArray.get(getLeftChild(i)) || heapArray.get(i) > heapArray.get(getRightChild(i))) {
				int smallerChild;

				if (heapArray.get(getLeftChild(i)) < heapArray.get(getRightChild(i))) {
					smallerChild = getLeftChild(i);
				} else {
					smallerChild = getRightChild(i);
				}

				int temp = heapArray.get(smallerChild);
				heapArray.set(smallerChild, heapArray.get(i));
				heapArray.set(i, temp);
				i = smallerChild;

				if (heapArray.size() - 1 < getLeftChild(i) || heapArray.size() - 1 < getRightChild(i)) {
					break;
				}
			}
		}
		return smallestElement;
	}

	public int size() {
		return heapArray.size();
	}

}
