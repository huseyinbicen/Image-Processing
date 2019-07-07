package imageprocessing.Final_Exam;

import cezeri.matrix.CMatrix;

public class Show_Hist_Of_RGB
{

    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//lena_color.gif")
                .imshow()
                ;
        cm.getRedChannelColor().rgb2gray().imhist("Red").prevFirst();
        cm.getGreenChannelColor().rgb2gray().imhist("Green").prevFirst();
        cm.getBlueChannelColor().rgb2gray().imhist("Blue");
        
        double[][][] d = cm.getARGB();
//
//        CMatrix.getInstance().setArray(d[1]).imshow().imhist("Alpha");
//        CMatrix.getInstance().setArray(d[1]).imhist("Red");
//        CMatrix.getInstance().setArray(d[2]).imhist("Green");
//        CMatrix.getInstance().setArray(d[3]).imhist("Blue");
//
//        CMatrix.getInstance().imread("images//lena_color.gif").getRedChannelColor().rgb2gray().imhist("Red");
//        CMatrix.getInstance().imread("images//lena_color.gif").getGreenChannelColor().rgb2gray().imhist("Green");
//        CMatrix.getInstance().imread("images//lena_color.gif").getBlueChannelColor().rgb2gray().imhist("Blue");

    }
}
