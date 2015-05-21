package exercises;

public class NodeAlt {
		int key;

		NodeAlt leftChild;
		NodeAlt rightChild;

		NodeAlt(int key) {
			this.key = key;
		}


		public String toString() {
			return "Node " + key + " ";
		}
	}

