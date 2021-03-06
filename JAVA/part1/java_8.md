## 20190509

===8장 자바 GUI 기초===

1. 그래픽 사용자 인터페이스

- 콘솔-기반 : 텍스트만을 사용하여 사용자와 대화하는 것으로 현재는 많이 사용X
- GUI(Graphical User Interface) : 그래픽과 마우스를 사용
    - AWT
        - 플랫폼에 의존적
        - 컴포넌트 용량이 큼
        - 룩앤필 지원X
        - 컴포넌트 개수가 적음
    - Swing
        - 플랫폼에 독립적
        - 컴포넌트 용량이 작음
        - 룩앤필 지원
        - 컴포넌트 개수가 많음


2. 컴포넌트와 컨테이너

- 컴포넌트 : 버튼이나 체크박스 같은 기본적인 빌딩블록
    - 컴포넌트 : 단순한 컴포넌트 (JButton, JLabel 등)
    - 컨테이너 : 다른 컴포넌트를 포함하는 컴포넌트를
        - 최상위 컨테이너 : 절대 다른 컨테이너 안에 포함될 수 없는 컨테이너 (JFrame, JDialog, JApplet, JPanel 등)
        - 일반 컨테이너 : 다른 컨테이너 안에 포함될 수 있는 컨테이너 (JPanel, JScroll, Pane 등)


3. GUI 작성 절차

- JFrame : 윈도우와 메뉴를 가지는 일반적인 테스크탑 애플리케이션
- JDialog : 메뉴가 없는 대화상자 형식의 간단한 애플리케이션
- JApplet : 애플릿 작성하는데 사용

1) 컨테이너 생성
2) 컴포넌트 추가

add() 메소드 사용

JFrame 클래스
- add()
- setTitle()
- setLocation(), setSize()
- setIconImage() : 윈도우 시스템에 타이틀 바, 태스크 스위처에 표시할 아이콘을 알려준다.
- setResizeable() : 사용자가 크기를 조절 가능 여부를 설정


4. 배치관리자

- 배치관리자 : 컴포넌트의 위치와 크기를 자동으로 결정
    - BoderLayout : 컴포넌트들이 North(북), South(남), East(동), West(서), Center(중앙) 중 하나로 추가
        - 프레임, 애플릿, 대화상자 같은 최상위 컨테이너의 디폴트 배치관리자
    - FlowLayout : 컴포넌트들을 왼쪽에서 오른쪽으로 배치
        - 패널의 디폴트 배치관리자
    - GridLayout : 컴포넌트들을 격자모습으로 배치
        - 컴포넌트의 크기가 윈도우의 크기에 따라 맞춰진다.
    - 절대위치로 배치
        - setLayout(null)
        - 플랫폼에 따라서 프로그램의 모습이 달라진다. 즉, 윈도우 크기가 달라져도 컴포넌트는 항상 절대위치에 있다.


5. 패널 사용하기

- 패널 : 컴포넌트들을 포함하고 있도록 설계된 컨테이너 중의 하나이다. 게시판 같은 느낌
    - 패널의 디폴트 배치관리자는 FlowLayout 이다.


6. 기초 컴포넌트들

- JLabel : 레이블, 텍스트를 표시할 수 있는 공간
- JTextField : 텍스트필드, 텍스트를 입력할 수 있는 공간
- JButton : 버튼, 클릭하면 어떤 동작을 실행하는 버튼

- 레이블
    - JLabel label = new JLabel("안녕하세요?");
- 텍스트필드
    - JTextField = new JTextField(20); // 20은 텍스트 필드의 칸 수
    - 엔터키를 누르면 액션 이벤트 발생
    - JTextField :
    - JFormattedTextField : 
    - JPasswordField : 
    - JComboBox : 
    - JSpinner : 
- 버튼
    - JButton : 
    - JCheckBox : 
    - JRadioButton : 
    - JMenuItem : 
    - JCheckBoxMenuItem : 
    - JRadioButtonMenuItem : 
    - JToggleButton : 


===9장 이벤트 처리===

1. 이벤트 처리 개요

- 이벤트-구동 프로그래밍 : 이벤트가 발생하면 적절한 처리를 해주는 프로그래밍 방식

.addActionListener(e -> { System.out.print(""); });
.addActionListener(e -> { field.setText(""); });
.addActionListener(e -> { field.getText(); });