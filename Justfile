help:
    just --list

docs:
    rm -rf jdk
    git clone https://github.com/openjdk/jdk
    cd jdk && git tag > ../tags
    cat tags
    cd jdk && bash configure
    cd jdk && make docs