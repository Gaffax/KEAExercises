package exercises;

import exercises.NodeAlt;

public class OneAlt {
	NodeAlt root;

		public NodeAlt findNode(int key) {
			NodeAlt focusNode = root;

			while (focusNode.key != key) {

				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
				} else {
					focusNode = focusNode.rightChild;
				}
				if (focusNode == null)
					return null;
			}
			return focusNode;
		}

		public int returnSum(NodeAlt focusNode){
			if(focusNode == null){
				return 0;
			} else {
				return focusNode.key + returnSum(focusNode.leftChild) + returnSum(focusNode.rightChild);	
			}
		}
		
		public void addNode(int key) {
			NodeAlt newNode = new NodeAlt(key);

			if (root == null) {
				root = newNode;
			} else {
				NodeAlt focusNode = root;

				NodeAlt parent;

				while (true) {
					parent = focusNode;

					if (key < focusNode.key) {
						focusNode = focusNode.leftChild;

						if (focusNode == null) {

							parent.leftChild = newNode;
							return;
						}
					} else {
						focusNode = focusNode.rightChild;

						if (focusNode == null) {
							parent.rightChild = newNode;
							return;
						}
					}
				}
			}
		}
		
		public void inOrderTraverseTree(NodeAlt focusNode) {
			if (focusNode != null) {
				inOrderTraverseTree(focusNode.leftChild);
				System.out.println(focusNode);
				inOrderTraverseTree(focusNode.rightChild);
			}

		}

		public void preorderTraversalTree(NodeAlt focusNode) {
			if (focusNode != null) {
				System.out.println(focusNode);
				preorderTraversalTree(focusNode.leftChild);
				preorderTraversalTree(focusNode.rightChild);
			}
		}

		public void postOrderTraversalTree(NodeAlt focusNode) {
			if (focusNode != null) {

				postOrderTraversalTree(focusNode.leftChild);
				postOrderTraversalTree(focusNode.rightChild);
				System.out.println(focusNode);
			}
		}
}
