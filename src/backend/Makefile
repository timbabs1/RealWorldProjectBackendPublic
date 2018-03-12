
GRADLEW=./gradlew

.PHONY: build
build:
	$(GRADLEW) build

docker:
	$(GRADLEW) build docker

run:
	SPRING_CONFIG_NAME=application $(GRADLEW) bootRun

rundocker:
	docker run --rm -p 127.0.0.1:8080:8080 sevena/backend
	#docker service create --network net1 -p 8080:8080 sevena/backend

test:
	$(GRADLEW) test

startdb:
	docker run -d -p 127.0.0.1:27017:27017 mongo
