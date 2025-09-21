help:
    just --list

docs:
    rm -rf jdk
    git clone https://github.com/openjdk/jdk
    cd jdk && git tag > ../tags
    java src/Main.java > tag
    cd jdk && git checkout $(cat ../tag)
    cd jdk && bash configure
    cd jdk && make docs