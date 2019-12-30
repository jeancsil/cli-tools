# CLI Tools
Playing with Java CLI

# How to use it?

```bash
make build
```

Builds the jar files and put them into build/libs/.  
Will also build the GraalVM Native Image and put them into build/graal/.

```bash
make build-native-image
```
Builds only the GraalVM Native Image.

```bash
make clean
```
Removes the build/ directory.