install:
	sudo apt install docker-compose \
	&& sudo usermod -aG docker $$USER \
	&& sudo service docker restart

jar:
	mvn clean package

stop:
	docker-compose stop

redb:
	docker-compose down up db

up:
	docker-compose up

db:
	docker-compose up db

up-d:
	docker-compose up -d

build:
	mvn clean package -DskipTests
	docker-compose up --build

build_d:
	docker-compose up -d db
	mvn clean package
	docker-compose build
	docker-compose up

delete:
	docker-compose down

ps:
	docker-compose ps

psql:
	docker exec -it $(docker-compose ps -q postgres) psql -U root -d authorization_db
