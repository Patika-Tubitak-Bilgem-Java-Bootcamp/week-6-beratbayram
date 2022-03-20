package src;

import static src.Utils.Header.Notebook;

public class Utils {
    enum Header {
        Notebook,
        MobilePhone
    }

    static void println(String str) {
        System.out.println(str);
    }

    static void printHeader(Header header) {
        switch (header) {
            case Notebook -> {
                Utils.println("----------------------------------------------------------------------------------------------------------");
                Utils.println("| ID | Product Name                   | Price      | Brand      | Storage    | Screen Size  | RAM        |");
                Utils.println("----------------------------------------------------------------------------------------------------------");
            }
            case MobilePhone -> {
                Utils.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
                Utils.println("| ID | Product Name                   | Price      | Brand      | Storage    | Screen Size  | Camera     | Battery    | RAM        | COLOR      |");
                Utils.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}
