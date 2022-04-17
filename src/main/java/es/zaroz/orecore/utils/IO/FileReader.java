package es.zaroz.orecore.utils.IO;

import es.zaroz.orecore.OreCore;

import java.io.IOException;
import java.util.logging.Level;

public class FileReader {
    public static String readAllText(String path) {
        StringBuilder sb = new StringBuilder();

        try {
            java.io.File file = new java.io.File(path);
            java.io.FileReader fileReader = new java.io.FileReader(file);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static String readAllText(java.io.File file) {
        StringBuilder sb = new StringBuilder();

        try {
            java.io.FileReader fileReader = new java.io.FileReader(file);
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static byte[] readAllBytes(String path) {
        java.io.File file = new java.io.File(path);
        return readAllBytes(file);
    }

    public static byte[] readAllBytes(java.io.File file) {
        byte[] bytes = new byte[(int) file.length()];
        try {
            java.io.FileInputStream fis = new java.io.FileInputStream(file);
            fis.read(bytes);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static void writeAllBytes(String path, byte[] bytes) {
        java.io.File file = new java.io.File(path);
        writeAllBytes(file, bytes);
    }

    public static void writeAllBytes(java.io.File file, byte[] bytes) {
        //CHECK IF FILE EXISTS, IF NOT, CREATE IT, OTHERWISE, OVERWRITE IT
        if(!file.exists()) {
            try {
                file.createNewFile();
            }catch(IOException e) {
                OreCore.getInstance().getLogger().log(Level.SEVERE, "Could not create file: " + file.getAbsolutePath());
            }
        }else {
            file.delete();

            try {
                file.createNewFile();
            }catch(IOException e) {
                OreCore.getInstance().getLogger().log(Level.SEVERE, "Could not create file: " + file.getAbsolutePath());
            }
        }

        try {
            java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllText(String path, String text) {
        java.io.File file = new java.io.File(path);
        writeAllText(file, text);
    }

    public static void writeAllText(java.io.File file, String text) {
        //CHECK IF FILE EXISTS, IF NOT, CREATE IT, OTHERWISE, OVERWRITE IT
        if(!file.exists()) {
            try {
                file.createNewFile();
            }catch(IOException e) {
                OreCore.getInstance().getLogger().log(Level.SEVERE, "Could not create file: " + file.getAbsolutePath());
            }
        }else {
            file.delete();

            try {
                file.createNewFile();
            }catch(IOException e) {
                OreCore.getInstance().getLogger().log(Level.SEVERE, "Could not create file: " + file.getAbsolutePath());
            }
        }

        try {
            java.io.FileWriter fw = new java.io.FileWriter(file);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
