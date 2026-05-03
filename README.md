# 카카오테크캠퍼스 Step2 - Android 과제 모음

> 카카오테크캠퍼스 2기 Step2 Android 과제들을 하나로 모은 레포입니다.

## 📚 과제 목록

| 주차 | 주제 | 레포 |
|------|------|------|
| 1주차 | 연락처 | android-contacts |
| 2주차 | 검색어 저장 | android-map-keyword |
| 3주차 | 위치 검색 / 네트워크 통신 | android-map-search |
| 4주차 | 위치 이동 | android-map-location |
| 5주차 | 리팩토링 / 주요 라이브러리 | android-map-refactoring |

---

## 1주차 - 연락처
**android-contacts**

### PR #33 · 부산대 Android_이지은 1주차 과제

- 📅 작성일: 2024-06-28
- 🔗 URL: https://github.com/kakao-tech-campus-2nd-step2/android-contacts/pull/33

#### 📞 기능 목록

**step1 - 연락처 입력**
- 이름 (필수) — 미입력 시 Toast 메시지
- 전화번호 (필수, 숫자만) — 미입력 / 형식 오류 시 Toast 메시지
- 메일
- 더보기 (클릭 시 폼 확장)
  - 생일: 캘린더
  - 성별: 여자 / 남자
  - 메모
- 저장 / 취소 Toast 메시지

**step2 - 연락처 목록**
- 이름 앞글자 사진과 이름 표시, 스크롤 가능
- 연락처 추가 — 취소 시 확인 팝업
- 연락처 상세 보기 — 이름 / 전화번호 표시

#### 🤔 어려웠던 점
- Serializable, let 문법 등의 개념을 충분히 이해하지 못하고 코드를 작성한 점이 아쉬웠습니다.

#### 💬 리뷰 요청
- commit 메시지 일관성 부족 — xml 디자인 작업과 kotlin 기능 작업을 구분하지 않고 작성했는데, 좋은 commit 메시지 작성 방법이 궁금합니다.
- 안드로이드 프로젝트에서 함수 분리 기준을 잡기가 어려웠습니다.

---

## 2주차 - 검색어 저장
**android-map-keyword**

### PR #14 · 부산대 Android_이지은 2주차 1단계 제출

- 📅 작성일: 2024-07-02
- 🔗 URL: https://github.com/kakao-tech-campus-2nd-step2/android-map-keyword/pull/14

#### 🤔 어려웠던 점
- SQL 문법이 낯설어서 테이블 생성, 데이터 저장 코드를 짤 때 어려움이 있었습니다.

#### 💬 리뷰 요청
- `addLocationData()` 호출 시 로그에는 1번 실행된 것으로 보이는데 DB에 데이터가 2개씩 들어가는 현상이 발생합니다. 원인과 해결 방법이 궁금합니다.

#### 🖼️ 실행 화면

![image](https://github.com/kakao-tech-campus-2nd-step2/android-map-keyword/assets/89847820/199a4649-8532-4367-bb8a-3d6926c65dff)

<img src="https://github.com/kakao-tech-campus-2nd-step2/android-map-keyword/assets/89847820/c2d13cfe-d413-4306-8296-9d4f34817189" width="50%">

---

### PR #60 · 부산대 Android_이지은 2주차 2단계 제출 (리팩토링 완료)

- 📅 작성일: 2024-07-05
- 🔗 URL: https://github.com/kakao-tech-campus-2nd-step2/android-map-keyword/pull/60

#### 🔎 기능 목록 (step2)
- 검색 기능 — x 버튼으로 검색어 삭제
- 검색 결과 목록 (RecyclerView) — 세로 스크롤, 항목 선택 시 저장 목록에 추가
- 검색어 저장 목록 — 가로 스크롤, x 버튼으로 삭제, 앱 재실행 시에도 유지

#### 🔄 리팩토링 내용
1. **MVVM 구조 개선**
   - ViewModel에서 Repository에 접근하도록 수정
   - ViewModelFactory 클래스 추가
   - ViewHolder에서 Adapter 내부 접근 제거
2. **인터페이스 도입** — 콜백 함수를 `onItemSelected` 인터페이스로 관리
3. **검색 기능 변경** — `filter()` 대신 DB 검색 쿼리 사용

#### 🤔 어려웠던 점
- ViewModel 개념 이해 부족으로 미숙한 코드를 작성했습니다.
- RecyclerView 항목 터치 시 여러 동작(ViewModel 변경, DB 저장)을 연결하는 작업이 복잡했습니다.

#### 💬 리뷰 요청
- ViewModel 관련 부족한 부분 피드백 부탁드립니다.
- DB 접근 코드를 `LocationDbHelper`에 넣지 않고 `LocationDbAccessor` 클래스를 따로 만든 판단이 적절했는지 궁금합니다.

#### 🖼️ 구현 화면

<img src="https://github.com/kakao-tech-campus-2nd-step2/android-map-keyword/assets/89847820/6801630c-55ce-47d8-a547-a7364074b571" width="30%">
<img src="https://github.com/kakao-tech-campus-2nd-step2/android-map-keyword/assets/89847820/8a1ab0f6-bac1-4f99-a9db-1c45d55d7e78" width="30%">
<img src="https://github.com/kakao-tech-campus-2nd-step2/android-map-keyword/assets/89847820/edcccb8c-2a54-4906-a3b1-ea5b768b5846" width="30%">

---

## 3주차 - 위치 검색 / 네트워크 통신
**android-map-search**


### PR #98 · 부산대 Android_이지은 3주차 1단계

- 📅 작성일: 2024-07-12
- 🔗 URL: https://github.com/kakao-tech-campus-2nd-step2/android-map-search/pull/98

#### 🤔 어려웠던 점
- suspend 함수, 코루틴 개념이 헷갈렸습니다.
- API 통신으로 받아온 데이터를 LiveData에 저장하는 작업이 완료되기 전에 사이즈에 접근하여 계속 0으로 표시되는 문제가 있었습니다.

#### 💬 리뷰 요청
- 데이터를 비동기적으로 올바르게 받아왔는지 확인 부탁드립니다.

#### 🖼️ 실행 화면

<img src="https://github.com/user-attachments/assets/be14e1b7-803b-4a1b-9e0c-1321aead9eb2" width="30%">

---

### PR #106 · 부산대 Android_이지은 3주차 2단계 (리팩토링 완료)

- 📅 작성일: 2024-07-12
- 🔗 URL: https://github.com/kakao-tech-campus-2nd-step2/android-map-search/pull/106

#### 🔎 기능

**step1 - 카카오 로컬 API**
- 검색어에 맞는 결과 15개 이상 표시
- API 키 외부 노출 방지

**step2 - 카카오 지도 API**
- 앱 실행 시 지도 화면 표시
- 검색창 선택 시 검색 화면으로 이동
- 뒤로 가기 시 지도 화면으로 복귀

#### 🗂️ 패키지 구조

<img src="https://github.com/user-attachments/assets/fc4e83a5-1b4f-4698-bb55-946fca9c78ba" width="80%"/>

#### 🤔 어려웠던 점
- 정처기 공부와 2주차 리팩토링으로 시간이 부족해 3주차 과제에 충분히 집중하지 못했습니다. 비동기 처리를 더 공부해야겠습니다.

#### 💬 리뷰 요청
- `savedLocationRecyclerView`가 visible 상태일 때 `locationRecyclerView` 하단이 잘리는 문제 — 해결 방법이 궁금합니다.
- viewmodel / model / view / repository / retrofit으로 나눈 패키지 구조가 MVVM 패턴에 맞는지 확인 부탁드립니다.

#### 🖼️ 실행 화면

https://github.com/user-attachments/assets/4b0a6d8a-d01b-423c-b5e8-cda60e92be58

---

## 4주차 - 위치 이동
**android-map-location**

### PR #60 · 부산대 Android_이지은 4주차 1단계

- 📅 작성일: 2024-07-18
- 🔗 URL: https://github.com/kakao-tech-campus-2nd-step2/android-map-location/pull/60

#### 🤔 어려웠던 점
- 리스너, 콜백 함수, 람다 함수 개념이 겹쳐 헷갈렸습니다.
- 액티비티 생명주기를 이론으로 배웠지만 실습에서 낯설게 느껴졌습니다.
- 이전보다 프로젝트 구조가 잡혀 있어 기능 추가는 수월했습니다.

#### 💬 리뷰 요청
- 마지막 위치 저장 시 `onMapReady()` 안에 SharedPreference 저장 코드를 구현했는데, `onPause()`에 구현하는 방식과 비교해 어떤 방식이 더 좋은지 궁금합니다.

#### 🖼️ 실행 화면

**추가된 기능**

https://github.com/user-attachments/assets/4b832c43-16fc-4d62-8351-0178de6b24c3

**앱 종료 후 다시 실행**

https://github.com/user-attachments/assets/25142ab9-40e8-40dd-8324-6495b5740fa3

**지도 에러 화면**

<img src="https://github.com/user-attachments/assets/30f64bde-d8ce-4fdc-892f-dd5aa0295f6b" width="40%"/>

---

### PR #72 · 부산대 Android_이지은 4주차 2단계 (리팩토링 완료)

- 📅 작성일: 2024-07-19
- 🔗 URL: https://github.com/kakao-tech-campus-2nd-step2/android-map-location/pull/72

#### 🔄 리팩토링 내용
- 멘토님 피드백을 반영하여 리팩토링했습니다.
- 테스트 코드는 추가 학습 후 수정 예정입니다.

#### 🤔 어려웠던 점
- 테스트 코드를 따라쳐본 경험은 있지만 직접 작성하려니 감이 잡히지 않았습니다.

#### 💬 리뷰 요청
- 카카오 지도에서 error를 발생시키는 부분을 어떻게 구현해야 할지 모르겠습니다.

---

## 5주차 - 리팩토링 / 주요 라이브러리
**android-map-refactoring**

### PR #60 · 부산대 Android_이지은 5주차 1단계

- 📅 작성일: 2024-07-25
- 🔗 URL: https://github.com/kakao-tech-campus-2nd-step2/android-map-refactoring/pull/60

#### 🤔 어려웠던 점
- Room과 Hilt 모두 처음 사용해보았는데, Hilt가 더 어려웠습니다. Component와 Scope를 고려해 의존성을 선언해야 해서 단순하지 않았습니다.

#### 💬 리뷰 요청
- 3개의 모듈을 모두 `SingletonComponent`로 설정했는데, Repository는 ViewModel에서 사용되고 ViewModel은 Activity 생명주기에 영향을 받지 않으므로 `ViewModelComponent`로 설정해도 되는지 궁금합니다. 컴포넌트를 정하는 기준을 잘 모르겠습니다.

---

### PR #77 · 부산대 Android_이지은 5주차 2단계 (리팩토링 완료)

- 📅 작성일: 2024-07-26
- 🔗 URL: https://github.com/kakao-tech-campus-2nd-step2/android-map-refactoring/pull/77

#### 💬 리뷰 요청
- 전반적인 리팩토링 코드 리뷰 부탁드립니다.

---
