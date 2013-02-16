package cs145.kersten.assignment1;

import java.io.File;
import java.util.ArrayList;

/**
 * FileFilter is used to select only files with a specific extension from a folder
 * @author Andrew Kersten
 */
public class FileFilter implements java.io.FileFilter
{
    /** A list of valid extensions **/
    private ArrayList<String> extensions;
    
    /**
     * Initialize the extensions list to be empty, accept no files
     */
    public FileFilter()
    {
        extensions = new ArrayList<String>();
    }
    
    /**
     * Initialize the extension list to contain extension
     * @param extension is the file extension to accept
     */
    public FileFilter(String extension)
    {
        extensions = new ArrayList<String>();
        extensions.add(extension);
    }
    
    /**
     * Initialize the extension list to contain extensions
     * @param extensions is an array of file extensions to accept
     */
    public FileFilter(String[] extensions)
    {
        this.extensions = new ArrayList<String>();
        
        for (int i = 0; i < extensions.length; i++)
        {
            this.extensions.add(extensions[i]);
        }
    }
    
    /**
     * Add extension to the list of extensions to accept
     * @param extension is the extension to add
     * @return returns this to chain addExtension calls
     */
    public FileFilter addExtension(String extension)
    {
        extensions.add(extension);
        return this;
    }

    @Override
    public boolean accept(File file)
    {
        for (int i = 0; i < extensions.size(); i++)
        {
            if (file.getName().toLowerCase().endsWith(extensions.get(i)))
            {
                return true;
            }
        }
        
        return false;
    }
}
