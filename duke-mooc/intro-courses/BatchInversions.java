import edu.duke.*;
import java.io.File;


public class BatchInversions {
    public ImageResource makeInversion(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel pixel: outImage.pixels()) {
           Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
           
           pixel.setRed(255-inPixel.getRed());
           pixel.setGreen(255-inPixel.getGreen());
           pixel.setBlue(255-inPixel.getBlue());
        }
        
        return outImage;
    }
    
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeInversion(inImage);
            String newName = "inv-" + inImage.getFileName();
            gray.setFileName(newName);
            gray.save();
            gray.draw();
        }
    }
    
    
    public void testGray() {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeInversion(ir);
        gray.draw();
    }
}
