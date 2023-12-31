// Kcompiler.cpp : Defines the entry point for the application.
//

#include "Kcompiler.h"

using namespace std;

void readSource(const char* path, int* length, char** buffer) {
	ifstream file;
	file.open(path);
	file.seekg(0, std::ios::end);
	*length = file.tellg();
	*buffer = new char[*length + 1];
	file.read(*buffer, *length);
	(*buffer)[*length + 1] = '\0';
	file.close();
}

int numberOfChars(char* arr, char searchfor) {
	int num = 0;
	while (*(arr++) != '\0') {
		if (searchfor = *arr) num++;
	}
	return num;
}

int main(int argc, char* argv[]) {
	/*
	if (argc < 2) {
		printf("must supply file to compile!");
		return -1;
	}

	char* path = argv[1];
	*/

	const char* path = "D:\\Coding\\GitHub\\Kstarlang\\Kcompiler\\test.txt";

	printf(path);
	printf("\n");
	int length;
	char* buffer;
	readSource(path, &length, &buffer);
	
	printf(buffer);




	return 0;
}


