package escapemc.Util;

public final class Timer {

	/**
	 * Previous time in milliseconds since this Timer instance was reset.
	 */
	private long previousTime;

	/**
	 * Constants used in conversion.
	 * 
	 * @see java.util.concurrent.TimeUnit
	 */
	public static final long SECOND = 1000, MINUTE = 60000, HOUR = 3600000, DAY = 86400000, WEEK = 604800000;

	/**
	 * Calls the reset method so the last time isn't null or 0.
	 */
	public Timer() {
		reset();
	}

	/**
	 * Converts the current java.lang.System#nanoTime to milliseconds and
	 * returns it.
	 * 
	 * @return Current system time in milliseconds.
	 */
	public static long getCurrentTime() {
		return System.nanoTime() / 1000000;
	}

	/**
	 * Subtracts the last time from the current system time in milliseconds.
	 * 
	 * @return the difference between last time and the current system time in
	 *         milliseconds.
	 */
	public long getDifference() {
		return getCurrentTime() - previousTime;
	}

	/**
	 * Determine if this Timer instance has reached a difference in
	 * milliseconds.
	 * 
	 * @param milliseconds
	 *            the amount of milliseconds that the Timer instance has to have
	 *            reached.
	 * @return If the Timer instance has reached milliseconds.
	 */
	public boolean hasReached(long milliseconds) {
		return getDifference() >= milliseconds;
	}

	/**
	 * Resets the last time.
	 */
	public void reset() {
		previousTime = getCurrentTime();
	}

	/**
	 * @return Last time in milliseconds since this Timer instance was reset.
	 */
	public long get() {
		return previousTime;
	}

	/**
	 * Converts milliseconds to a time measurement.
	 * 
	 * @param milliseconds
	 *            the milliseconds to convert
	 * @param convertTo
	 *            the time measurement to convert to
	 * @return milliseconds / the time measurement to convert to
	 */
	public static double convert(long milliseconds, long convertTo) {
		return milliseconds / convertTo;
	}

}