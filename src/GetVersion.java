void main() {
    var twentyFiveRelease = ZonedDateTime.of(
            LocalDateTime.of(
                    LocalDate.of(2025, Month.SEPTEMBER, 16),
                    LocalTime.NOON
            ),
            ZoneId.systemDefault()
    );
    /* var test = ZonedDateTime.of(
            LocalDateTime.of(
                    LocalDate.of(2026, Month.MARCH, 1),
                    LocalTime.NOON
            ),
            ZoneId.systemDefault()
    );
    var now = test;
    */
    var now = ZonedDateTime.now(ZoneId.systemDefault());

    var monthsPassed = ChronoUnit.MONTHS.between(
            twentyFiveRelease.withDayOfMonth(1),
            now
    );

    IO.println(25 + monthsPassed / 6);
}