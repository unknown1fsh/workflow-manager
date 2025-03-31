# SmartWorkflowManager

SmartWorkflowManager, çok adımlı onay süreçlerinin tanımlanabildiği, yönetilebildiği ve kullanıcı bazlı adım atamalarıyla çalışabilen, kurumsal düzeyde esnek ve genişletilebilir bir süreç yönetim sistemidir.

## 🚀 Özellikler

- ✔️ Kullanıcı yönetimi (Admin / Operator / Viewer rolleri)
- ✔️ Süreç (workflow) tanımlama
- ✔️ Her sürece çoklu adım (step) ekleme
- ✔️ Adımları kullanıcıya atama
- ✔️ Adım durumu: PENDING / APPROVED / REJECTED
- ✔️ MapStruct ile DTO-Entity dönüşümleri
- ✔️ Global exception handling
- ✔️ Swagger UI ile canlı API dokümantasyonu
- ✔️ Katmanlı mimari (Layered Architecture)
- ✔️ Postman collection desteği (senaryo bazlı testler)

---

## 🧱️ Süreç Akışı Diyagramı

Aşağıdaki diyagram, bir iş sürecinin sistemde nasıl tanımlandığını ve ilerlediğini göstermektedir:

![Workflow Süreç Akışı](docs/workflow-diagram.png)

---

## 🧱️ Proje Yapısı

```
com.smartworkflow.workflow_manager
├── base              # BaseEntity sınıfı
├── config            # Swagger ve diğer yapılandırmalar
├── controller        # REST API controller katmanı
├── dto               # Veri transfer nesneleri
├── entity            # JPA Entity'leri
├── enums             # Enum tanımları
├── exception         # Hata yönetimi sınıfları
├── mapper            # MapStruct arabirimleri
├── repository        # JPA repository arayüzleri
├── service
│   └── impl          # Servislerin implementasyonları
└── WorkflowManagerApplication.java
```

---

## ⚙️ Kullanılan Teknolojiler

- Java 17
- Spring Boot 3.4.4
- Spring Security
- Spring Data JPA (Hibernate)
- MapStruct
- Lombok
- Swagger (Springdoc OpenAPI)
- MySQL
- Maven

---

## 🖥️ Kurulum

### 1. Veritabanı oluştur

```sql
CREATE DATABASE smart_workflow_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 2. `application.properties` dosyasını yapılandır

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smart_workflow_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=12345

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

springdoc.swagger-ui.path=/swagger-ui.html
```

### 3. Projeyi çalıştır

```bash
./mvnw spring-boot:run
```

---

## 🥺 API Testleri

Swagger UI arayüzü:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Postman testleri için: `SmartWorkflowManager-Kapsamli.postman_collection.json` dosyasını import edebilirsin.

---

## 🔐 Varsayılan Kullanıcı (manuel insert)

```sql
INSERT INTO user (username, password, role, active)
VALUES ('admin', 'admin123', 'ADMIN', true);
```

> Şifre encode edilmeden giriliyorsa Spring Security üzerinden encoder uygulanmalıdır.

---

## 🔀 Örnek Kullanım Senaryosu

1. Kullanıcı oluştur
2. Workflow tanımla
3. Adımlar ekle ve kullanıcı ata
4. Her kullanıcı kendisine atanan adımı onaylasın veya reddetsin
5. Sürecin durumunu takip et

---

## 📁 Postman Collection

Testler için kullanabileceğin dosya:

`SmartWorkflowManager-Kapsamli.postman_collection.json`

---

## 👨‍💼 Geliştirici Notları

- MapStruct ile `@Mapping` kullanımları dikkatli yapılmalıdır.
- Global hata yönetimi `@ControllerAdvice` ile sağlanır.
- Foreign key alanlar DTO içinde `ID` olarak temsil edilmelidir.
- Enum'lar frontend-backend uyumlu olacak Şkilde dizayn edilmelidir.
- Servislerin arkasında `Repository` ve `Mapper` katmanları vardır.

---

## 📄 Lisans

MIT License. Bu proje açık kaynaklıdır ve geliştirilmeye açıktır.

---

## ✉️ İletişim

Selim Sercan Çınar  
📧 selimsercancinar@outlook.com  
💼 GitHub: [github.com/unknown1fsh](https://github.com/unknown1fsh)
