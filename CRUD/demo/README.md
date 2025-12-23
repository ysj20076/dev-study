## 연습 목표
- Spring Boot + JPA로 CRUD 기초 기본 흐름 이해.
- REST API를 통해 요청한 데이터가 DB에 저장되는 것 확인

## 복습한 것
1. mysql만 Docker로 띄운다면 Dockerfile은 필요없다.
    - 이미 mysql은 공식 이미지가 있음.
    - 설정만 주입하여 실행하면 끝
    - docker-compose.yml을 작성하면 긴 실행 명령을 compose 파일에 작성하고 올리기만 하면 됨
```
docker run -d --name mysql \
-e MYSQL_DATABASE=todo_db \
-e MYSQL_USER=todo \
-e MYSQL_PASSWORD=todo \
-e MYSQL_ROOT_PASSWORD=root \
-p 3306:3306 mysql:8.0
```
    
2-1. applicaion.yml의 datasource
- Spring이 어디에 있는 db에 어떻게 접속할것인가? 정보를 적은 것
- localhost 3306에 있는 mysql에서 basic_todo_DB를
- yoon / yoon1234 계정으로 쓰겠다.

2-2. docker-compose.yml의 mysql설정은
- db를 실제로 만드는 쪽
```
environment:
      MYSQL_DATABASE: basic_todo_db
      MYSQL_USER: yoon
      MYSQL_PASSWORD: yoon1234
      MYSQL_ROOT_PASSWORD: root
```
- MYSQL_DATABASE : DB이름 생성
- MYSQL_USER / MYSQL_PASSWORD : 이 정보로 계정 생성

- 그렇게 때문에 논리적으로 db이름과, 유저, 비번, 포트번호가 같아야 접속 가능


## 트러블 슈팅
1. 포트매핑 문제
- **원인** : 
- 이미 로컬 3306 포트에 docker desktop이 설치되어있어
- docker-compose mysql 포트매핑을 3307(외부,로컬):3306(내부,컨테이너) 로 바꾸었다
- **해결** :
```
netstat -ano | findstr :3306
```
-> 포트 점유하고 있는 프로세스 확인
```
tasklist | findstr PID
```
-> PID 확인 후 삭제

2. 컨테이너 및 볼륨 캐시 문제
- **원인** :
- 이전에 잘못된, 다른 설정(db이름, 계정, 비밀번호)으로 생성된 mysql 컨테이너와 볼륨이 남아있었음
- docker-compose.yml을 수정해도 **이미 생성된 볼륨에는 변경사항이 적용되지 않는 문제**
- spring이 접속하지 못함
- **해결** :
```
docker-compose down -v
```
-> 컨테이너, 네트웤, mysql 데이터 볼륨 모두 삭제
```
docker-compose up -d
```
-> 재실행, 업데이트 된 환경변수 기준으로 새로 생성됨


## 남은 할일
- curl로 데이터를 전송하여 흐름 확인하기