public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int hours = seconds / 3600;
        int mins = (seconds % 3600) / 60;
        int secs = (seconds % 3600)  % 60;

        return String.format("%02d:%02d:%02d", hours, mins, secs);
    }
}