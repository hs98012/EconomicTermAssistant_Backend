## EconomicTermAssistant_Backend

### 프로젝트 소개

* 경제·금융 용어를 쉽게 이해할 수 있도록 도와주는 용어 설명 백엔드 API 서비스입니다.
* 학생·비전문가를 대상으로, 어려운 경제 용어를: 백엔드 DB에 저장된 사전 정의를 통해 REST API 형태로 제공하는 경제용어 사전 에이전트입니다.
(Java + Spring Boot 기반 구현)

### 프로젝트 기간
2023.12.20 ~ 2024.04.23
* 팀 프로젝트(백엔드 전담) (상시 개발/보완)

### 개발 환경

* Java
* Spring Boot
* Gradle
* Spring Web (REST API)
* (JPA + RDB 사용 가능 구조 – H2/MySQL 등 환경에 따라 설정)
* Dockerfile 포함 (컨테이너 배포 가능) 


### 주요 기능
- Term API – 경제 용어 조회/검색
- RESTful API로 경제·금융 용어를 JSON 형태로 제공

- 주요 엔드포인트 예:
  - GET /terms : 등록된 용어 목록 조회
  - GET /terms/{id} : 특정 용어 상세 정보 조회 (용어명, 설명 등)
  - GET /terms/search?query=... : 용어명/키워드 기반 검색
 
### 결과

- Java Spring Boot 기반의 경제 용어 설명 백엔드 시스템 구현
- REST API로: 용어 조회/검색/관리
- Dockerfile 및 Gradle 구성으로 로컬 개발, 서버 배포, 컨테이너 환경 실행까지 고려된 구조
