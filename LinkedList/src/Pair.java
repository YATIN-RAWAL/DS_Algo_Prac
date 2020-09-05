
public class Pair<T> {

	Node<T> headReverse;
	Node<T> tailReverse;
	
	public Node<T> getHeadReverse() {
		return headReverse;
	}
	public void setHeadReverse(Node<T> headReverse) {
		this.headReverse = headReverse;
	}
	public Node<T> getTailReverse() {
		return tailReverse;
	}
	public void setTailReverse(Node<T> tailReverse) {
		this.tailReverse = tailReverse;
	}
	public Pair(Node<T> headReverse, Node<T> tailReverse) {
		super();
		this.headReverse = headReverse;
		this.tailReverse = tailReverse;
	}
	public Pair() {
		super();
	}
	
	
}
