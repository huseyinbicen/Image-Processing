
package imageprocessing.RGB_Works;

import cezeri.matrix.CMatrix;
import cezeri.utils.FactoryUtils;

public class filterMedian
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

        double[][] tempRED = FactoryUtils.clone(red);
        double[][] tempGREEN = FactoryUtils.clone(green);
        double[][] tempBLUE = FactoryUtils.clone(blue);
        
        int window = 9;
        double[] kernelRED = new double[window];
        double[] kernelGREEN = new double[window];
        double[] kernelBLUE = new double[window];
        
        for (int i = 1; i < ic - 1; i++)
        {
            for (int j = 1; j < ir - 1; j++)
            {
                int f = 0;
                for (int k = -1; k <= 1; k++)
                {
                    for (int l = -1; l <= 1; l++)
                    {
                        kernelRED[f] = red[i + k][j + l];
                        kernelGREEN[f] = green[i + k][j + l];
                        kernelBLUE[f] = blue[i + k][j + l];
                        f++;
                    }
                }
                
                tempRED[i][j] = medianKernel(kernelRED);
                tempGREEN[i][j] = medianKernel(kernelGREEN);
                tempBLUE[i][j] = medianKernel(kernelBLUE);
            }
        }
        
        d[1] = tempRED;
        d[2] = tempGREEN;
        d[3] = tempBLUE;
        
        cm.setArray(d).imshow();
        

    }

    private static double medianKernel(double[] kernel)
    {
        double buffer;
        for (int i = 0; i < kernel.length; i++)
        {
            for (int j = i; j < kernel.length; j++)
            {
                if (kernel[j] > kernel[i])
                {
                    buffer = kernel[j];
                    kernel[j] = kernel[i];
                    kernel[i] = buffer;
                }
            }
        }
        int mid = kernel.length / 2;
        return kernel[mid];
    }
}
