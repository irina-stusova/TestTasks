//package com.company.core.helpers;
//
//import org.apache.commons.io.FileUtils;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.List;
//
//public class FileHelper {
//
//    public static List<File> getFilesFromDirByExtensions(String filePath, String[] extensions, boolean recursive) throws FileNotFoundException {
//        File file = new File(filePath);
//        if (file.exists()) {
//            return new LinkedList<>((file.isFile()
//                    ? Collections.singletonList(file)
//                    : FileUtils.listFiles(file, extensions, recursive)));
//        } else {
//            throw new FileNotFoundException();
//        }
//    }
//
//    public static String normalizeFileName(String fileName){
//        return fileName.replaceAll("[\\\\/:*?\"<>|]", "");
//    }
//}
