help:
    just --list

docs:
    rm -rf jdk
    git clone https://github.com/openjdk/jdk
    cd jdk && git tag > ../tags
    cd jdk && git checkout $(java src/Main.java)
    cd jdk && bash configure
    cd jdk && make docs