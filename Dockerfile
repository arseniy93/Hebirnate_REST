
#LABEL authors="arsen"
## Используем базовый образ Tomcat 10
FROM tomcat:10.1.26-jdk17

# Копируем WAR-файл в директорию webapps Tomcat
COPY target/Hibetnate_REST.war /usr/local/tomcat/webapps/
COPY server.xml /usr/local/tomcat/conf/server.xml
# Устанавливаем переменные окружения (если необходимо)
ENV JAVA_OPTS="-Dspring.datasource.url=jdbc:postgresql://postgres:5432/hebirnate_project"

# Открываем порты
EXPOSE 8082

# Команда для запуска Tomcat
CMD ["catalina.sh", "run"]
