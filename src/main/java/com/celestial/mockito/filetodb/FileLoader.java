package com.celestial.mockito.filetodb;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


/**
 *
 * @author selvy
 */
public class FileLoader 
{
   private  class IntWrapper
   {
      public   int value;
   }
   
   String fileToLoad;
   List<String> lines = Collections.emptyList();

   public FileLoader(String fileToLoad) 
   {
       this.fileToLoad = fileToLoad;
   }

   int loadFile(String fname) 
   {
       try
       {
           lines = Files.readAllLines(Paths.get(fname), StandardCharsets.UTF_8);
       }
       catch (IOException e){}

       return calculateFileSize();
   }    

   private int calculateFileSize()
   {
       IntWrapper result = new IntWrapper();

       lines.forEach(line -> {
               result.value += line.length();
       });

       return result.value;
   }
}