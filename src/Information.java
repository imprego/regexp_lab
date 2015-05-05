/**
 * Created by vommy on 06.05.2015.
 */
import java.io.*;

public class Information {

        static public String GetContents(File file)
        {
            StringBuilder contents = new StringBuilder();

            try
            {
                if (file == null)
                {
                    throw new IllegalArgumentException("File should not be null.");
                }

                if (!file.exists())
                {
                    throw new FileNotFoundException();
                }

                if (!file.canRead())
                {
                    throw new IllegalArgumentException("File cannot be written: " + file);
                }

                if (!file.isFile())
                {
                    throw new IllegalArgumentException("Should not be a directory: " + file);
                }

                FileInputStream fis = new FileInputStream(file);
                InputStreamReader in = new InputStreamReader(fis, "Unicode");
                BufferedReader input =  new BufferedReader(in);
                try
                {
                    String line = null;

                    while ((line = input.readLine()) != null)
                    {
                        contents.append(line + "\r\n");
                    }
                }
                finally
                {
                    input.close();
                }
            }
            catch (FileNotFoundException ex)
            {
                System.out.println("File does not exist: " + file);
            }
            catch(IllegalArgumentException ex)
            {
                System.out.println(ex.getMessage());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

            return contents.toString();
        }

        public static void main(String[] args)
        {
            File testFile = new File("testFile.txt");

            String contents = GetContents(testFile);
            System.out.print("File contents:\r\n" + contents);
            System.out.println("--------------------------------------------");

            //Analyze(contents);

    }





}
