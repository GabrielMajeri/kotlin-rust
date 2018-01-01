# Rust build type.
config := release

# The name of the shared library.
lib_name := librust_jni.so

# The name of the JAR file.
jar_name := KotlinRust.jar

# The path of the shared library
lib_path := target/$(config)/$(lib_name)
# The path of the JAR file.
jar_path := $(jar_name)

# Extract the directory with the native library.
lib_dir := $(dir $(lib_path))

# Kotlin source files.
kotlin_srcs := kotlin/Main.kt kotlin/Rust.kt

.PHONY: run

run: $(lib_path) $(jar_path)
	java -Djava.library.path=$(lib_dir) -jar $(jar_path)

$(lib_path): src/lib.rs
	cargo build --release

$(jar_path): $(kotlin_srcs)
	kotlinc $(kotlin_srcs) -include-runtime -d $(jar_path)
