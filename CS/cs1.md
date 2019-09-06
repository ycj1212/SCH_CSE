# 1. 컴퓨터 시스템으로의 여행

## 컴퓨터 시스템(Computer System)

### 컴퓨터 시스템은 **하드웨어**와 **시스템 소프트웨어**로 구성되고, 이들이 함께 작동하여 **응용 프로그램**을 실행

- 하드웨어 : 프로세서, 명령어 집합, 메모리, 입출력장치
- 시스템 소프트웨어 : 운영체제, 링커, 컴파일러, 로더

소프트웨어와 하드웨어의 경계가 명령어 집합구조(ISA)이다.

`소프트웨어 / 명령어 집합구조 / 하드웨어`

소프트웨어는 유연하고, 하드웨어는 유연하지 않다.

### C프로그램 예에 대해 컴퓨터 시스템의 동작 및 실행 과정
```c
#include <stdio.h>

int main() {
    printf("Hello, world\n");
    return 0;
}
```

- #include <stdio.h>

   : 전처리기(preprocessor) : 미리 처리한다.

- int
   
   : 메모리 크기

- main()

   : 프로그램 시작 주소

- printf

   : 표준함수, 라이브러리 함수

`변수, 함수 => SYMBOL... 즉, 주소`

프로그램이 실행되려면 프로그램에서 입력한 명령어들이 최종 도착지인 메모리에 도착하여야한다.
하지만 프로그램 실행파일(.exe)은 아직 하드디스크(ROM)에 있다.
메인 메모리에 도착하기까지 어떤 과정이 있는지 살펴보자.

`windows운영체제에서 32비트, 64비트는 기본적으로 처리할 수 있는 명령어의 크기이다.`

## 1.1 정보는 비트와 컨텍스트로 이루어진다.

### 소스 프로그램(Source Program)

#### 프로그래머가 작성한 소스 프로그램(또는 소스 파일)은 텍스트 파일로 저장

- 텍스트 문자는 **아스키(ASCII)코드**로 저장
    - 컴퓨터는 0,1 만을 저장하므로 문자는 미리 정의된 2진 비트(코드)로 표현
    - 한글의 경우 유니코드(Unicode)

#### 컴퓨터 시스템 내부의 정보(디스크 파일, 메모리 상의 데이터)는 모두 동일하게 비트로 표시

- 해석하는 내용(context)에 의해 구분
- 정수, 부동소수, 문자열

기계어에 의해 구분X, 명령어에 의해 구분O

### ASCII 코드

### 유니코드

## 1.2 프로그램은 다른 프로그램에 의해 다른 형태로 번역된다.

### 기계어 변환

#### C 소스 프로그램은 컴파일러에 의해 기계어 명령어(machine instruction)으로 변환되어 실행

- 변환된 프로그램은 실행 가능한 목적 프로그램(object program, 또는 목적 파일)으로 디스크 파일에 저장
- 컴파일러는 소스파일을 실행 가능한 목적 파일로 번역

`'0'은 아스키 코드로 되어있고, 0은 그렇지 않다. 그래서 목적프로그램?의 번역이 이상하게 보이는 이유다.`

#### 리눅스의 GCC 컴파일러

- GCC 컴파일 시스템은 네 단계를 수행하여 번역

   : 전처리기, 컴파일러, 어셈블러, 링커

- linux> gcc -o hello hello.c

   : 소스파일 hello.c를 읽어서 실행 파일인 hello 생성

### C, 어셈블리, 이진코드

#### 고급언어

- 높은 생산성을 유지할 수 있는 상위수준의 언어

#### 어셈블리 언어

- 명령어를 기호로 표시

#### 기계어

- 이진자릿수, 비트로 표현
- 명령어를 인코드, 데이터

### 컴파일 시스템

```
hello.c     - Source Program(text)

↓ - 전처리기(Pre-processor(cpp))

hello.i     - Modified source program(text)

↓ - 컴파일러(Compiler(cc1))

hello.s     - Assembly program(text)

↓ - 어셈블러(Assembler(as)

hello.o     - Relocatable object programs(binary)
printf.o    - 표준 라이브러리

↓ - 링커(Linker(ld))

hello       - Excutive object program(binary)
```

#### 전처리 단계

- 전처리기(cpp)는 소스 C 프로그램의 **# 지시어(directive)** 에 따라 처리
- hello.c의 #include<stdio.h> 지시어는 전처리기에게 시스템 헤더 파일 stdio.h의 삽입(include)을 지시 -> 컴파일러에게
- 삽입된 처리 결과는 `hello.i`로 생성

#### 컴파일 단계

- 컴파일러(cc1)는 `hello.i`를 <u>어셈블리어 프로그램으로 변환</u>하여 `hello.s`를 생성
    - 아래에서 각 줄이 한 개의 저수준 어셈블리 명령어를 텍스트 형태로 표시

```
...
main:
    subq    $8, %rsp
    movl    $.LC0, %edi
    call    puts
    movl    $0, %eax
    addq    $8, %rsp
    ret
...
```

- linux> gcc -S -O hello.c
- linux> cat hello.s

- -O 옵션
    - 최적화 레벨 1

- -g 옵션
    - 디버깅 옵션
        - 목적파일에 디버깅 정보 포함

- .XXX : 어셈블러 지시어

#### 어셈블리 단계

- 어셈블러(as)가 어셈블리 명령어를 기계어 명령어(코드)로 변환
- 메모리에 재배치 가능한 프로그램(relocatable program) 형태의 hello.o의 목적 파일 생성
    - main 함수의 기계어 명령어를 인코딩한 바이너리 파일(binary file)
    - 텍스트 편집기로는 읽을 수 없고 리눅스 objdump 명령으로 역 어셈블(disassemble, -d)하여 표시
        - linux> gcc -c -O hello.c
        - linux> objdump -d hello.o

#### 링크 단계

- 링커 프로그램(ld)이 라이브러리 등을 결함하여 메모리에 적재되어 실행되는 실행 가능한 목적파일(실행파일)을 생성
- 표준 C 라이브러리의 printf 함수의 목적파일 printf.o와 hello.o를 통합한 실행 파일 hello 생성
- 이 실행 파일은 메모리에 적재(load)되어 시스템에 의해 실행
