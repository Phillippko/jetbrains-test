# Задача 2
Представьте, что вы разрабатываете сервис аналитики. В ваш сервис приходят данные из разных источников и при определённых событиях вам нужно уведомлять пользователей об изменениях в данных. Для разных типов событий есть разные шаблоны сообщений, в которые нужно вставить конкретную информацию.

Разработайте сервис для формирования таких сообщений. Сервис загружает и хранит шаблоны сообщений в БД. По запросу формирует и отправляет сообщения с помощью отправки запроса на заданные rest эндпоинты. В архитектуре сервиса предусмотрите возможность будущего расширения для добавления или замены способа отправки сообщений.

Сделайте stand-alone Spring Boot Application с rest-сервисом. Rest сервис должен содержать как минимум два эндпоинта. Первый эндпоинт загружает шаблон. В запросе содержится имя шаблона, текст, который может содержать подстановки вида $value$ и список url получателей сообщения. Пример запроса:
```
{
  "templateId": "internshipRequest",
  "template": "Jetbrains Internship in $teamName$ team.",
  "recipients": ["http://some.server.url/endpoint", "http://some.other.url/endpoint"]
}
```
Второй эндпоинт служит для отправки сообщений. Запрос содержит имя шаблона и переменные, которые необходимо вставить в шаблон. Пример запроса:
```
{
  "templateId": "internshipRequest",
  "variables": [{"teamName": "Analytics Platform"}]
}
```
В результате на эндпоинты "http://some.server.url/endpoint" и "http://some.other.url/endpoint" должен быть отправлен запрос:
```
{"message": "Jetbrains Internship in Analytics Platform team."}
```
Напишите unit-тесты. Для хранения шаблонов используйте базу данных h2. Для тестирования отправки rest запросов используйте любой rest echo server (например, https://httpbin.org/). Плюсом будет использование gradle для сборки проекта.

В качестве результата предоставьте ссылку на публичный github репозиторий.

# Дополнительно:

* Добавьте возможность сохранения параметров сообщения и его регулярную отправку (например, раз в 10 минут)

* Добавьте возможность указать в шаблоне тип переменной для подстановки и валидацию значений (например, [{"teamName": "string"}, {"year": "int"}])

* Добавьте поддержку escape-символов, чтобы можно было загрузить шаблон содержащий текст “$$$”.

* Придумайте и добавьте любую другую реализацию способа отправки сообщени
