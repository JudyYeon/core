## 🧼 Clean Architecture & OOP Checklist(Spring Ver.)

Spring Framework 환경에서 클린 아키텍처와 OOP 원칙을 준수하고 있는지를 확인합니다.

---

### 1. 계층/패키지 구조

- [ ] `domain`, `application`, `interface`, `infra`로 패키지를 구분했는가?
- [ ] `domain`은 `@Entity`, `@Service` 등 Spring Annotation 없이 설계되었는가?  
  ❌ `@Component`, `@Autowired` 가 도메인 레이어에 있으면 안 됨.

---

### 2. 의존성 주입 & 관리

- [ ] 의존성 주입은 생성자 기반으로 수행되는가?  
  ✅ `@RequiredArgsConstructor` 또는 수동 생성자 주입 사용

- [ ] `@Configuration`이나 `@Component`는 외부 계층에만 존재하는가?  
  ✅ DI 관리 대상은 Application 또는 Infra 레이어

---

### 3. 도메인 로직 분리

- [ ] 비즈니스 판단 로직은 Domain 계층 안에 위치하는가?  
  ✅ *예: `Reservation` 객체가 `isOverlappedWith(...)` 같은 도메인 메서드 보유*

- [ ] Service 클래스는 오케스트레이션(흐름 제어)에 집중하는가?  
  ❌ Service가 if-else로 비즈니스 규칙을 직접 판단하지 않아야 함

---

### 4. 아키텍처 방향성

- [ ] 의존성은 Interface를 기준으로 흐르고, 실제 구현체는 바깥에 존재하는가?  
  ✅ *예: `NotificationService` → `EmailNotificationService` 구현체*

- [ ] 외부 시스템 접근 (`JPA`, `RestTemplate`, `Kafka`, 등)은 Adapter로 추상화되었는가?

---

### 5. JPA/DB 관련

- [ ] Entity는 JPA 전용이며, 비즈니스 로직은 최소화되었는가?
- [ ] VO는 `@Embeddable` 등으로 명확히 구분되었는가?

---

### 6. 테스트 용이성

- [ ] Domain, Application 계층은 Spring Context 없이도 테스트 가능한가?  
  ✅ *단위 테스트에서 `@SpringBootTest`를 피함*

- [ ] 외부 API, DB는 통합 테스트 또는 TestContainer를 이용하여 분리했는가?

---

### 7. 컨트롤러/인터페이스 계층

- [ ] Controller는 DTO 변환과 UseCase 호출만 수행하는가?  
  ❌ DTO → Entity 변환, 도메인 로직 수행은 Controller에 있으면 안 됨

- [ ] 요청/응답 객체는 Presentation 전용으로 설계되었는가?  
  ✅ `RequestUserDto`, `ResponseUserDto` 등

---

### 8. Exception / Validation

- [ ] 비즈니스 예외는 도메인 레이어에 정의된 커스텀 예외인가?  
  ✅ *예: `DuplicateEmailException`, `ReservationConflictException`*

- [ ] Controller에서는 글로벌 예외 핸들링(@ControllerAdvice)을 사용하는가?

