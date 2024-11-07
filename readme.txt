Data structure :
	linear : Arrays, Linked-Lists, Stacks, Queues, HashMaps
	Non Linear : Tree,Heaps,Tries, Graph
	
Time & space Complexity :
	Measurment notations 
		1.Big O notation (O-notation) worst case complexity  --> most used 
		2.Ω-notation (Omega notation) best case complexity
		3.Θ-notation (Theta notation) average case complexity
		
	Space & Time Complexities
	 O(1) - Constant complexity: The operation takes the same amount of time regardless of input size (e.g., accessing an array element).
	 O(log n) - Logarithmic complexity: As input size increases, the time grows slowly, reducing as the input gets larger (e.g., Binary Search).
	 O(n) - Linear complexity: Time grows in direct proportion to the input size (e.g., Linear Search).
	 O(n log n) - Log-linear complexity: Time grows faster than linear but slower than quadratic, common in efficient sorting (e.g., Merge Sort, Quick Sort).
	 O(n^2) - Quadratic complexity: Time increases by n squared, meaning for every input, you might perform n * n operations (e.g., Bubble Sort).
	 O(n^3) - Cubic complexity: Time increases by n cubed, growing even faster as input increases, used in some complex algorithms (rare, least efficient).

Heap Memory: 
	-> A dynamically allocated memory area in Java where objects are stored and managed by the Garbage Collector.

Stack Memory: 
	- >A memory area that stores method calls and local variables, operating in a Last-In-First-Out (LIFO) manner for each thread.
		

Bitwise operartors :
	->And(&), OR(|) Operator :
			last bit 1 -> odd number
			last bit 0 -> even number				
	eg :if number & 1 == 0 it is a even number	
	
	->NOT(~) operartor -  inverts all the bits of a number
	2's complement in NOT(~) operartor  -> not the binary number and add 1 
	left most bit is a sign of a number, 0 = positive and 1 = negative)
												
	->XOR(^) Same bits → 0, Different bits → 1
			In short: XOR outputs 1 only if the bits are different.
	
	->Left Shift Operator (<<):
	Shifts all bits to the left by the specified number of positions, filling the vacant rightmost positions with zeros.
	
	->Right Shift Operator (>>):
	Shifts all bits to the right by the specified number of positions, discarding the rightmost bits
	
	Decimal to Binary -> dividing a number by 2 until it became 0 and store the reminders ,and resverse(reminders) is the answer (typical)
						 bitwise AND with one, prepend result, Shift right
	
	binary to decimal ->  Assign powers of two, sum powers for ones.
	
Basic trics :
	num % 10 = last digit (eg: 567 % 10 = 7)
	num / 10 = last digit will remove (eg: 567 / 10 = 56)
	num * 10 + value = value will append to num (eg: 56 * 10 + 7 = 567)
	num & 1 = last bit of binary equivalent (eg: 7 & 1 = 1)

 Recursion:
	- Recursion is a programming technique where a function calls itself to solve smaller sub-problems until it reaches a base case, which stops further calls.
	- The function typically follows a pattern of dividing the problem into simpler instances, like calculating factorials or Fibonacci numbers.
	- It leverages the call stack to manage each call's state, making it useful for tasks like tree and graph traversals.
	- However, recursion can lead to high memory usage and potential stack overflow.
	- Optimizations like memoization can enhance efficiency.
	- Common use cases include sorting algorithms (QuickSort, MergeSort) and decision-making problems (e.g., backtracking for puzzles).

------------------------------------------------------------------------------------------------------------------------------------------
Linear Data Structures:

	Arrays:
	-> collection of similar data types (eg: int[] arr = {1, 2, 3})
	-> 0 based indexing = base address + (index * size of element) (eg: arr[2] = 3)
	-> Arrays Basically follows static memory allocation (eg: int[10] arr;)
	-> ArrayList<>() can be used to use dyanamic memory allocation, 
		it basically creates new arrays for us of more size and copying elements ... 
	-> dutch flag/ colours problem - use low mid high pointers
	-> bitwise XOR can cancel same elements of an array
	-> HashSet Can be use to avoid duplicate elements

	--------------------------------------------------------------------------------------------------------------------------------------
	Linked-Lists:
	- A linked list is a dynamic data structure where elements (nodes) are stored in separate memory locations, 
	each containing data and a pointer to the next node.
	- Each node is stored separately in memory,
	allows the size to grow or shrink as needed, unlike arrays where the size is fixed.
	- We can use slow and fast pointers to find middle node and also check hasCycle ? 
	
	Types :
	1. Singly Linked List: Each node points to the next node.
	2. Doubly Linked List: Each node points to both the next and previous nodes.
	3. Circular Linked List: The last node points back to the first node.
	4. Circular Doubly Linked List: Each node points to both the next and previous nodes, and the last node points back to the first node.
	5. Skip List: A layered linked list with nodes that skip over intermediate nodes for faster search.

	--------------------------------------------------------------------------------------------------------------------------------------
	Stacks :
	- A stack in Java is a data structure that follows the Last-In-First-Out (LIFO) principle. 
	This means that the last element added (pushed) to the stack is the first one to be removed (popped).
	- Usecase : Recursion uses stack at background, undo/redo operations,
	- Methods used with stacks:
		push(E item): Adds an item to the top of the stack.
		pop(): Removes and returns the item at the top of the stack.
		peek(): Returns the item at the top without removing it.
		isEmpty(): Checks if the stack is empty.
		size(): Returns the number of items in the stack.
	--------------------------------------------------------------------------------------------------------------------------------------
	Queues:
	- A queue in Java is a data structure that follows the First-In-First-Out (FIFO) principle.
	This means that the first element added (enqueued) to the queue is the first one to be removed (dequeued).
	- Usecase : scheduling tasks, printing jobs	
	
	- Methods used with queues:
	enqueue(E item): Adds an item to the rear of the queue.
	dequeue(): Removes and returns the item at the front of the queue.
	peek(): Returns the item at the front without removing it.
	isEmpty(): Checks if the queue is empty.
	size(): Returns the number of items in the queue.
	
	- Types of queues:
	1. Simple Queue: Basic FIFO queue as described above.
	2. Circular Queue: Last position is connected to the first position to form a circle.
	3. Priority Queue: Elements are dequeued based on their priority, not just their order.
	4. Double-Ended Queue (Deque): Allows insertion and deletion at both ends.
	
	- Java implementations:
	1. Queue interface: Part of the Java Collections Framework.
	2. LinkedList class: Implements Queue interface.
	3. PriorityQueue class: Implements the Priority Queue.
	4. ArrayDeque class: Implements the Deque interface.
	--------------------------------------------------------------------------------------------------------------------------------------
	HashMaps:(most faster)
	- Stores key-value pairs and allows constant-time complexity (on average) for basic operations like insertion, lookup, and deletion.
	- It follows the Hashing technique to map keys to values, and it does not maintain any order of the keys or values. 
	- It allows one null key and multiple null values.
	- not thread-safe,you can use Collections.synchronizedMap() or ConcurrentHashMap.
	- Use cases: Caching, database indexing, dictionary implementations, fast lookups.
	- to avoid collation we can use collation avoiding techniques:
		Chaining: Uses linked lists to store collided elements in the same bucket.
		Open Addressing - Linear Probing: Finds the next available slot sequentially.
		Open Addressing - Quadratic Probing: Finds the next available slot using quadratic steps.
		Double Hashing: Uses a secondary hash function to determine probe sequence.
	
	-Hash function :
	converts the key into an integer value, which is then used to determine the index in the internal array (hash table).
	
	- Types of HashMaps:
		HashMap: General-purpose map with no order.
		LinkedHashMap: Maintains insertion order, useful for predictable iteration.
		WeakHashMap: Keys are weak references, meaning that they can be garbage collected when no longer in use.
		ConcurrentHashMap: Thread-safe HashMap for concurrent access.
------------------------------------------------------------------------------------------------------------------------------------------
Non Linear Data Structures:

Trees:
	Binary Trees:
	- A tree structure where each node has at most two children, referred to as the left and right child.
	
	- Types of Binary Trees:
		Full Binary Tree: Every node has 0 or 2 children.
		Complete Binary Tree: All levels are fully filled except possibly the last, which is filled from left to right.
		Perfect Binary Tree: All internal nodes have two children, and all leaf nodes are at the same level.
		Balanced Binary Tree: The height difference between the left and right subtrees of any node is at most 1.
		Degenerate (or Skewed) Tree: Every node has only one child, either left or right, making it behave like a linked list.
	
	- Traversal algorithms :
		1.Breadth-First Search (BFS) | Level by Level : 
		  Queue-Based Approach: BFS uses a queue to keep track of nodes that need to be explored next.
		   
		2.Depth-First Search (DFS) :
		  Explores Deep First, use recursion to keep track of nodes
		  
	- The diameter of a tree : is the longest path between any two nodes in the tree. 
	It measures the maximum number of edges/nodes you need to travel to go from one node to another.(can excluse root)
	
	- Java implementations:
	TreeSet class: Implements a self-balancing BST in Java's Collections Framework.
	TreeMap class: Implements a Red-Black tree-based structure for mapping key-value pair ((value will be returned sorted way))
	--------------------------------------------------------------------------------------------------------------------------------------
	Binary Search Trees (BST):
	- A Binary Search Tree is a node-based data structure where each node follows the rule that the 
	left subtree contains only values smaller than the node, 
	and the right subtree contains only values larger than the node.
		
	- Usecase: Searching, sorting, dynamic sets, priority queues.

	- Methods used with Binary Search Trees:
		insert(int value): Adds a new node with the given value into its correct position in the tree.
		search(int value): Searches for a node with the given value and returns it.
		delete(int value): Removes a node with the given value from the tree.
		inorder(): Traverses the tree in ascending order (left, root, right).
		preorder(): Traverses the tree starting with the root (root, left, right).
		postorder(): Traverses the tree with leaves first (left, right, root).

	--------------------------------------------------------------------------------------------------------------------------------------
	AVL Tree:
	- A self-balancing binary search tree where the height difference (balance factor) between left and right subtrees is at most 1 for any node.
	- Rotations to fix imbalance:
		LL (left-left): Right rotation when left subtree is too tall.
		RR (right-right): Left rotation when right subtree is too tall.
		LR (left-right): Left, then right rotation for left-right imbalance.
		RL (right-left): Right, then left rotation for right-left imbalance.
		
	- Use case: Preferred when frequent lookups or searches require strictly balanced trees (O(log n) operations).
	- Java Example: Custom implementation, ideal for applications needing fast lookups.
	
	--------------------------------------------------------------------------------------------------------------------------------------
	Red-Black Tree:
	- A self-balancing binary search tree with nodes colored red or black to maintain balance.
	- Properties: Root is always black, no two consecutive red nodes, and all paths must have the same number of black nodes.
	- Rotations and Recoloring to maintain balance:
		Left or Right rotation occurs when consecutive red nodes violate the Red-Black property, 
		with recoloring to fix balance.
		Often used with color flips (recoloring red and black nodes).
	Use case: Used in Java's TreeMap and TreeSet for efficient insertion, deletion, and lookups with O(log n) complexity.
	
------------------------------------------------------------------------------------------------------------------------------------------
Heap:
	- A Heap is a special tree-based data structure(Complete Binary Tree) that satisfies the heap property: 
	- In a Max-Heap, the parent node is always greater than or equal to its children.
	- In a Min-Heap, the parent node is always less than or equal to its children.
	- Heaps are commonly used to implement priority queues, where the highest or lowest priority element is accessed first.
	- Operations: Insert, Delete, Peek (access max/min element) all take O(log n) time.
	- Heapify is the process of arranging elements in an array to satisfy the heap property, turning an unsorted array into a valid heap
	- Use case: Efficient for priority-based tasks, scheduling, and algorithms like Heap Sort and Dijkstra's algorithm.
	- Java Example: PriorityQueue class implements a min-heap by default.
	
------------------------------------------------------------------------------------------------------------------------------------------
Trie (prefix tree):
	- A Trie (pronounced "try") is a tree-like data structure where each node represents a character, commonly used for storing words.(Narry)
	- Allows fast prefix searches, where common prefixes are shared among branches to save space and time.
	- Insert, search, and delete operations typically take O(k) time, where k is the length of the word.
	- Use case: Ideal for autocomplete systems, spell checkers, and dictionaries, as it provides efficient word lookups.
	- Java Example: No direct implementation, but can be built for text processing and search applications.
	
													eg:    root
														  /    \
														 c      d
														/        \
													   a          o
													  / \          \
													 t*  r*         g*

------------------------------------------------------------------------------------------------------------------------------------------
Graph :
	- A graph is like a social network of points (nodes/vertices) connected by lines (edges)!
		A ●───● B
		  │   │
		  │   │
		C ●───● D
		
	- Basic Components :
		Node (Vertex): The dots (●) in the graph
		Edge: The lines connecting nodes
		Degree: Number of edges connected to a node

		In-degree: Incoming edges (for directed graphs)
		Out-degree: Outgoing edges (for directed graphs)
	--------------------------------------------------------------------------------------------------------------------------------------
	- Types of Graphs :
		a) Directed vs Undirected
		Undirected: A ●───● B    Directed: A ●──→● B

		Undirected: Facebook friendships
		Directed: Instagram followers
		----------------------------------------------------
		
		b) Cyclic vs Acyclic
		Cyclic:    		Acyclic:
		A →→ B          A →→ B
		↑   ↓          ↑   ↓
		D ←← C          D    C

		Cyclic: Has at least one cycle
		Acyclic: No cycles (like a tree!)
		- To detect cycles in an undirected graph, we can use Depth-First Search (DFS).
		- To detect cycles in a directed graph, we can use Depth-First Search (DFS) by maintaining two sets: 
		  a visited set to track all visited nodes and a recursion stack to track the nodes in the current path.
		----------------------------------------------------

		c) Weighted vs Unweighted
		Unweighted:     Weighted:
		A ●───● B       A ●──5──● B
						   3
						   ↓
						   C
				
		Weighted Graph: Road maps with distances, network routing with bandwidth, flight paths with costs.
		Unweighted Graph: Social networks, communication networks, simple relationship modeling
	--------------------------------------------------------------------------------------------------------------------------------------
	- Graph Representations :
		a) Adjacency Matrix
		  A B C
		A 0 1 0
		B 1 0 1
		C 0 1 0

		Space: O(V²)
		Good for: Dense graphs
		Used when: Quick edge lookup needed
	----------------------------------------------------

		b) Adjacency List (⭐ Most Used)
		A → [B, C]
		B → [A]
		C → [A, B]

		Space: O(V + E)
		Good for: Sparse(!Dense) graphs
		Used in most real applications!
	--------------------------------------------------------------------------------------------------------------------------------------
	- BFS Traversal:
		Start from a node (source vertex).	
		Visit all its adjacent (neighboring) vertices.
		For each adjacent vertex, visit all their adjacent vertices.
		Continue this process until all vertices are visited.\
		
		- Queue is used in BFS to keep track of nodes at each level. 
		  When you visit a node, you enqueue its neighbors, and then dequeue them one by one to visit their neighbors.
		  
		- BFS is ideal for finding the shortest path in an unweighted graph, as it explores all vertices at one "level" before moving on to the next.
	----------------------------------------------------
	
	- DFS Traversal:
		Start at a vertex (source vertex).
		Visit the first unvisited neighbor of the current vertex.
		From that neighbor, visit its first unvisited neighbor.
		Continue this process until there are no more unvisited neighbors, then backtrack to the previous vertex.
		Repeat until all vertices are visited.
		
		- DFS uses a stack (either an explicit stack or the call stack in recursion) to backtrack once it hits a dead end.
			
		- DFS is useful for tasks like cycle detection, topological sorting, and exploring all possible paths in a graph.
	--------------------------------------------------------------------------------------------------------------------------------------
	-  Topological Sort:
		Topological Sort is a way to arrange nodes (vertices) of a Directed Acyclic Graph (DAG) 
		such that for every edge going from one node to another, the first node comes before the second in the order.( u → v, vertex u comes before v)

		There are two main ways to do this:
		1) Kahn's Algorithm:
		Find nodes with no incoming edges (in-degree 0).
		Remove those nodes and decrease the in-degree of their neighbors.
		Repeat until all nodes are processed or a cycle is detected.
		
		2) DFS-based Method:
		Perform Depth-First Search (DFS) on each unvisited node.
		When a node finishes (all its neighbors are visited), add it to the result stack.
		Reverse the stack for the final order.
		
		eg:
		Initial :    Final Order:
		A → B         A, C, B
			↓  
			C
		
		A common use case is task scheduling, where some tasks must be completed before others
		(e.g., resolving dependencies in project management).
	--------------------------------------------------------------------------------------------------------------------------------------
	- Shortest Path Algorithm:
	Shortest Path Problem: The goal is to find the minimum distance or cost to travel from one vertex (node) to another in a graph.
	This is especially useful in weighted graphs where edges have different costs (weights).
	
	
	- Dijkstra's Algorithm: It is used to find the shortest path from a source node to all other nodes in a weighted graph.
	- Algorithm Steps :
		Initialize Distances: Start with a source vertex, setting its distance to 0 and all other vertices to infinity; mark the source as visited.
		Select Minimum Distance Vertex: From the unvisited vertices, choose the one with the smallest known distance.
		Update Distances: For the selected vertex, update the distances of its adjacent unvisited vertices based on the current vertex's distance plus the edge weights.
		Repeat: Mark the current vertex as visited and repeat the process until all vertices have been visited, ensuring the shortest path to each is found.

	- Usecase; GPS Navigation ,Network Routing
	--------------------------------------------------------------------------------------------------------------------------------------
	- Spanning Tree: A spanning tree of a graph is a subgraph that includes all vertices, has exactly
	V−1 edges (where 𝑉 is the number of vertices), and is connected and acyclic.
	
	- Minimum Spanning Tree (MST): A minimum spanning tree is a spanning tree with exactly
	𝑉−1 edges that has the minimum total edge weight among all possible spanning trees.
	
	- Prim's Algorithm : greedy algorithm that finds a minimum spanning tree for a weighted undirected graph. 
		Start with a Vertex: Choose any vertex to start the MST and mark it as visited.
		Select the Minimum Edge: From the visited vertices, find the edge with the smallest weight that connects to an unvisited vertex.
		Add Edge and Vertex: Add the selected edge and the connected vertex to the MST, marking the new vertex as visited.
		Repeat: Continue selecting the smallest edges and adding unvisited vertices until all vertices are included in the MST.
		
	- Purpose: Used in network design, to minimize the cost of connecting all nodes.
------------------------------------------------------------------------------------------------------------------------------------------
	What is Bubble Sort?
	-> Bubble sort is a simple comparison-based algorithm that works by repeatedly swapping adjacent elements if they are in the wrong order until 
	the list is sorted. It is called bubble sort because the algorithm pushes the largest elements to the end of the list, 
	similar to how bubbles rise to the top of a liquid.
	
	What is Selection Sort?
	-> Selection sort is a simple comparison-based algorithm that works by dividing the input list into two parts: 
	the sorted part at the left end and the unsorted part at the right end. 
	Initially, the sorted part is empty, and the unsorted part is the entire list. 
	The algorithm then finds the smallest element in the unsorted part and swaps it with the leftmost element in the unsorted part, 
	which becomes part of the sorted list. This process continues until the entire list is sorted.
	
	What is Insertion Sort?
	-> Insertion sort is a simple comparison-based algorithm that works by dividing the input list into two parts: 
	the sorted part at the left end and the unsorted part at the right end. 
	Initially, the sorted part is empty, and the unsorted part is the entire list. 
	The algorithm then takes each element from the unsorted part of the list and inserts it into its correct position in the sorted part of the list,
	shifting the larger elements to the right as necessary. This process continues until the entire list is sorted.
	
	Merge Sort
	-> Merge sort is a divide-and-conquer algorithm that is known for its efficiency and stability. 
	It works by dividing the unsorted list into n sub-lists, each containing one element, and then repeatedly merging sub-lists to create new 
	sorted sub-lists until there is only one sub-list remaining. 
	The time complexity of merge sort is O(n log n), which makes it more efficient than bubble sort.
	
	Quick Sort
	-> The basic idea behind Quick Sort is to divide the list into smaller sublists and sort each sublist recursively until the entire list is sorted.
	The algorithm works by selecting a pivot element from the list, partitioning the list into two sublists based on the pivot, 
	and then recursively sorting each sublist.
------------------------------------------------------------------------------------------------------------------------------------------
	

