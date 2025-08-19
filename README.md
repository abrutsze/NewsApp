# Project News (KMM) — Client Overview

## 1) What this app does
A cross‑platform **News** app built with **Kotlin Multiplatform Mobile (KMM)** and **Compose Multiplatform** for Android and iOS.  
It fetches tech articles from the public **DEV.to API** and provides:
- **Home feed**: top article + paged list (first 20 items).
- **Article details**: title, cover, author, tags, and HTML body preview.
- Clean, responsive UI shared across Android and iOS.

> Note on architecture: I originally **recommended MVI**, but the client **required MVVM**, so the implementation follows **MVVM**.

---

## 2) Architecture overview
Layered, testable structure with clear boundaries:

```
UI (Compose Multiplatform)
   ↕ (State/Events)
ViewModel (MVVM, Koin DI)
   ↕ (UseCases / Contracts)
Domain (Use Cases, Mappers)
   ↕ (Repositories interfaces)
Data (Ktor DataSource, DTO ↔ UI models)
   ↕ (HTTP)
DEV.to REST API
```

- **State management**: MVVM with `ViewModel` + immutable `State` (Contracts) and `Flow`.
- **DI**: Koin modules wire data sources, repositories, use cases, and view models.
- **Networking**: Ktor `HttpClient` with platform engines (OkHttp on Android, Darwin on iOS).
- **Serialization**: Kotlinx Serialization (ignore unknown keys, explicit nulls off).
- **Navigation**: `androidx.navigation.compose` with typed routes.
- **Images**: Coil 3 (`AsyncImage`) in shared UI.

Key modules/directories:
- `composeApp/` — shared UI (Compose), navigation, screens.
- `shared/` — common business logic (DI, use cases, view models, mappers).
- `common/network` — Ktor client, engines, DI, data sources.
- `common/models` — UI models (`UiArticle`, `UiUser`).
- `common/request` & `common/response` — DTOs for API requests/responses.
- `androidApp/` and `iosApp/` — platform entry points.

---

## 3) Technology stack (versions)
- **Kotlin**: 2.1.21
- **Compose Multiplatform**: 1.8.1
- **Android Gradle Plugin**: 8.9.1 (compile/target SDK 35, min SDK 24)
- **Ktor Client**: 3.1.0 (ContentNegotiation + Logging)
- **Koin**: 4.1.0 (including Compose integration)
- **Kotlinx Serialization (JSON)**: 1.8.0
- **Navigation Compose**: 2.9.0‑beta01
- **Coil 3**: 3.2.0

Engines:
- **Android**: OkHttp
- **iOS**: Darwin

---

## 4) API & data
- **Base**: `https://dev.to/api`
- **Endpoints used**:
  - `GET /articles?page=1&per_page=20` — list feed
  - `GET /articles/{id}` — article details
- **Notes**: Public endpoints; rate limits apply. No API key required for the current scope.

Core data flow:
- `ArticlesDataSource(ktor)` → `ArticlesRepository` → `GetArticlesUseCase` → `HomePageViewModel` → `ArticleScreen`
- `ArticlesDataSource.getArticleById` → `ArticleDetailRepository` → `ArticleDetailUseCase` → `ArticleDetailViewModel` → `ArticleDetailScreen`
- Mapping DTO → `UiArticle`/`UiUser` via `shared/mapper/ArticlesMapper.kt`.

---

## 5) Testing
- Unit tests (KMM `commonTest`) for use cases and mappers.  
- Run all tests:
  ```bash
  ./gradlew test
  ```

## 6)Demo video
[Download demo video](media/demo.mp4)
