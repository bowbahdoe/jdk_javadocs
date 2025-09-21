void main() throws Exception {
    var tags = Files.readAllLines(Path.of("tags"));
    var tagPattern = Pattern.compile("jdk-(?<major>\\d+)-ga");

    record TagAndMajor(String tag, int major) {}
    tags.stream()
            .filter(tag -> tag.startsWith("jdk-"))
            .filter(tag -> tag.endsWith("-ga"))
            .map(tag -> {
                var matcher = tagPattern.matcher(tag);
                matcher.find();
                return new TagAndMajor(
                        tag, Integer.parseInt(matcher.group("major"))
                );
            })
            .max(Comparator.comparing(TagAndMajor::major))
            .map(TagAndMajor::tag)
            .ifPresent(IO::println);
}