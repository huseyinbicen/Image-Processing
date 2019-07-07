
package imageprocessing.Final_Exam;

import cezeri.matrix.CMatrix;
import cezeri.utils.FactoryUtils;

public class GaussianFilter
{
    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//cilli.jpg")
                .resize(512, 512)
                .imshow()
                ;
        double[][][] d = cm.getARGB();
        int ic = cm.getColumnNumber();
        int ir = cm.getRowNumber();
            
        double[][] red = d[1];
        double[][] green = d[2];
        double[][] blue = d[3];
        
        
        double[][] temp_red = FactoryUtils.clone(red);
        double[][] temp_green = FactoryUtils.clone(green);
        double[][] temp_blue = FactoryUtils.clone(blue);
        
        double[][] kernel = {
            {1,4,7,4,1},
            {4,16,26,16,4},
            {7,26,41,26,7},
            {4,16,26,16,4},
            {1,4,7,4,1}
        };
        
        kernel = CMatrix.getInstance().setArray(kernel).divideScalar(273).toDoubleArray2D();
        
//        for (int i = 1; i < 4; i++)
//        {
            for (int j = 2; j < ic - 2; j++)
            {
                for (int k = 2; k < ir - 2; k++)
                {
                    double sumRed = 0;
                    double sumGreen = 0;
                    double sumBlue = 0;
                    for (int l = -2; l <= 2; l++)
                    {
                        for (int m = -2; m <= 2; m++)
                        {
                            sumRed += red[j + l][k + m] * kernel[l+2][m+2];
                            sumGreen += green[j + l][k + m] * kernel[l+2][m+2];
                            sumBlue += blue[j + l][k + m] * kernel[l+2][m+2];
                        }
                    }
                    temp_red[j][k] = sumRed/kernel.length*kernel.length;
                    temp_green[j][k] = sumGreen/kernel.length*kernel.length;
                    temp_blue[j][k] = sumBlue/kernel.length*kernel.length;
                    
                    sumRed=0;
                    sumGreen= 0;
                    sumBlue = 0;
                }
            }
//        }

        d[1] = temp_red;
        d[2] = temp_green;
        d[3] = temp_blue;
        
        CMatrix.getInstance().setArray(d).imshow();


    }
}
