import hudson.model.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
 
 
def setKeyValueByProperties(key, value, file_path) {
    Properties prop = new Properties()
    try {
        prop.load(new FileInputStream(file_path))
    }catch (FileNotFoundException e){
        e.printStackTrace()
    }catch (IOException e) {
        e.printStackTrace()
    }
    
    // write into file 
    try {
        prop.setProperty(key, value)
	    FileOutputStream fos = new FileOutputStream(file_path)
        prop.store(fos, null)
        fos.close()
    }catch (FileNotFoundException e){
        e.printStackTrace()
    }catch (IOException e) {
        e.printStackTrace()
    }
}
 
def setKeyValueByWriteFile(key, value, file_path) {
    // read file, get string object
    file_content_old = readFile file_path
    println file_content_old
    //遍历每一行，判断，然后替换字符串
    lines = file_content_old.tokenize("\n")
    new_lines = []
    lines.each { line ->
        if(line.trim().startsWith(key)) {
            line = key + "='" + value + "'"
            new_lines.add(line)
        }else {
            new_lines.add(line)
        }
    }
    // write into file
    file_content_new = ""
    new_lines.each{line ->
        file_content_new += line + "\n"
    }
 
    writeFile file: file_path, text: file_content_new, encoding: "UTF-8"
}
return this;
