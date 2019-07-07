package imageprocessing.GRAY_Works;

import cezeri.matrix.CMatrix;

public class filterMedian
{

    public static void main(String[] args)
    {
        CMatrix cm = CMatrix.getInstance()
                .imread("images//df.jpg")
                .rgb2gray()
                //              .imshow()
                //                .filterMedian(3)
                .imshow();

        int[][] d = cm.toIntArray2D();
        int w = d.length;
        int h = d[0].length;
        int[][] temp = new int[w][h];

        int window = 9;
        int[] kernel = new int[window];

        for (int i = 1; i < w - 1; i++)
        {
            for (int j = 1; j < h - 1; j++)
            {
                int f = 0;
                for (int k = -1; k <= 1; k++)
                {
                    for (int l = -1; l <= 1; l++)
                    {
                        kernel[f] = d[i + k][j + l];
                        f++;
                    }
                }
                temp[i][j] = medianKernel(kernel);

            }
        }

        cm.setArray(temp).imshow();

    }

    private static int medianKernel(int[] kernel)
    {
        int buffer;
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
