package me.yurinero.RandomExploration.logic;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/* Originally this was only meant to get the Epoch Timestamp, but I got a bit carried away.
*  Some of the functions are redundant for the purpose of the final product, but feel free to call them yourself in ControlPanel.java and experiment with the output.
*/

public class UserTime {
	private final Clock clock;

	// Default to system's timezone (user's local time)
	public UserTime() {
		// Uses system's default timezone
		this(Clock.systemDefaultZone());
	}

	// Allow custom clocks for testing
	public UserTime(Clock clock) {
		this.clock = Objects.requireNonNull(clock, "Clock cannot be null");
	}

	// Get current local date/time (user's system timezone)
	// This returns it in a default format including nanoseconds, and can be quite hard on the eyes if displayed to the end user.
	public LocalDateTime getUserDateTime() {
		return LocalDateTime.now(clock);
	}
    // To make it more palatable, we can use the below three functions to gather the two values: Date & Time separately, and then parse them together with formatting that fits us.
	public String getFormattedUserDate() {
		return LocalDate.now(clock).format(DateTimeFormatter.ISO_DATE);
	}
	public String getFormattedUserTime() {
		return LocalDateTime.now(clock)
				.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
	public String getFormattedUserDateTime() {
		return String.format("Date: %s / Time: %s", getFormattedUserDate(), getFormattedUserTime());
	}
	// Get current local date (user's system timezone)
	public LocalDate getUserDate() {
		return LocalDate.now(clock);
	}

	// Get timezone offset from UTC (accounts for DST)
	public ZoneOffset getUserZoneOffset() {
		return clock.getZone().getRules().getOffset(Instant.now(clock));
	}

	// Get current UTC epoch second
	public long getEpochSecond() {
		return Instant.now(clock).getEpochSecond();
	}

}
