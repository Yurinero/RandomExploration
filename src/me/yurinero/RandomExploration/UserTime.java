package me.yurinero.RandomExploration;

import java.time.*;
import java.util.Objects;
/* This is a helper class to get the users local timestamp in EpochTime*
*  Further we can also do some other fun stuff, such as read off the users Date, Time, or Both.
* */

public class UserTime {
	private final Clock clock;

	public UserTime() {
		this(Clock.systemUTC());
	}

	public UserTime(Clock clock) {
		this.clock = Objects.requireNonNull(clock, "Clock cannot be null");
	}
	public Clock getUserClock(){
		return clock;
	}
    public LocalDateTime getUserDateTime(){
		return LocalDateTime.now(clock);
   }
   public LocalDate getUserDate(){
		return LocalDate.now(clock);
   }
	public ZoneOffset getUserZoneOffset(){
		return ZoneId.systemDefault().getRules().getOffset(getUserDateTime());
	}
	public int getUserEpochSecond(){
		return Math.toIntExact(Instant.now(clock).getEpochSecond());
	}
	public int getUserLocalEpochSecond() {
		LocalTime time = LocalTime.now(clock);
		LocalDate date = getUserDate();
		ZoneOffset offset = getUserZoneOffset();
		return Math.toIntExact(time.toEpochSecond(date, offset));
	}

}
