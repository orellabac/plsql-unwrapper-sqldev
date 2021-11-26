import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.util.zip.DataFormatException;

import com.trivadis.unwrapper.util.*;

class unwrap_cli {

    public static void usage() {
        System.out.println("unwrap_cli input_file output_file");
    }
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, DataFormatException {
        System.out.println("Unwrapper for Oracle PL\\SQL");
        if (args.length >= 2)
        {
            var infile = args[0];
            var outfile = args[1];
            System.out.println("Procesing file: ");
            var contents = Files.readString(Path.of(infile));
            var res = Unwrapper.unwrap(contents);
            try (PrintStream out = new PrintStream(new FileOutputStream(outfile))) {
                out.print(res);
            }

        }
        else {
            usage();
        }
    }
}