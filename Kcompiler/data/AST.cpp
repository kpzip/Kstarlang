class AbstractSyntaxTree;
enum ElementType;
enum Element;

#include <cstdlib>
#include <vector>

struct Node {
	ElementType t;
	//Element t;
	std::vector<Node> children;
};

enum ElementType {
	StatementSequence,
	Statement,
	Operator,
	Variable,
	Declaration,
};

class AbstractSyntaxTree {
private:
	Node* first;

public:
	
	AbstractSyntaxTree() {
		/*
		first = (Node*)malloc(sizeof(Node));
		first->t = StatementSequence;
		first->tPtr = (void*)0;
		first->children = std::vector(10, 0);
		*/
	}

	~AbstractSyntaxTree() {
		delete first;
	}
};

