import java.util.*;
import java.io.*;
public class ProcessHandleTest {
public static void main(String args[]) {
ProcessHandle processHandle = ProcessHandle.current();
System.out.println("PID of running Process:" + processHandle.pid());
System.out.println("Command: " +
processHandle.info().command().orElse("N/A"));
System.out.println("Start Time : " + ((Info)
processHandle).startInstant().get());
System.out.println("CPU Duration: " +
processHandle.info().totalCpuDuration().get().getSeconds() + " seconds");
ProcessHandle currentProcessHandleImpl
= ProcessHandle.current();
ProcessHandle.Info processInfo =
currentProcessHandleImpl.info();
System.out.println("nProcess snapshot of the current running process:");
System.out.println("User : " +
processInfo.user().get());
System.out.println("Start Time : " +
processInfo.startInstant().get());
}
}