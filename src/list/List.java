package list;
/**
 * Implementation of a data structure called list.
 * @return
 */
public class List<T> {
	private Node head;
	private int nElements;

	public List() {
		this.head = null;
		this.nElements = 0;
	}

	private Node getLinkPosition(int position) throws Exception {
		int n = 1;
		Node p = head;
		if (head == null)
			throw new Exception("Empty list!");
		if ((position > this.nElements) || (position < 1))
			throw new Exception("Wrong position");
		while ((p.getLink() != null) && (n < position)) {
			p = p.getLink();
			n++;
		}
		return p;
	}

	private Node createNode(T info, Node link) {
		Node newNode = new Node(info);
		newNode.setLink(link);
		return newNode;
	}

	public int getElements() {
		return this.nElements;
	}

	public void insertInHead(T info) {
		Node p = createNode(info, head);
		this.head = p;
		this.nElements++;
		return;
	}

	public void insertInTail(T info) {
		if (head == null)
			insertInHead(info);
		else {
			try {
				Node p = getLinkPosition(this.nElements);
				p.setLink(createNode(info, null));
				this.nElements++;
			} catch (Exception exception) {
			}
			return;
		}
	}

	public void insertInPosition(T info, int posizione) throws Exception {
		if (posizione <= 1)
			insertInHead(info);
		else {
			if (this.nElements < posizione)
				insertInTail(info);
			else {
				Node p = getLinkPosition(posizione - 1);
				p.setLink(createNode(info, p.getLink()));
				this.nElements++;
			}
		}
		return;
	}

	public void removeFromHead() throws Exception {
		if (head == null)
			throw new Exception("Empty list");
		head = head.getLink();
		this.nElements--;
		return;
	}

	public void removeFromTail() throws Exception {
		if (head == null)
			throw new Exception("Empty List");
		Node p = getLinkPosition(this.nElements - 1);
		p.setLink(null);
		this.nElements--;
		return;
	}

	public void removeFrom(int position) throws Exception {
		if (position == 1)
			removeFromHead();
		else if (position == this.nElements)
			removeFromTail();
		else {
			Node ps = getLinkPosition(position);
			Node pp = getLinkPosition(position - 1);
			pp.setLink(ps.getLink());
			this.nElements--;
		}
		return;
	}

	private String visit(Node p) {
		if (p == null)
			return "";
		return p.getInfo().toString() + "\n" + visit(p.getLink());
	}

	public String list() {
		return visit(head);
	}

	public String toString() {
		Node p = head;
		String List = new String("head->");
		if (p == null)
			return List + "null";
		while (p != null) {
			List = List + "[" + p.getInfo().toString() + "|";
			if (p.getLink() == null)
				List = List + "null]";
			else
				List = List + "+]->";
			p = p.getLink();
		}
		return List;
	}

	public static void main(String[] args) {
		class Guest {
			private String name;
			private char sex;
			private String phone;

			public Guest(String name, char sex, String phone) {
				this.name = name;
				this.sex = sex;
				this.phone = phone;
			}

			public Guest(Guest guest) {
				this.name = guest.getName();
				this.sex = guest.getSex();
				this.phone = guest.getPhone();
			}

			public void setName(String nome) {
				this.name = nome;
			}

			public String getName() {
				return name;
			}

			public void setSex(char sex) {
				this.sex = sex;
			}

			public char getSex() {
				return sex;
			}

			public void setPhone(String phone) {
				this.phone = phone;
			}

			public String getPhone() {
				return phone;
			}

			public String toString() {
				return name + " " + sex + " " + phone;
			}
		}	
		Guest i1 = new Guest("Bianchi Giovanni", 'M', "0586 854822");
		Guest i2 = new Guest("Rossi Marta", 'F', "0586 844853");
		Guest i3 = new Guest("Neri Marco", 'M', "0586 444722");
		Guest i4 = new Guest("Verdi Roberta", 'F', "0586 974824");
		List<Guest> f = new List<Guest>();
		f.insertInHead(i1);
		f.insertInHead(i2);
		f.insertInTail(i3);
		try {
			f.insertInPosition(i4, 2);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		System.out.println("Recursive visit: ");
		System.out.println(f.list());
		System.out.println("------------------");
		System.out.println(f.toString());
		System.out.println("------------------");
		try {
			f.removeFrom(2);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		System.out.println(f.toString());
		System.out.println("------------------");
		try {
			f.removeFromTail();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		System.out.println(f.toString());
		System.out.println("------------------");
		try {
			f.removeFromHead();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		System.out.println(f.toString());
		System.out.println("------------------");
		try {
			f.removeFrom(5);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		System.out.println(f.toString());
		System.out.println("------------------");
		try {
			f.removeFrom(1);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		System.out.println(f.toString());
		System.out.println("------------------");
		try {
			f.removeFrom(1);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	class Node {
		private T info;
		private Node link;

		public Node(T info) {
			setInfo(info);
			link = null;
		}

		public void setInfo(T info) {
			this.info = info;
		}

		public T getInfo() {
			return info;
		}

		protected void setLink(Node link) {
			this.link = link;
		}

		public Node getLink() {
			return link;
		}
	}
}