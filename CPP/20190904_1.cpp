#include <iostream>
using namespace std;

int main() {
	cout << "Hello World!" << endl;

	/*
	a.
	#include <iostream>
	: C++ 표준 라이브러리의 선언을 포함하는 헤더파일 iostream을 추가한다.

	b.
	using namespace std;
	: C++ 표준 라이브러리에 포함된 요소들의 이름공간 std를 사용한다.

	c.
	cout << "Hello World!" << endl;
	: "Hello World!" 문장이 스트림 출력 연산자를 통해 출력 스트림 객체 cout에 출력되고, 이 데이터가 cout에 연결된 모니터에 디스플레이 된다.

	d.
	: cout, endl를 인식하지 못한다.
	: cout과 endl가 std라는 이름공간에 명시되어 있는데, std라는 이름공간을 명시해주어야 한다.

	e.
	: std::cout << "Hello World!" << std::endl;
	*/


	//cout << "너비를 입력하세요>>";

	int width;
	//cin >> width;
	// 키보드 입력을 통해 데이터가 입력 스트림 객체 cin에 입력되고, 스트림 추출 연산자를 통해 cin에 입력된 데이터가 width 변수에 할당된다.
	// cin = 입력 스트림 객체
	// >> = 스트림 추출 연산자

	cout << "너비와 높이를 입력하세요>>";

	int height;
	cin >> width >> height;

	int area = width * height;
	cout << "면적은 " << area << "\n";
	
	return 0;
}