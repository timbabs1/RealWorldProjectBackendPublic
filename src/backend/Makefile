
GRADLEW=./gradlew

.PHONY: build
build:
	$(GRADLEW) build

run:
	SPRING_CONFIG_NAME=application $(GRADLEW) bootRun

test:
	$(GRADLEW) test

startdb:
	docker run -d -p 127.0.0.1:27017:27017 mongo
