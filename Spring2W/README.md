<h1>파일구조</h1>

--------
Security
--------
- JWT 토큰 발행
- JWT 토큰 조회
--------
Controller
--------
"/userapi"

POST "/register"
- 회원가입 api

POST "/login"
- 로그인 api
--------
"/postapi"

GET "post"
- 글 조회 api

GET "post/{id}"
- 글 상세 조회 api

POST "post"
- 글 작성 api

PUT "post/{id}"
- 글 수정 api

DELETE "post/{id}"
- 글 삭제 api (댓글도 함께)
--------

"/repleapi"

GET "/reple"
- 모든 댓글 조회 api

GET  "/reple/{id}"
- 해당 게시글 댓글 조회 api

POST "/reple/{id}"
- 댓글 작성 api

PUT "/reple/{repleid}"
- 댓글 수정 api

DELETE "reple/{repleid}"
- 댓글 삭제 api
--------
--------
Dto
--------
- 회원가입DTO
  <br>
아이디(닉네임)<br>
비밀번호<br>
비밀번호체크

- 로그인DTO
  <br>
아이디(닉네임)<br>
비밀번호

- 글 등록 DTO
  <br>
글쓴이<br>
글제목<br>
글내용<br>

- 글 수정 DTO
<br>
글쓴이<br>
글제목<br>
글내용<br>
수정날짜<br>

- 댓글 작성 DTO
<br>
  게시글번호<br>
  댓글작성자<br>
  댓글내용<br>

- 댓글 수정 DTO
  <br>
  댓글작성자<br>
  댓글내용<br>
  수정날짜<br>

- JWT 토큰용 DTO
  토큰

--------
Entity
--------
- 유저테이블
- 게시글테이블
- 댓글테이블
- 타임스탬프
--------
Repository
--------
- 유저JPA
- 게시글JPA
- 댓글JPA
--------
Service
--------
--------
- 회원가입 서비스
- 로그인 서비스
--------
- 글 조회 서비스
- 글 상세 조회 서비스
- 글 작성 서비스
- 글 수정 서비스
- 글 삭제 서비스 (댓글도 함께)
--------
- 댓글 조회 서비스
- 댓글 작성 서비스
- 댓글 수정 서비스
- 댓글 삭제 서비스

--------