package org.example;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class Main {

    public static void main(String[]args){
        AnsiConsole.systemInstall();
        System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("Hello World!").reset());
        AnsiConsole.systemUninstall();
    }
}