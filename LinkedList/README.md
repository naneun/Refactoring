# LinkedList
- ## History
  >  - 2022-01-11: initial writing
  >  - 2022-01-12: [Editor.java] add function, insert function, and delete function refactoring
- ## Directory Structure
  ```bash
  📘 class 📗 interface
  
  ├── 📁src
  │   ├── 📘Data.java
  │   ├── 📘Editor.java
  │   ├── 📗LinkedList.java
  │   ├── 📘Main.java
  │   ├── 📘Node.java
  │   ├── 📘Util.java
  │   └── 📘Video.java
  └── README.md
  ```

- ## Class Diagram
  ![SmartSelectImage_2022-01-11-21-10-05](https://user-images.githubusercontent.com/47964708/148940221-968407dd-def7-4bd7-98ed-5a1e893d5ae6.png)

- ## TODO
  - [x] 기존 함수 재사용 시 공통된 로직을 분리하여 중복 수행 제거하기
  - [ ] 더이상 참조하지 않는 객체 null 로 초기화하는 작업이 불필요한지 학습하기  
    ![SmartSelectImage_2022-01-12-07-16-10](https://user-images.githubusercontent.com/47964708/149030801-21c30f33-a94f-43b6-8518-e104a3162170.png)  
    ![SmartSelectImage_2022-01-12-07-16-31](https://user-images.githubusercontent.com/47964708/149030811-536a6beb-8c4c-4a83-a267-8f811cf9218a.png)  
  - [ ] StringBuilder 특성 고려하여 문자열 작업하는 코드 작성하기 (String.format 사용)