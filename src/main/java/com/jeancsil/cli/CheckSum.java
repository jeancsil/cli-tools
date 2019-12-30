package com.jeancsil.cli;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Help.Ansi;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
    name = "checksum",
    mixinStandardHelpOptions = true,
    version = "checksum 1.0",
    description = "Prints the checksum of the file")
public class CheckSum implements Callable<Integer> {

  @Parameters(index = "0", description = "The file to calculate the checksum.")
  private File file;

  @Option(
      names = {"-a", "--algorithm"},
      description = {"MD5, SHA-1, SHA-256, ..."})
  private String algorithm = "MD5";

  public static void main(String[] args) {
    int exitCode = new CommandLine(new CheckSum()).execute(args);
    System.exit(exitCode);
  }

  @Override
  public Integer call() throws Exception {
    byte[] fileContents = Files.readAllBytes(file.toPath());

    byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);

    System.out.println(String.format(Ansi.ON.string("@|bold,green %s checksum is:|@"), algorithm));
    System.out.printf("%0" + (digest.length * 2) + "x%n", new BigInteger(1, digest));
    return 0;
  }
}
