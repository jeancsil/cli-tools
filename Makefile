build:
	@./gradlew build
	@make build-native-image

build-native-image:
	@./gradlew nativeImage

clean:
	@./gradlew clean