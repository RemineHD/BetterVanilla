package es.zaroz.orecore.utils.IO;

public class PathCombine {
    public static String Combine(String... paths) {

        StringBuilder sb = new StringBuilder();

        for (String path : paths) {
            if (path.startsWith("/")) {
                sb.append(path);
            } else {
                sb.append("/");
                sb.append(path);
            }
        }

        return sb.toString();
    }
}
