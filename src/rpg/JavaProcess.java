package rpg;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class JavaProcess {

    private JavaProcess() {}        

    public static int exec(Object object) throws IOException,
                                               InterruptedException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome +
                File.separator + "bin" +
                File.separator + "java";
        String classpath = System.getProperty("java.class.path");

        List<String> command = new LinkedList<String>();
        command.add(javaBin);
        command.add("-cp");
        command.add(classpath);
        command.add("main");

        ProcessBuilder builder = new ProcessBuilder(command);

        Process process = builder.inheritIO().start();
        process.waitFor();
        return process.exitValue();
    }
}