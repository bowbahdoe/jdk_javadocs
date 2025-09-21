void run(List<String> cmd) throws Exception {
    int exit = new ProcessBuilder(cmd).inheritIO().start().waitFor();
    if (exit != 0) {
        throw new Exception("" + exit);
    }
}

void main(String[] args) throws Exception {
    var tags = Files.readAllLines(Path.of("tags"));
    var tagPattern = Pattern.compile("jdk-(<?major>\\d+)\\+(<?revision>\\d+)");
    tags.stream()
            .filter(tag -> tag.startsWith("jdk-"))
            .sorted(Comparator.<String, String>comparing(tag -> tag.replaceFirst("jdk-", "").split("\\+", 2)[0]).reversed())
            .forEach(IO::println);
}