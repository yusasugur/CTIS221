/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileoperations;

/**
 *
 * @author xperiaW
 */
public class FileExtension {
    
        public static String getFileType(String fileExt) {
        String type = "";

        switch (fileExt) {
            case "java":
                type = "Java";
                break;

            case "c":
                type = "C";
                break;

            case "cpp":
                type = "C++";
                break;

            case "php":
                type = "PHP";
                break;

            case "js":
                type = "JavaScript";
                break;

            case "html":
                type = "HTML";
                break;

            case "json":
                type = "JSON";
                break;

            case "css":
                type = "CSS";
                break;

            case "sql":
                type = "SQL";
                break;

            case "xml":
                type = "XML";
                break;

            case "py":
                type = "Python";
                break;
            default:
                type = "Plain Text";
                break;
        }

        return type;
    }
    
}
