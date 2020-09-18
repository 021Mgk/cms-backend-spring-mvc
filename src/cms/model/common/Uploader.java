package cms.model.common;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Uploader {
    private static  String UPLOAD_DIR  = "E:\\spring mvc\\cms\\images";



    public static void saveFile(InputStream inputStream , String fileName){
        try{
            String path = UPLOAD_DIR + File.separator + fileName;
            OutputStream outputStream =  new FileOutputStream(new File(path));
            int read = 0;
            byte []bytes = new byte[1024];
            while ((read =inputStream.read(bytes)) != -1){
                outputStream.write(bytes , 0 , read);
            }
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
