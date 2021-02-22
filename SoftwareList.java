import java.io.IOException;
import java.util.*;
import java.util.Optional;
public class SoftwareList {
public static void main(String[] args) throws IOException {
long beforeUsedMem =
Runtime.getRuntime().totalMemory() -
Runtime.getRuntime().freeMemory();
System.out.println("Total available memory");
System.out.println(beforeUsedMem);
 /*Process process =Runtime.getRuntime().exec("google-chrome");
ProcessHandle.allProcesses().forEach(processs ->System.out.println(processDetails(processs)));*/
System.out.println("---------------------------");
System.out.println("Children Processes:");
Optional<ProcessHandle> processHandle =
ProcessHandle.allProcesses().findFirst();
processHandle.ifPresent(proc ->proc.children().forEach(child -> System.out.println("PID: [ "+ child.pid() + " ], Cmd: [ " + child.info().command()+ " ]")));
}
private static String
processDetails(ProcessHandle process) {
return String.format("%8d %8s %10s %26s
%-40s", process.pid(),
text(process.parent().map(ProcessHandle::pid)),
text(process.info().user()),
text(process.info().startInstant()),
text(process.info().commandLine()));
}
private static String text(Optional<?> optional) {
return
optional.map(Object::toString).orElse("-");
}
}