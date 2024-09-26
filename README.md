# Telegram Bot File Sharing Service

Проект разработан на базе видео-уроков по созданию Telegram-бота с использованием **Java**. Основное назначение проекта — создание файлообменника с асинхронной обработкой сообщений, что позволяет пользователям загружать и передавать файлы через Telegram.

Проект реализован в микросервисной архитектуре, что дало возможность изучить принципы взаимодействия сервисов, работу с очередями сообщений и развертывание на VPS (Virtual Private Server).

## Основные цели проекта

- **Знакомство с микросервисной архитектурой**: изучение принципов декомпозиции приложения на отдельные сервисы.
- **Асинхронная обработка сообщений**: использование брокера сообщений для обработки пользовательских запросов в неблокирующем режиме.
- **Практика деплоя на VPS**: изучение механизмов развертывания приложений с использованием Docker на удаленных серверах.

---

## Технологии, используемые в проекте

Проект построен с использованием следующих технологий:

- **Spring Boot** — для создания основного приложения.
- **Spring Data JPA** — для работы с базой данных PostgreSQL через ORM.
- **Maven** — для управления зависимостями и сборки проекта.
- **RabbitMQ** — для асинхронной передачи и обработки сообщений между сервисами.
- **Telegram API** — для взаимодействия с платформой Telegram.
- **PostgreSQL** — реляционная база данных для хранения информации о пользователях и файлах.
- **Docker** — для контейнеризации приложения и упрощения деплоя на VPS.
